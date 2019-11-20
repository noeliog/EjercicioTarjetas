package ar.com.eldar.tarjetasdecredito.entities.behavior;

import java.time.LocalDate;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta.TarjetaType;
import ar.com.eldar.tarjetasdecredito.services.TarjetaService.TarjetaValidationType;

/**
 * TarjetaMasterBehavior
 */
public class TarjetaAmexBehavior implements TarjetaBehavior {

 
    @Override
    public double calcularTasa(Operacion operacion) {
        double mes = LocalDate.now().getMonth().getValue();
        double tasa = mes * 0.1 * operacion.getImporte();
        return tasa;
    }

    

    
}