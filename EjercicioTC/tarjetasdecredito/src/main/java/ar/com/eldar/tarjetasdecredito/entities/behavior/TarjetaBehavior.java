package ar.com.eldar.tarjetasdecredito.entities.behavior;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;

public interface TarjetaBehavior {

	public double calcularTasa(Operacion operacion);

}