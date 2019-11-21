package ar.com.eldar.tarjetasdecredito;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.eldar.tarjetasdecredito.entities.Tarjeta;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta.TarjetaType;
import ar.com.eldar.tarjetasdecredito.services.OperacionService;
import ar.com.eldar.tarjetasdecredito.services.TarjetaService;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testCalidarTarjeta() {

		//CREO UNA TARJETA
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setMarca(TarjetaType.VISA);
        tarjeta.setNroTarjeta("12345602587213");
		tarjeta.setCardHolder("Juan Gomez");
		
		Date vto = new Date(2019,12,12);
        tarjeta.setFechaVto(vto); //ver

        // DEVUELVO INFO DE TARJETA
        TarjetaService.getInformacion(tarjeta);

        //INFORMO SI UNA OPERACION ES VALIDA
        OperacionService.validar(800);

        //INFORMO SI UNA TARJETA ES VALIDA
        TarjetaService.validarTarjeta(tarjeta);

        //IDENTIFICO SI UNA TARJETA ES DISTINTA A OTRA
        Tarjeta otraTarjeta = new Tarjeta();
        otraTarjeta.setNroTarjeta("31556684889498");
        TarjetaService.compararTarjetas(tarjeta, otraTarjeta));


        //OBTENGO TASA INFORMANDO MARCA E IMPORTE
	}


	

}
