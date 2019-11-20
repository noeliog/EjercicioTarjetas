package ar.com.eldar.tarjetasdecredito.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta;
import ar.com.eldar.tarjetasdecredito.entities.Tarjeta.TarjetaType;
import ar.com.eldar.tarjetasdecredito.models.response.OperacionResponse;
import ar.com.eldar.tarjetasdecredito.models.response.TasaResponse;
import ar.com.eldar.tarjetasdecredito.services.OperacionService;
import ar.com.eldar.tarjetasdecredito.services.TarjetaService;
import ar.com.eldar.tarjetasdecredito.services.OperacionService.OperacionValidation;

/**
 * TarjetaController
 */
@RestController
public class TarjetaController {


    @Autowired
    OperacionService operacionService;

    @Autowired
    TarjetaService tarjetaService;
    
    @GetMapping("/tarjetas/prueba")
    public Tarjeta getPruebaTarjetaInfo() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setMarca(TarjetaType.VISA);
        tarjeta.setNroTarjeta("12345602587213");
		tarjeta.setCardHolder("Juan Gomez");
		
		Date vto = new Date(2019,12,12);
        tarjeta.setFechaVto(vto); //ver



        return tarjeta;

    }

    @PostMapping("/operaciones")
    public OperacionResponse postValidarOperacion(@RequestBody Operacion operacion) {
        
        OperacionResponse r = new OperacionResponse();
        OperacionValidation o = operacionService.validar(operacion.getImporte());

        r.isOk = o == OperacionValidation.OPERACION_VALIDA;


        return r;


        
    }

    @PostMapping("/operaciones/tasas")
    public TasaResponse postGetTasa(@RequestBody Operacion operacion) {
        
        TasaResponse r = new TasaResponse();
        double tasa = tarjetaService.calcularTasa(operacion);

        r.isOk = true; 
        r.importeTasa = tasa;


        return r;

    }

    
}