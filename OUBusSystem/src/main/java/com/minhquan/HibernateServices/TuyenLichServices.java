/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;


import com.minhquan.pojo.LichTrinhChuyenDi;
import com.minhquan.pojo.TuyenDuong;
import com.minhquan.pojo.TuyenDuongLichTrinh;
import com.minhquan.pojo.XeKhach;
import java.sql.Time;
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
public class TuyenLichServices {
    private static CriteriaBuilder builder;
    private static CriteriaQuery<TuyenDuongLichTrinh> query;
    private static Root<TuyenDuongLichTrinh> root;
    
    public static List<TuyenDuongLichTrinh> getTDLT(){
        try(Session session = HibernateUtils.getSession().openSession()){
            Query<TuyenDuongLichTrinh> query1 = session.createQuery("FROM TuyenDuongLichTrinh");
            List<TuyenDuongLichTrinh> result = query1.list();
            return result;
        }
    }
    
    public static void addTDLT(String maXe,String maTuyen,String maLich){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            TuyenDuongLichTrinh tl = new TuyenDuongLichTrinh();
            XeKhach x = session.get(XeKhach.class, maXe);
            TuyenDuong td = session.get(TuyenDuong.class, maTuyen);
            LichTrinhChuyenDi lt = session.get(LichTrinhChuyenDi.class, maLich);
            tl.setXe(x);
            tl.setTuyenDuong(td);
            tl.setLichTrinh(lt);
            session.save(tl);
            session.getTransaction().commit();
        }
    }
    
    public static List<TuyenDuongLichTrinh> getFilterTDLT(String departure,String location){
        try(Session session = HibernateUtils.getSession().openSession()){
            builder = session.getCriteriaBuilder();
            query = builder.createQuery(TuyenDuongLichTrinh.class);
            root = query.from(TuyenDuongLichTrinh.class);
            Root<TuyenDuong> tRoot = query.from(TuyenDuong.class);
            Predicate join = builder.equal(tRoot.get("maTuyenDuong"), root.get("tuyenDuong"));
            Predicate p1 = builder.equal(tRoot.get("departure"), departure);
            Predicate p2 = builder.equal(tRoot.get("location"), location);
            query.where(join,p1,p2);
          
            query.select(root);
            Query<TuyenDuongLichTrinh> q = session.createQuery(query);
            
            List<TuyenDuongLichTrinh> result = q.getResultList();
            return result;
        }
    }
    
    public static List<TuyenDuongLichTrinh> getFilterTDLT(Time t1,Time t2){
        try(Session session = HibernateUtils.getSession().openSession()){
            builder = session.getCriteriaBuilder();
            query = builder.createQuery(TuyenDuongLichTrinh.class);
            root = query.from(TuyenDuongLichTrinh.class);
            Root<LichTrinhChuyenDi> lRoot = query.from(LichTrinhChuyenDi.class);
            Predicate join = builder.equal(lRoot.get("maLichTrinh"), root.get("lichTrinh"));
            Predicate p1 = builder.between(lRoot.get("timeDepart").as(Time.class),t1,t2);
            
            query.where(join,p1);
          
            query.select(root);
            Query<TuyenDuongLichTrinh> q = session.createQuery(query);
            
            List<TuyenDuongLichTrinh> result = q.getResultList();
            return result;
        }
    }
}
