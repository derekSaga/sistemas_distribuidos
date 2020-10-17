package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import util.Comunicacao;
import util.Mensagem;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */

public class Atende extends Thread {
    Socket cliente;
    Comunicacao comunicacao;
    ArrayList<Atende> atendimentos;

    public Atende(Socket sc, ArrayList<Atende> atendimentos) {
        this.cliente = sc;
        this.atendimentos = atendimentos;
        comunicacao = new Comunicacao(this.cliente);
        
    }

    @Override
    public void run() {
        Mensagem msg = null;
        boolean online = true;

        while (online) {
            msg = (Mensagem) comunicacao.receive();

            if (msg == null){
                online=false;
                atendimentos.remove(this);
            }else{
                for (Atende atende: atendimentos){
                    atende.enviar(msg);
                }
            }

        }
        
        try{
            cliente.close();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public void enviar(Mensagem msg) {
        comunicacao.send(msg);
    }

}
