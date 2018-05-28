package com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO;

import javax.persistence.*;

@Entity
@Table(name = "Triangle")
public class Triangle implements Figure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "base")
    private Double base;
    @Column(name = "height")
    private Double height;

    public Triangle(){

    }

    public Triangle(Double base, Double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public Double getArea() {
        return this.getBase()*this.getHeight()/2.0;
    }

    @Override
    public Double getBase() {
        return this.base;
    }

    @Override
    public Double getHeight() {
        return this.height;
    }

    @Override
    public String getType() {
        return "Triangulo";
    }

    public void setId(int id) { this.id = id; }

    public void setBase(Double base) { this.base = base; }

    public void setHeight(Double height) { this.height = height; }
}
