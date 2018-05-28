package com.geopagos.figuras.rest_figuras_geometricas;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.CircleBO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.SquareBO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.TriangleBO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BOConf {

    @Bean(name = "Circulo")
    public CircleBO circle(){
        return new CircleBO();
    }

    @Bean(name = "Triangulo")
    public TriangleBO triangle(){
        return new TriangleBO();
    }

    @Bean(name = "Cuadrado")
    public SquareBO squareDAO(){
        return new SquareBO();
    }
}
