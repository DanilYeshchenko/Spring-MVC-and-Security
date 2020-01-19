package com.model;

import javax.persistence.*;

/**
 * Created by User on 09.06.2017.
 */
@Entity
@Table(name = "cat", schema = "cat", catalog = "")
public class CatEntity {
    private int catId;
    private String name;
    private int weight;

    @Id
    @Column(name = "cat_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatEntity catEntity = (CatEntity) o;

        if (catId != catEntity.catId) return false;
        if (weight != catEntity.weight) return false;
        if (name != null ? !name.equals(catEntity.name) : catEntity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + weight;
        return result;
    }
}
