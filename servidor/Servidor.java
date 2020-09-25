import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class Servidor {
    public static void main(String[] args) {
        final int PORTA = 9876;
        ServerSocket sktServer = null;
        Socket sktCliente = null;
        Scanner entrada;
        PrintStream saida = null;

        // bind - solicitar uma porta ao SO
        try {
            sktServer = new ServerSocket(PORTA);
        } catch (Exception e) {
            System.out.println("Porta " + PORTA + " em uso.");
            return;
        }

        // aguarda um pedido de conexão
        try {
            System.out.println("Aguardando conexão.");
            sktCliente = sktServer.accept();
            entrada = new Scanner(sktCliente.getInputStream());
            System.out.println("Conectado com " + sktCliente.getInetAddress().getHostAddress());
            
            
            saida = new PrintStream(sktCliente.getOutputStream());
            saida.println("Mesangem recebida trouxa");
        } catch (Exception e) {
            System.out.println("Erro no processo de conexão.");
            return;
        }

        // etapa de comunicação

        try {
            String msg = entrada.nextLine();
            System.out.println("Mensagem Recebida: " + msg);
        } catch (Exception e) {
            System.out.println("Erro durante a comunicação com o cliente.");
        }
        // encerra a conexão
        try {
            sktCliente.close();
            sktServer.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro ao encerar a conexão.");
        }
    }
}