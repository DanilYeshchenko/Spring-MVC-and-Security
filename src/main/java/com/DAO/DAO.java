package com.DAO;

import com.model.CatEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
@Repository
public class DAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @SuppressWarnings("unchecked")
    public List<CatEntity> showCat(){
        Session session = this.sessionFactory.getCurrentSession();
        List<CatEntity> catList = session.createQuery("from CatEntity").list();
        return catList;
    }
    public void addCat(CatEntity cat){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cat);
    }
    public void deleteCat(int id){
        Session session = this.sessionFactory.getCurrentSession();
        CatEntity cat = (CatEntity) session.load(CatEntity.class, new Integer(id));
        session.delete(cat);
    }
    public void editCat(CatEntity cat){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cat);
    }
    public CatEntity searchCat(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CatEntity cat = (CatEntity) session.load(CatEntity.class, new Integer(id));
        cat.getName();
        return cat;
    }
}