package com.geopagos.figuras.rest_figuras_geometricas.Factory;

import com.geopagos.figuras.rest_figuras_geometricas.BOConf;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
    private ApplicationContext factory = new AnnotationConfigApplicationContext(BOConf.class);

    public Factory(){
    }

    public Figure getFigure(String type){
        return (Figure)factory.getBean(type);

    }

}
