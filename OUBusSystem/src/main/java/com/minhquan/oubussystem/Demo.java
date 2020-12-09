/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.oubussystem;

import com.minhquan.HibernateServices.LoaiXeServices;
import com.minhquan.pojo.LoaiXe;
//import java.util.ArrayList;
import java.util.List;
//import static javafx.application.Application.launch;

/**
 *
 * @author Amin
 */
public class Demo {
     public static void main(String[] args) {
        List<LoaiXe> list = LoaiXeServices.getLoaiXe();
        
         list.forEach((s) -> {
             System.out.println(s);
         }); 
    }
}
   
