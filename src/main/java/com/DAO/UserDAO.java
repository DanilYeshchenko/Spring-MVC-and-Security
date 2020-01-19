//package com.DAO;
//
//import com.model.User;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserDAO {
//    @Autowired
//    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//    @SuppressWarnings("unchecked")
//    public User findByUsername(String username){
//        List<User> list = new ArrayList<User>();
//        list = sessionFactory.getCurrentSession().
//                createQuery("from User where username = ?").
//                setParameter(0,  username).list();
//        if(list.size()>0){
//            return list.get(0);
//        }
//        else return null;
//    }
//    public User findByOuf(String username, String password){
//        Session session = this.sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from User as u where u.username = :username and u.password = :password");
//        query.setString("username", username);
//        query.setString("password", password);
//        List<User> list = query.list();
//        return username.isEmpty()?null:list.iterator().next();
//    }
//}
