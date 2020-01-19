package com.DAO;

import com.model.CatEntity;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public interface IDAO {
    public List<CatEntity> showCat();
    public void addCat(CatEntity cat);
    public void deleteCat(int id);
    public CatEntity searchCat(int id);
    public void updateCat(CatEntity cat);
}
