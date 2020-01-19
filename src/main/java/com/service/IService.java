package com.service;

import com.model.CatEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public interface IService {
    public List<CatEntity> showCat();
    public void addCat(CatEntity cat);
    public void deleteCat(int id);
    public CatEntity searchCat(int id);
    public void updateCat(CatEntity cat);
}
