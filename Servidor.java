public class Servidor{
    public static void main(String[] args){
        final int PORTA = 9876
        ServerSocket sktServer = null;
        Socket sktCliente = null;

        // bind - solicitar uma porta ao SO
        try{
            sktServer = new ServerSocket(PORTA);
        }catch (Exception e){
            System.out.println("Porta "+PORTA+" em uso.");
            return;
        }
        
        // aguarda um pedido de conexão
        try{
            System.out.println("Aguardando conexão.");
            sktCliente = sktServer.accept();
            System.out.println("Conectado com " + sktCliente.getInetAddress().getHostAddress());
        }catch (Exception e){
            System.out.println("Erro no processo de conexão.");
            return;
        }

        // etapa de comunicação
        try{

        }catch (Exception e){
            
        }
        // encerra a conexão
    }
}