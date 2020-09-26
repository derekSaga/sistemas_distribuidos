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
        String msg = null;

        // bind - solicitar uma porta ao SO
        try {
            sktServer = new ServerSocket(PORTA);
        } catch (Exception e) {
            System.out.println("Porta " + PORTA + " em uso.");
            return;
        }
        do{
            // aguarda um pedido de conexão
            try {
                System.out.println("Aguardando conexão.");
                sktCliente = sktServer.accept();
                entrada = new Scanner(sktCliente.getInputStream());
                System.out.println("Conectado com " + sktCliente.getInetAddress().getHostAddress());
                
                saida = new PrintStream(sktCliente.getOutputStream());
    
            } catch (Exception e) {
                System.out.println("Erro no processo de conexão.");
                return;
            }
    
            // etapa de comunicação
    
            try {
                msg = entrada.nextLine();
                while(!msg.equals("exit") && !msg.equals("fechar")){
                    System.out.println("Mensagem Recebida: " + msg);
                    saida.println("Mensagem recebida");
                    msg = entrada.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Erro durante a comunicação com o cliente.");
            }
        }while(!msg.equals("fechar"));
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