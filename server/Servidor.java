package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */
public class Servidor {
    private static ArrayList<Atende> atendimentos = new ArrayList<>();
    public static void main(String[] args) {
        final int PORTA = 9876;
        ServerSocket srv;
        Socket cliente;
        
        try{
            srv = new ServerSocket(PORTA);
            while(true){
                System.out.println("Aguardando Conexão....");
                cliente = srv.accept();
                Atende atende = new Atende(cliente, atendimentos);
                atendimentos.add(atende);
                atende.start();
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

}
