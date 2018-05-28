package com.geopagos.figuras.rest_figuras_geometricas;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Triangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VOConf {

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
