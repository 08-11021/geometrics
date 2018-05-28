package com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Figure;
import org.hibernate.SessionFactory;

import java.util.List;

public interface FigureBO {

    public void setSessionFactory(SessionFactory sessionFactory);

    public Figure getEntityById(Integer id);

    public Integer saveEntity(Figure figure);

    public List<Figure> getEntities();

    public Boolean deleteEntity(Figure figure);
}
