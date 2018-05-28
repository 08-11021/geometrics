package com.geopagos.figuras.rest_figuras_geometricas.Factory;

import com.geopagos.figuras.rest_figuras_geometricas.BOConf;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.FigureBO;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BOFactory {
    private ApplicationContext factory = new AnnotationConfigApplicationContext(BOConf.class);
    private SessionFactory sessionFactory;

    public BOFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public FigureBO getDAO(String type){
        FigureBO figureBO = ((FigureBO)factory.getBean(type));
        figureBO.setSessionFactory(sessionFactory);
        return figureBO;
    }
}
