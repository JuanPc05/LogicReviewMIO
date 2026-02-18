package com.logicHotel.hotel.model;

import java.time.LocalDate;

public class Huesped {
    private final int id; // identidad inmutable
    private String nombre;
    private String documento;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Habitacion habitacion; // relación

    public Huesped(int id, String nombre, String documento) {
        if(nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if(documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }

        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void realizarIngreso(Habitacion habitacion, LocalDate fechaIngreso) {
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        habitacion.ocupar();
    }

    public void realizarSalida(Habitacion habitacion) {

        if(habitacion == null) {
            throw new IllegalArgumentException("El huésped no tiene habitación asignada.");
        }
        if (fechaSalida.isBefore(fechaIngreso)) {
            throw new IllegalArgumentException("La fecha de salida no puede ser anterior a la de ingreso.");
        }

        this.fechaSalida = fechaSalida;
        habitacion.liberar();
        this.habitacion = null;

    }

    @Override
    public String toString() {
        return "Huesped{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                ", habitacion=" + (habitacion != null ? habitacion.getNumero() : "Sin asignar") +
                '}';
    }

}
