/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;


import com.minhquan.pojo.LoaiXe;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;

/**
 *
 * @author Amin
 */
public class LoaiXeServices {
    private static CriteriaBuilder builder;
    private static CriteriaQuery<LoaiXe> query;
    private static Root<LoaiXe> root;
    
    public static List<LoaiXe> getLoaiXe(){
        try(Session session = HibernateUtils.getSession().openSession()){
            Query<LoaiXe> query = session.createQuery("SELECT * FROM LoaiXe ");
            List<LoaiXe> list = query.list();
            return list;
        }
    }
    
    public static void addLoaiXe(LoaiXe l){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            session.save(l);
            session.getTransaction().commit();
        }
    }
    
    public static List<LoaiXe> getLoaiTheoGia(int price1, int price2){
        try(Session session = HibernateUtils.getSession().openSession()){
            builder = session.getCriteriaBuilder();
            query = builder.createQuery(LoaiXe.class);
            root = query.from(LoaiXe.class);
            query.select(root);
            
            Predicate p = builder.between(root.get("giaTien").as(Integer.class), price1, price2);
            query.where(p);
            
            Query<LoaiXe> q = session.createQuery(query);
            List<LoaiXe> result = q.getResultList();
            return result;
        }
    }
}
