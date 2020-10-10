package util;

import java.io.Serializable;

/**
 * Resposta: Dados retornados para o cliente
 */

public class Resposta implements Serializable {
    /**
     *
     */
    public final static int OK = 0;
    public final static int OPERADOR_INVALIDO = 1;
    public final static int DIVISAO_POR_ZERO = 2;

    private static final long serialVersionUID = 1L;
    private double resultado;
    private int status;

    public Resposta(double resultado, int status){
        this.resultado = resultado;
        this.status = status;
    }

    public Resposta(){}

    public double getResultado() {
        return resultado;
    }

    public int getStatus() {
        return status;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
