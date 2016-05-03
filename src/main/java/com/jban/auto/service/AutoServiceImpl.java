package com.jban.auto.service;

import java.util.List;

import com.jban.auto.dao.AutoDao;
import com.jban.auto.model.Automobile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AutoServiceImpl implements AutoService {
    private AutoDao autoDao;

    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }


    @Override
    @Transactional
    public void addAuto(Automobile auto) {
        this.autoDao.addAuto(auto);
    }

    @Override
    @Transactional
    public void updateAuto(Automobile auto) {
        this.autoDao.updateAuto(auto);
    }

    @Override
    @Transactional
    public void deleteAuto(int id) {
        this.autoDao.deleteAuto(id);
    }

    @Override
    @Transactional
    public Automobile getAutoById(int id) {
        return this.autoDao.getAutoById(id);
    }

    @Override
    @Transactional
    public List<Automobile> listAutos() {
        return this.autoDao.listAutos();
    }
}
