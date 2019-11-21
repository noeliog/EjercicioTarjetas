package ar.com.eldar.tarjetasdecredito.entities.behavior;

import java.time.LocalDate;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;

/**
 * TarjetaNaraBehavior
 */
public class TarjetaNaraBehavior implements TarjetaBehavior {

    @Override
    public double calcularTasa(Operacion operacion) {

        double diaDelMes = LocalDate.now().getDayOfMonth();
        double tasa = diaDelMes * 0.5 * operacion.getImporte();
        return tasa;
    }

}