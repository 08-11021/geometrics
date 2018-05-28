package com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO;

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

    default void setBase(Double base){}

    default void setHeight(Double height){}

    default void setLength(Double length){}

    default void setDiameter(Double diameter){}

}
