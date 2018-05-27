package com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;

import java.util.List;

public interface FigureDAO {
    public Figure getEntityById(Integer id);

    public Integer saveEntity(Figure figure);

    public List<Figure> getEntities();

    public Boolean deleteEntity(Figure figure);
}
