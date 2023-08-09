package com.example.ToDoList.ToDoList;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class ToDoList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea") 
    private Long id; // Identificador de la tarea

    private String name; 

    private String apellido;

    private String  descripcion; 

    private LocalDate dateInicio; // Fecha de inicio

    private LocalDate dateFin; // Fecha de fin

    private int plazo; // plazo para terminar la tarea

    private boolean estado;




    public ToDoList() {
    }


    public ToDoList(Long id, String name,String apellido,String descripcion, LocalDate dateInicio, LocalDate dateFin,int plazo,boolean estado) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
        this.plazo = plazo;
        this.estado = estado;
    }

    public ToDoList(String name,String apellido,String descripcion, LocalDate dateInicio, LocalDate dateFin,int plazo,boolean estado) {
        this.name = name;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
        this.plazo = plazo;
        this.estado = estado;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getapellido() {
        return this.apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getdescripcion() {
        return this.descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public LocalDate getdateInicio() {
        return this.dateInicio;
    }

    public void setdateInicio(LocalDate dateInicio) {
        this.dateInicio = dateInicio;
    }

    public LocalDate getdateFin() {
        return this.dateFin;
    }

    public void setdateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getplazo() {
        return this.plazo;
    }

    public void setplazo(int plazo) {
        this.plazo = plazo;
    }

    public Boolean getestado(){
        return estado;
    }

    public void setestado(boolean estado) {
        this.estado = estado;
    }
}
