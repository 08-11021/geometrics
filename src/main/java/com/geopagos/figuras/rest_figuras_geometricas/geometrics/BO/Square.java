package com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO;

import javax.persistence.*;

@Entity
@Table(name = "Square")
public class Square implements Figure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "length")
    private Double length;

    public Square(){

    }

    public Square(Double length){
        this.length = length;
    }

    @Override
    public Double getArea() {
        return this.getBase()*this.getBase();
    }

    @Override
    public Double getBase() {
        return this.length;
    }

    @Override
    public Double getHeight() {
        return this.length;
    }

    @Override
    public String getType() {
        return "Cuadrado";
    }

    public void setId(int id) { this.id = id; }

    public void setLength(Double length) { this.length = length; }
}
