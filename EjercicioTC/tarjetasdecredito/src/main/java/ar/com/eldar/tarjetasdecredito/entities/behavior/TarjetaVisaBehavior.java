package ar.com.eldar.tarjetasdecredito.entities.behavior;

import java.time.LocalDate;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;

public class TarjetaVisaBehavior implements TarjetaBehavior {

    @Override
    public double calcularTasa(Operacion operacion) {
        double mes = LocalDate.now().getMonth().getValue();
        double tasa = LocalDate.now().getYear() / mes;
        return tasa;
    }

}