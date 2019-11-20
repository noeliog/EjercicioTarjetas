package ar.com.eldar.tarjetasdecredito.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta;

/**
 * TarjetaService
 */
public class TarjetaService {

    public enum TarjetaValidationType {
        TARJETA_VALIDA_PARA_OPERAR, OPERACION_VALIDA, TARJETA_UNICA;

    }

    public  TarjetaValidationType validarTarjeta(Tarjeta tarjeta) {
        if (tarjeta.getFechaVto().after(new Date()) != true)

            return TarjetaValidationType.TARJETA_VALIDA_PARA_OPERAR;

        return TarjetaValidationType.OPERACION_VALIDA;

    }

    public  boolean compararTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2) {
        return (tarjeta1.equals(tarjeta2));


    }

    public  String getInformacion(Tarjeta tarjeta) {
        return tarjeta.toString();
    }
    public double calcularTasa(Operacion operacion){
        return operacion.getTarjeta().calcularTasa(operacion);
    } 


}