package br.com.fiap;

import java.net.*;
import java.util.Scanner;

public class Client {

    public void comunicarServidor() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 5252;

        String texto ="";
        Scanner entrada = new Scanner(System.in);

        while(!texto.trim().equalsIgnoreCase("fim")){
            System.out.println("Digite uma mensagem: ");
            texto = entrada.nextLine();
            byte saida[];
            saida = texto.getBytes();

            DatagramPacket datagram = new DatagramPacket(saida, saida.length, address, port);
            socket.connect(address, port);
            System.out.println("Pacote enviado...");
        }
    }

    public static void main(String[] args) {
        try{
            Client client = new Client();
            client.comunicarServidor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
