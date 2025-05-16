package com.ann.estetiCanina.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id_pago;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    @Column(name = "monto", precision = 7, scale = 2)
    private BigDecimal monto;

    @NotBlank
    @Size(max = 20)
    @Column(name = "tipo_pago")
    private String tipo_pago;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Pago() {
    }

    public Pago(Long id_pago, Venta venta, BigDecimal monto, String tipo_pago, LocalDate fecha) {
        this.id_pago = id_pago;
        this.venta = venta;
        this.monto = monto;
        this.tipo_pago = tipo_pago;
        this.fecha = fecha;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

