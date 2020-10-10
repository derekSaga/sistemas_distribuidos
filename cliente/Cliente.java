package cliente;

import java.net.Socket;
import java.util.Scanner;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Cliente {
    final static int PORTA = 9876;

    public static void main(String[] args) {
        java.util.Scanner teclado = new Scanner(System.in);
        Socket clienteSocket;
        double valor1, valor2;
        char operacao;

        try {
            clienteSocket = new Socket("127.0.1", PORTA);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Falha ao conectar com o servidor.");
            teclado.close();
            return;
        }
        
        System.out.println("* Calculadora Distribuida: *");
        System.out.println("* Digite o primeiro valor: *");
        valor1 = Double.parseDouble(teclado.nextLine());
        System.out.println("* Digite o segundo valor: *");
        valor2 = Double.parseDouble(teclado.nextLine());
        System.out.println("* Digite a operação (+ - * /): *");
        operacao = teclado.nextLine().charAt(0);

        Requisicao requisicao = new Requisicao(valor1, valor2, operacao);

        Comunicacao comunicacao = new Comunicacao(clienteSocket);

        comunicacao.send(requisicao);

        Resposta resposta = (Resposta) comunicacao.receive();
        
        if(resposta.getStatus() == Resposta.OK){
            System.out.println("Resultado: " + resposta.getResultado());
        }else if(resposta.getStatus() == Resposta.OPERADOR_INVALIDO){
            System.out.println("Operação não suportada.");
        }else{
            System.out.println("Erro: divisão por zero.");
        }

        try{
            clienteSocket.close();
        }catch (Exception e){
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }

        teclado.close();

    }
}
