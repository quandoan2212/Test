/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;

import com.minhquan.pojo.BookedTicket;
import com.minhquan.pojo.KhachHang;
import com.minhquan.pojo.LichTrinhChuyenDi;
import com.minhquan.pojo.LoaiXe;
import com.minhquan.pojo.NhanVien;
import com.minhquan.pojo.Ticket;
import com.minhquan.pojo.TuyenDuong;
import com.minhquan.pojo.TuyenDuongLichTrinh;
import com.minhquan.pojo.XeKhach;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author Amin
 */
public class HibernateUtils {
    private final static SessionFactory FACTORY;
    
    static{
        Configuration conf = new Configuration();
        Properties prop = new Properties();
        prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        prop.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        prop.put(Environment.URL, "jdbc:mysql://localhost:3306/bussystem");
        prop.put(Environment.USER,"root");
        prop.put(Environment.PASS, "minhquan2212");
        
        conf.setProperties(prop);
        conf.addAnnotatedClass(LoaiXe.class);
        conf.addAnnotatedClass(XeKhach.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(TuyenDuong.class);
        conf.addAnnotatedClass(TuyenDuongLichTrinh.class);
        conf.addAnnotatedClass(LichTrinhChuyenDi.class);
        conf.addAnnotatedClass(Ticket.class);
        conf.addAnnotatedClass(BookedTicket.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(registry);
    }
    public static SessionFactory getSession(){
        return FACTORY;
    }
}
