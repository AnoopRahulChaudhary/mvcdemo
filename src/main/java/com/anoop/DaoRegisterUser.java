package com.anoop;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoRegisterUser {

 public boolean register(String userName , String userPass)



 {
   EntityUserDetail entityUserDetail = new EntityUserDetail();


   entityUserDetail.setName(userName);
   entityUserDetail.setPassword(userPass);

   SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
   Session session = sessionFactory.openSession();
   session.beginTransaction();
   try
   {
     session.save(entityUserDetail);
     session.getTransaction().commit();
     //session.close();
   }catch (Exception e){
     return false;
   }
   return true;
 }

}
