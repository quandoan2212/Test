/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;

import com.minhquan.pojo.KhachHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
/**
 *
 * @author Amin
 */
public class KhachHangServices {
     public static List<KhachHang> getKH(){
        try(Session session = HibernateUtils.getSession().openSession()){
            Query<KhachHang> query = session.createQuery("FROM KhachHang");
            List<KhachHang> result = query.list();
            return result;
        }
    }
    
    public static void addKH(KhachHang kh){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            session.save(kh);
            session.getTransaction().commit();
        }
    }
}
