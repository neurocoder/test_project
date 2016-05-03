package com.jban.auto.model;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Automobile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "makecar")
    private String makeCar;

    @Column(name = "modelcar")
    private String modelCar;

    @Column(name = "coast")
    private int coast;

    @Column(name = "year")
    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakeCar() {
        return makeCar;
    }

    public void setMakeCar(String makeCar) {
        this.makeCar = makeCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "id=" + id +
                ", makeCar='" + makeCar + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", coast=" + coast +
                ", year=" + year +
                '}';
    }
}
