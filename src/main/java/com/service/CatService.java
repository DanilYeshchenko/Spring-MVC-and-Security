package com.service;

import com.DAO.DAO;
import com.model.CatEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public class CatService {
    DAO dao;
    public void setDao(DAO dao) {
        this.dao = dao;
    }
    @Transactional
    public List<CatEntity> showCat(){
        return dao.showCat();
    }
    @Transactional
    public void addCat(CatEntity cat){
        dao.addCat(cat);
    }
    @Transactional
    public void deleteCat(int id){
        dao.deleteCat(id);
    }
    @Transactional
    public void editCat(CatEntity cat){
        dao.editCat(cat);
    }
    @Transactional
    public CatEntity searchCat(int id) {
        return dao.searchCat(id);
    }
}