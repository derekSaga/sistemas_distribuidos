import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(final String[] args) {
        final int PORTA = 9876;
        Socket sktCliente = null;
        PrintStream saida = null;
        Scanner entrada;

        // solicita uma conexão com o servidor
        try {
            sktCliente = new Socket("127.0.0.1", PORTA);
            System.out.println("Conexão feita.");

            saida = new PrintStream(sktCliente.getOutputStream());
        } catch (final Exception e) {
            System.out.println("Erro ao conectar ao servidor.");
        }

        // etapa de comunicação
        try{
            saida.println("cheguei porra");
            entrada = new Scanner(sktCliente.getInputStream());
            System.out.println("Mensagem: "+entrada.nextLine());
        }catch (final Exception e){
            System.out.println("Erro na etapa de comunicação.");
        }

        // encerra a conexão
        try {
            sktCliente.close();
            System.out.println("Conexão encerrada.");
        } catch (final Exception e) {
            System.out.println("Erro  ao encerrar a conexão.");
        }
    }
}