package com.geopagos.figuras.rest_figuras_geometricas.Factory;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
    private static BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
    private Figure figure;

    public Factory(String type){
        this.figure = (Figure)factory.getBean(type);
    }

    public Figure getFigure(){
        return figure;
    }

}
