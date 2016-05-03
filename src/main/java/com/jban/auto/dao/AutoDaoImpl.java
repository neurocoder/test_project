package com.jban.auto.dao;

import com.jban.auto.model.Automobile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AutoDaoImpl implements AutoDao {
    private static final Logger logger = LoggerFactory.getLogger(AutoDao.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAuto(Automobile auto) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(auto);
        logger.info("Automobile seccessfully saved; info: " + auto);
    }

    @Override
    public void updateAuto(Automobile auto) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(auto);
        logger.info("Automobile seccessfully updated; info: " + auto);
    }

    @Override
    public void deleteAuto(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Automobile auto = (Automobile) session.load(Automobile.class, new Integer (id));
        if(auto!=null){
            session.delete(auto);
            logger.info("Automobile seccessfully deleted; info: " + auto);
        }

    }

    @Override
    public Automobile getAutoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Automobile auto = (Automobile) session.load(Automobile.class, new Integer(id));
        if (auto!=null){
            logger.info("Automobile seccessfully loaded by id; info: " + auto);
            return auto;
        }
        logger.info("Automobile is not loaded by id");
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Automobile> listAutos() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Automobile> autoList = session.createQuery("from auto").list();

        for (Automobile auto : autoList){
            logger.info("Automobile list : "+ auto);
        }
        return autoList;
    }
}
