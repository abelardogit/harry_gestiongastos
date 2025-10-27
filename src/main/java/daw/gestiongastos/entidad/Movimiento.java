package daw.gestiongastos.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // ❗ Si no lo usas, bórralo (lo mismo para los métodos)

import java.sql.Date;

@Entity

public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idMovimiento;
    double monto;
    String movimientoTipo;
    Date fechaMovimiento; // Mejor LocalDateTime
    String descripcion;
    String categoria;


    public Movimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimiento(Integer idMovimiento, double monto, String movimientoTipo, Date fechaMovimiento, String descripcion, String categoria) {
        this.idMovimiento = idMovimiento;
        this.monto = monto;
        this.movimientoTipo = movimientoTipo;
        this.fechaMovimiento = fechaMovimiento;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Movimiento() {

    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "idMovimiento=" + idMovimiento +
                ", monto=" + monto +
                ", movimientoTipo='" + movimientoTipo + '\'' +
                ", fechaMovimiento=" + fechaMovimiento +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMovimientoTipo() {
        return movimientoTipo;
    }

    public void setMovimientoTipo(String movimientoTipo) {
        this.movimientoTipo = movimientoTipo;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
