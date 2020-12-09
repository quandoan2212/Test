/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;

import com.minhquan.pojo.LoaiXe;
import com.minhquan.pojo.XeKhach;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Amin
 */
public class XeKhachServices {
    private static CriteriaBuilder builder;
    private static CriteriaQuery<XeKhach> query;
    private static Root<XeKhach> root;
    
    public static void addXeKhach(XeKhach x,String maLoaiXe){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            LoaiXe l = session.get(LoaiXe.class,maLoaiXe);
            x.setLoaiXe(l);
            session.save(x);
            session.getTransaction().commit();
        }
    }
    
    public static List<XeKhach> getXeKhachbyLoaiXe(String maLoaiXe){
        try(Session session = HibernateUtils.getSession().openSession()){
            LoaiXe l = session.get(LoaiXe.class,maLoaiXe);
            List<XeKhach> result = new ArrayList<>();
            l.getXekhach().forEach(x -> result.add(x));
            return result;
        }
    }
    
    public static List<XeKhach>getXeKhach(String kw){
        try(Session session = HibernateUtils.getSession().openSession()){
            builder = session.getCriteriaBuilder();
            query = builder.createQuery(XeKhach.class);
            root = query.from(XeKhach.class);
            query.select(root);
            
            Predicate p1 = builder.like(root.get("bienSoXe").as(String.class),String.format("%%%s%%" , kw));
            query.where(p1);
            Query<XeKhach> q = session.createQuery(query);
            List<XeKhach> result = q.getResultList();
            return result;
        }
    }
    
}
