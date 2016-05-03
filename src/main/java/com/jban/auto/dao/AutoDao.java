package com.jban.auto.dao;

import com.jban.auto.model.Automobile;
import java.util.List;

public interface AutoDao {
    public void addAuto(Automobile auto);

    public void updateAuto(Automobile auto);

    public void deleteAuto(int id);

    public Automobile getAutoById(int id);

    public List<Automobile> listAutos();
}
