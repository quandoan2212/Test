/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;

import com.minhquan.pojo.NhanVien;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Amin
 */
public class NhanVienServices {
    public static List<NhanVien> getNhanVien(){
        try(Session session = HibernateUtils.getSession().openSession()){
            Query<NhanVien> query = session.createQuery("FROM NhanVien");
            List<NhanVien> result = query.list();
            return result;
        }
    }
    
    public static void addNhanVien(NhanVien nv){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            session.save(nv);
            session.getTransaction().commit();
        }
    }
}
