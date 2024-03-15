package br.com.fiap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public void rodarServidor() throws IOException {
        System.out.println("Servidor iniciado");
        DatagramSocket socket = new DatagramSocket(5252);

        String mensagem = "";

        while(!mensagem.trim().equalsIgnoreCase("fim")){
            byte[] buffer = new byte[200];

            DatagramPacket datagram = new DatagramPacket(buffer, 200);
            socket.receive(datagram);

            System.out.println("Endereço: "+datagram.getSocketAddress());
            System.out.println("Mensagem: "+mensagem);
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.rodarServidor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

