package com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO;

public interface Figure {

    default Double getArea(){
        return null;
    }

    default Double getBase(){
        return null;
    }

    default Double getHeight(){
        return null;
    }

    default String getType(){
        return null;
    }

    default Double getDiameter(){
        return null;
    }

}
