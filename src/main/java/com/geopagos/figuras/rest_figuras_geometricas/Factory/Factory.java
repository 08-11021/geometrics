package com.geopagos.figuras.rest_figuras_geometricas.Factory;

import com.geopagos.figuras.rest_figuras_geometricas.VOConf;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Figure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Factory {
    private ApplicationContext factory = new AnnotationConfigApplicationContext(VOConf.class);

    public Factory(){
    }

    public Figure getFigure(String type){
        return (Figure)factory.getBean(type);

    }

}
