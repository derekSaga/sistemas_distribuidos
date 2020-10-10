package util;

import java.io.Serializable;

/**
 * Requisicao: Dados enviados para o servidor
 */

public class Requisicao implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private double numero1, numero2;
    private char operacao;

    public Requisicao(double numero1, double numero2, char operacao) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
    }

    public double getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public char getOperacao() {
        return operacao;
    }

}
