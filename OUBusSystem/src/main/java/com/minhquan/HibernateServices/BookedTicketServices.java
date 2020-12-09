/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;


import com.minhquan.pojo.BookedTicket;
import com.minhquan.pojo.KhachHang;
import com.minhquan.pojo.NhanVien;
import com.minhquan.pojo.TuyenDuongLichTrinh;
import java.sql.Date;
import java.sql.Time;
import java.util.GregorianCalendar;
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
public class BookedTicketServices {
     private static CriteriaBuilder builder;
    private static CriteriaQuery<BookedTicket> query;
    private static Root<BookedTicket> root;

    public static boolean allowBook(int tuyenLich, Date ngayKH) {
        try (Session session = HibernateUtils.getSession().openSession()) {
            TuyenDuongLichTrinh tdlt = session.get(TuyenDuongLichTrinh.class, tuyenLich);
            Time lt = tdlt.getLichTrinh().getTimeDepart();
            GregorianCalendar t = new GregorianCalendar(ngayKH.getYear(), ngayKH.getMonth(),
                    ngayKH.getDay(), lt.getHours(), lt.getMinutes(), lt.getSeconds());
            GregorianCalendar time = new GregorianCalendar();
            int h = t.getTime().getHours() - time.getTime().getHours();
            boolean m = t.getTime().getMinutes() == time.getTime().getMinutes();

            /**
             * *
             * kiem tra neu cung ngay cung thang,neu thoi diem khoi hanh hon
             * thoi diem hien tai 1 tieng thi dat duoc, con neu thoi diem khoi
             * hanh bang voi thoi diem hien tai thi kiem tra toi so phut cua 2
             * thoi diem
            **
             */
            if (t.getTime().getDay() == time.getTime().getDay()
                    && t.getTime().getMonth() == time.getTime().getMonth()) {
                if (h > 1) {
                    return true;
                } else if (h == 1) {
                    if (m) {
                        return true;
                    }
                }
            }

            /**
             *
             * Kiem tra lich trinh vao khoang 00:00 cua ngay hom sau 
             * Lich trinh luc 0h  
             * Neu thoi diem dat la < 23:00 thi set true con nguoc lai thi false
             */
            if (t.getTime().getDay() == time.getTime().getDay() + 1
                    && t.getTime().getMonth() == time.getTime().getMonth()) {
                if (tdlt.getLichTrinh().getTimeDepart().getHours() == 0) {
                    if (Math.abs(h) < 23) {
                        return true;
                    } else if (Math.abs(h) == 23) {
                        if (time.getTime().getMinutes() == t.getTime().getMinutes()) {
                            return true;
                        }
                    }
                }else
                    return true;
            }
            
            /***
             * Sau khi kiem tra cung ngay va 00:00 ngay hom sau thi neu ngay Dat ve khong roi vao nhung truong hop tren thi auto la true
             */
            int d = t.getTime().getDay() -  time.getTime().getDay();
            if(Math.abs(d) != 1){
                return true;
            }
        }
        return false;
    }

    public static int bookTicket(int tuyenLich, int khachHang, String nhanVien, String maGhe, Date ngayKH) {
        try (Session session = HibernateUtils.getSession().openSession()) {
            session.getTransaction().begin();
            TuyenDuongLichTrinh tl = session.get(TuyenDuongLichTrinh.class, tuyenLich);
            KhachHang kh = session.get(KhachHang.class, khachHang);
            NhanVien nv = session.get(NhanVien.class, nhanVien);
            BookedTicket bt = new BookedTicket(tl, kh, nv, maGhe, ngayKH);
            session.save(bt);
            session.getTransaction().commit();
            return bt.getId();
        }
    }

    public static BookedTicket getBookedTicket(int id) {
        try (Session session = HibernateUtils.getSession().openSession()) {
            builder = session.getCriteriaBuilder();
            query = builder.createQuery(BookedTicket.class);
            root = query.from(BookedTicket.class);
            Predicate p = builder.equal(root.get("id"), id);
            query.where(p);
            query.select(root);

            Query<BookedTicket> q = session.createQuery(query);
            BookedTicket result = q.getSingleResult();
            return result;
        }
    }

    public static void updateIsGet(int id) {
        try (Session session = HibernateUtils.getSession().openSession()) {
            session.getTransaction().begin();
            BookedTicket bt = session.get(BookedTicket.class, id);
            bt.setIsGet(true);
            session.update(bt);
            session.getTransaction().commit();
            System.out.println("Da in ve");
        } catch (Exception ex) {
            System.out.println("In ve that bai");
        }
    }
    
    public static void updateIsCancel(int id){
        try (Session session = HibernateUtils.getSession().openSession()) {
            session.getTransaction().begin();
            BookedTicket bt = session.get(BookedTicket.class, id);
            bt.setIsCancel(true);
            session.update(bt);
            session.getTransaction().commit();
            System.out.println("Da huy ve");
        } catch (Exception ex) {
            System.out.println("Huy ve that bai");
        }
    }
}
