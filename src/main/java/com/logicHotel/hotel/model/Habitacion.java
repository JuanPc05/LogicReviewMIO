package com.logicHotel.hotel.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Habitacion {
    private final int id;
    private int numero;
    private String tipo;
    private BigDecimal precioPorNoche;
    private EstadoHabitacion estado;

    public Habitacion(int id, int numero, String tipo, BigDecimal precioPorNoche) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    /*
    * GETTERS
    * */
    public int getId() {
        return id;
    }
    public int getNumero() {
        return numero;
    }
    public String getTipo() {
        return tipo;
    }

    public BigDecimal getPrecioPorNoche() {
        return precioPorNoche;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    /*
    * COMPORTAMIENTO
    * */

    public void ocupar() {
        if (estado != EstadoHabitacion.DISPONIBLE) {
            throw new IllegalStateException("La habitación no está disponible");
        }
        estado = EstadoHabitacion.OCUPADA;
    }

    public void enviarMantenimiento(){
        estado = EstadoHabitacion.MANTENIMIENTO;
    }

    public void actualizarPrecio(BigDecimal nuevoPrecio){
        if(nuevoPrecio.compareTo(precioPorNoche) <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        this.precioPorNoche = nuevoPrecio;
    }

    /*
    * Equals & hashCode: Estos se usan para explicarle a java que dos habitaciones
    * son las mismas si tienen el mismo id, con equals podemos construir un metodo
    * que le indique esto, y con hashCode reescribimos su "espacio" para indicar
    * el punto de la memoria
    * */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        /*
        * instanceof me dice si un objeto aqui con alias de o, es el mismo
        * como si fuera una comparacion
         * */
        if(!(o instanceof Habitacion that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precioPorNoche +
                ", estado=" + estado +
                '}';
    }
}
