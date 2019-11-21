package ar.com.eldar.tarjetasdecredito.services;

import org.springframework.stereotype.Service;

import ar.com.eldar.tarjetasdecredito.entities.Operacion;

/**
 * OperacionService
 */
@Service
public class OperacionService {

    public enum OperacionValidation {
        OPERACION_VALIDA, OPERACION_INVALIDA;

    }

    public  OperacionValidation validar(double importe) {
        
        if (Operacion.getImporte() > 1000)
            return OperacionValidation.OPERACION_INVALIDA;

        return OperacionValidation.OPERACION_VALIDA;
    }

    public enum Resultados {
        IMPRESORA_ATASCADA, IMPRESORA_FALTAPAPEL, IMPRESORA_SINCONEXION, IMPRESION_OK, HOST_TARJETA_CAIDO, HOST_OK,
        SISTEMA_CONTABLE_NO_RESPONDE, SISTEMA_CONTABLE_OK, DB_NO_PERMITE_ESCRIBIR_NUEVO_SALDO, DB_OK
    }

    public Resultados imprimirFC(Operacion operacion) {
        // Aca hago todos mi procedimiento de conexion y genero un resultado final
        // por ejemplo devuelvo
        return Resultados.IMPRESORA_FALTAPAPEL;
    }

    public Resultados enviarInfoTC(Operacion operacion) {
        // Aca hago todos mi procedimiento de conexion y genero un resultado final
        // por ejemplo devuelvo
        return Resultados.HOST_TARJETA_CAIDO;
    }

    public Resultados informarPago(Operacion operacion) {
        // Aca hago todos mi procedimiento de conexion y genero un resultado final
        // por ejemplo devuelvo
        return Resultados.SISTEMA_CONTABLE_NO_RESPONDE;
    }

    public Resultados actualizarSaldo(int cliente) {
        // Aca hago todos mi procedimiento de conexion y genero un resultado final
        // por ejemplo devuelvo
        return Resultados.DB_NO_PERMITE_ESCRIBIR_NUEVO_SALDO;
    }

    public Resultados cobrar(Operacion operacion) {

        Resultados r = this.imprimirFC(operacion);

        if (r != Resultados.IMPRESION_OK) {
            System.out.print("Fallo al imprimir " + r.toString());
            return r;
        }

        r = this.enviarInfoTC(operacion);

        if (r != Resultados.HOST_OK) {
            System.out.print("Fallo al enviar " + r.toString());
            return r;
        }

        r = this.informarPago(operacion);

        if (r != Resultados.SISTEMA_CONTABLE_OK) {
            System.out.print("Fallo al informar pago " + r.toString());
            return r;
        }

        r = this.actualizarSaldo(operacion.getCliente());

        if (r != Resultados.DB_OK) {
            System.out.print("Fallo al actualizar saldo " + r.toString());
            return r;
        }

        return r;

    }

	public static OperacionService validar(Operacion operacion) {
		return null;
	}



}