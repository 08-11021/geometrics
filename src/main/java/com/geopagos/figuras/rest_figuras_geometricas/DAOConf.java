package com.geopagos.figuras.rest_figuras_geometricas;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Triangle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.CircleDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.SquareDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.TriangleDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConf {

    @Bean(name = "Circulo")
    public CircleDAO circle(){
        return new CircleDAO();
    }

    @Bean(name = "Triangulo")
    public TriangleDAO triangle(){
        return new TriangleDAO();
    }

    @Bean(name = "Cuadrado")
    public SquareDAO squareDAO(){
        return new SquareDAO();
    }
}
