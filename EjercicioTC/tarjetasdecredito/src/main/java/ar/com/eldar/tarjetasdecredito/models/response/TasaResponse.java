package ar.com.eldar.tarjetasdecredito.models.response;

import ar.com.eldar.tarjetasdecredito.entities.Tarjeta.TarjetaType;

/**
 * TasaResponse
 */
public class TasaResponse {

    public boolean isOk = false;
    public String message = "";
    public double importeTasa;
    public TarjetaType marca;
}