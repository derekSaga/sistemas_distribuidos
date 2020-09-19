import java.io.PrintStream;
import java.net.Socket;

public class Cliente {
    public static void main(final String[] args) {
        final int PORTA = 9876;
        Socket sktCliente = null;
        PrintStream saida = null;

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