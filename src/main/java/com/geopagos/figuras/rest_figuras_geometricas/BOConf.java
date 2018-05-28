package com.geopagos.figuras.rest_figuras_geometricas;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Triangle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BOConf {

    @Bean(name = "Circulo")
    public Circle circle(){
        return new Circle();
    }

    @Bean(name = "Triangulo")
    public Triangle triangle(){
        return new Triangle();
    }

    @Bean(name = "Cuadrado")
    public Square square(){
        return new Square();
    }
}
