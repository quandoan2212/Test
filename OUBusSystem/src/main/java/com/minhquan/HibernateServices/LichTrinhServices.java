/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;

import com.minhquan.pojo.LichTrinhChuyenDi;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Amin
 */
public class LichTrinhServices {
     public static List<LichTrinhChuyenDi> getLT(){
        try(Session session = HibernateUtils.getSession().openSession()){
            Query<LichTrinhChuyenDi> query = session.createQuery("FROM LichTrinhChuyenDi");
            List<LichTrinhChuyenDi> result = query.list();
            return result;
        }
    }
    
    public static void addLT(LichTrinhChuyenDi lt){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            session.save(lt);
            session.getTransaction().commit();
        }
    }
}
