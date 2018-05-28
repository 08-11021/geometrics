package com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO;

import javax.persistence.*;

@Entity
@Table(name = "Circle")
public class Circle implements Figure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "diameter")
    private Double diameter;
    final static Double pi = 3.14;

    public Circle(){}

    public Circle(Double diameter){
        this.diameter = diameter;
    }

    @Override
    public Double getArea() {
        Double radio = (diameter/2);
        return pi*radio*radio;
    }

    @Override
    public String getType() {
        return "Circulo";
    }

    @Override
    public Double getDiameter() {
        return this.diameter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }
}
