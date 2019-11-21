package ar.com.eldar.tarjetasdecredito.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.eldar.tarjetasdecredito.entities.behavior.TarjetaAmexBehavior;
import ar.com.eldar.tarjetasdecredito.entities.behavior.TarjetaBehavior;
import ar.com.eldar.tarjetasdecredito.entities.behavior.TarjetaNaraBehavior;
import ar.com.eldar.tarjetasdecredito.entities.behavior.TarjetaVisaBehavior;


/**
 * Tarjeta
 */

public class Tarjeta {

    public enum TarjetaType {
        VISA, NARA, AMEX
    }

    private TarjetaType marca;
    private String nroTarjeta;
    private String cardHolder;
    private Date fechaVto;

    @JsonIgnore
    private TarjetaBehavior behavior;

    public Tarjeta(TarjetaType marca, String nroTarjeta, String cardHolder, Date fechaVto) {
        this.marca = marca;
        this.nroTarjeta = nroTarjeta;
        this.cardHolder = cardHolder;
        this.fechaVto = fechaVto;
    }

    public Tarjeta() {
    }

    public TarjetaType getMarca() {
        return marca;
    }

    public void setMarca(TarjetaType marca) {
        this.marca = marca;
        switch (marca) {
            case VISA:
                this.setBehavior(new TarjetaVisaBehavior());
                break;
            case NARA:
                this.setBehavior(new TarjetaNaraBehavior());
                break;
            case AMEX:
                this.setBehavior(new TarjetaAmexBehavior());
                break;
    
            default:
                break;
            }
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String string) {
        this.nroTarjeta = string;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    
    }

    public void setTarjeta(Operacion operacion) { // ver
    }

    @JsonIgnore
    public TarjetaBehavior getBehavior() {
        if (this.behavior == null){
            this.setMarca(this.getMarca());
        }
        return this.behavior;
    }

    public void setBehavior(TarjetaBehavior behavior) {
        this.behavior = behavior;
    }


    public double calcularTasa(Operacion operacion){
        return this.behavior.calcularTasa(operacion);
    } 

    @Override
    public String toString() {
        return "Tarjeta [behavior=" + behavior + ",cardHolder=" + cardHolder + ", fechaVto=" + fechaVto + ", marca="
                + marca + ", nroTarjeta=" + nroTarjeta + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        Tarjeta t2 = (Tarjeta)obj;
        return this.getNroTarjeta().equals(t2.getNroTarjeta()) &&
               this.getMarca() == t2.getMarca();
    }

     

}
