/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;

import com.minhquan.pojo.TuyenDuong;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
/**
 *
 * @author Amin
 */
public class TuyenDuongServices {
    public static List<TuyenDuong> getTuyenDuong(){
        try(Session session = HibernateUtils.getSession().openSession()){
            Query<TuyenDuong> query = session.createQuery("FROM TuyenDuong");
            List<TuyenDuong> result = query.list();
            return result;
        }
    }
    
    public static void addTuyenDuong(TuyenDuong td){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            session.save(td);
            session.getTransaction().commit();
        }
    }
}

