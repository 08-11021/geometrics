package com.geopagos.figuras.rest_figuras_geometricas.Factory;

import com.geopagos.figuras.rest_figuras_geometricas.BOConf;
import com.geopagos.figuras.rest_figuras_geometricas.DAOConf;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.FigureDAO;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DAOFactory {
    private ApplicationContext factory = new AnnotationConfigApplicationContext(DAOConf.class);
    private SessionFactory sessionFactory;

    public DAOFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public FigureDAO getDAO(String type){
        FigureDAO figureDAO = ((FigureDAO)factory.getBean(type));
        figureDAO.setSessionFactory(sessionFactory);
        return figureDAO;
    }
}
