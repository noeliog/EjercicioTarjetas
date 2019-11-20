package ar.com.eldar.tarjetasdecredito.entities.behavior;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta.TarjetaType;
import ar.com.eldar.tarjetasdecredito.services.TarjetaService.TarjetaValidationType;


public interface TarjetaBehavior {

	public double calcularTasa(Operacion operacion);

	//public TarjetaValidationType validate(Tarjeta tarjeta);

    
}