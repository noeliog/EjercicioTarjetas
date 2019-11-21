package ar.com.eldar.tarjetasdecredito.entities;

import java.util.Date;

import ar.com.eldar.tarjetasdecredito.services.OperacionService.OperacionValidation;




/**
 * Operacion
 */

public class Operacion {

   private int cliente;
   private Tarjeta tarjeta;
   private Date fechaOperacion;
   private double importe;
   private String tipoOperacion;


   public Tarjeta getTarjeta() {
      return tarjeta;
   }

   public void setTarjeta(Tarjeta tarjeta) {
      this.tarjeta = tarjeta;
   }

   public Date getFechaOperacion() {
      return fechaOperacion;
   }

   public void setFechaOperacion(Date fechaOperacion) {
      this.fechaOperacion = fechaOperacion;
   }

   public double getImporte() {
      return importe;
   }

   public void setImporte(double importe) {
      this.importe = importe;
   }

   public String getTipoOperacion() {
      return tipoOperacion;
   }

   public void setTipoOperacion(String tipoOperacion) {
      this.tipoOperacion = tipoOperacion;
   }

   public int getCliente() {
      return cliente;
   }

   public void setCliente(int cliente) {
      this.cliente = cliente;
   }

   public Operacion(Tarjeta tarjeta, Date fechaOperacion, double importe, String tipoOperacion) {
      this.tarjeta = tarjeta;
      this.fechaOperacion = fechaOperacion;
      this.importe = importe;
      this.tipoOperacion = tipoOperacion;
   }

   public Operacion() {
   }

   @Override
   public String toString() {
      return "Operacion [fechaOperacion=" + fechaOperacion + ", importe=" + importe + ", tarjeta=" + tarjeta
            + ", tipoOperacion=" + tipoOperacion + "]";
   }

   public OperacionValidation validar(Operacion operacion) {
      return this.validar(operacion);

   }
}