/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.HibernateServices;


import com.minhquan.pojo.KhachHang;
import com.minhquan.pojo.NhanVien;
import com.minhquan.pojo.Ticket;
import com.minhquan.pojo.TuyenDuongLichTrinh;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
/**
 *
 * @author Amin
 */
public class TicketServices {
    private static CriteriaBuilder builder;
    private static CriteriaQuery<Ticket> query;
    private static Root<Ticket> root;
    
    
    public static List<Ticket> getTickets(){
        try(Session session = HibernateUtils.getSession().openSession()){
          builder = session.getCriteriaBuilder();
          query = builder.createQuery(Ticket.class);
          root = query.from(Ticket.class);
          
          query.select(root);
          Query<Ticket> q = session.createQuery(query);
          List<Ticket> kq = q.list();
          return kq;
        }
    } 
    
    public static boolean allowAddTicket(int tuyenLich){
        try(Session session = HibernateUtils.getSession().openSession()){
            TuyenDuongLichTrinh tdlt = session.get(TuyenDuongLichTrinh.class, tuyenLich);
            GregorianCalendar time = new GregorianCalendar();
            boolean d = tdlt.getLichTrinh().getTimeDepart().getDay() == time.getTime().getDay();
            boolean m = tdlt.getLichTrinh().getTimeDepart().getMonth() == time.getTime().getMonth();
            int h = tdlt.getLichTrinh().getTimeDepart().getHours() - time.getTime().getHours();
            int min = tdlt.getLichTrinh().getTimeDepart().getMinutes() - time.getTime().getMinutes();
            /***
             * kiem tra truong hop cung ngay cung thang
             * Trong truong hop nay chia ra 2 truong hop nua la cung gio hoac la cach nhau 1h(VD: time = 22:MM, t = 23:00)
             */
            if(m){
                if(d){
                    //Neu cung gio thi hieu so phut be hon 5 thi return ve false
                    if(h == 0){
                        if(min < 5)
                            return false; 
                    }else if(h < 0) //Neu hieu cua gio be hon 0 thi return thang ve 0 vi gio KH phai lon hon gio Mua ve
                        return false;
                    else if(h == 1) { //neu cach nhau 1h thi kiem tra hieu so phut cua hai thoi diem ma < 5 thi return false
                        if(Math.abs(min) < 5)
                            return false;
                    }
                } 
            }
        }
        return true;
    }
    
    public static void addTicket(String maNV, int maKH, GregorianCalendar printedDate,int tuyenLich,String maGhe,Date ngayKH){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            Ticket tk = new Ticket();
            NhanVien nv = session.get(NhanVien.class,maNV);
            KhachHang kh = session.get(KhachHang.class,maKH);
            TuyenDuongLichTrinh tl = session.get(TuyenDuongLichTrinh.class, tuyenLich);
            
            tk.setKhachHang(kh);
            tk.setNhanVien(nv);
            tk.setNgayInVe(printedDate);
            tk.setTuyenLich(tl);
            tk.setMaGhe(maGhe);
            tk.setNgayKH(ngayKH);
            
            session.save(tk);
            session.getTransaction().commit();            
        }
    }
    
    public static void delTicket(int idTicket){
        try(Session session = HibernateUtils.getSession().openSession()){
            session.getTransaction().begin();
            Ticket t = session.get(Ticket.class, idTicket);
            session.delete(t);
            
            session.getTransaction().commit();
        }
    }
}
