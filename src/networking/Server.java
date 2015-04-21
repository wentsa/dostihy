/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Server extends Thread {

    private ServerSocket server = null;

    private final ArrayList<ClientThread> clients;

    private final int port;

    public Server(int port) throws IOException {
        this.port = port;
        clients = new ArrayList<>();
        server = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {

            while (true) {
                Socket s = server.accept();
                ClientThread client = new ClientThread(s);
                clients.add(client);
                client.start();
                //broadcast("pripojen", client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public String getServerName() {
        return server.getInetAddress().getHostAddress();
    }

    private synchronized void broadcast(String msg, ClientThread client) {
        String ip = client.socket.getInetAddress().getHostAddress();
        //msg = ip + ": " + msg;
        for (ClientThread c : getClients()) {
            if (c == client) {
                continue;
            }
            c.out.println(msg);
            c.out.flush();
        }
        //System.out.println(msg);
    }

    private synchronized ArrayList<ClientThread> getClients() {
        return clients;
    }

    private class ClientThread extends Thread {

        private Socket socket;
        private PrintStream out;
        private BufferedReader in;

        private ClientThread(Socket s) {
            try {
                this.socket = s;
                out = new PrintStream(socket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readLine();
                    if (message == null) {
                        break;
                    }
                    if (message.startsWith("/quit")) {
                        break;
                    } else {
                        broadcast(message, this);
                    }
                }
            } catch (IOException e) {
                System.err.println("Kvuli chybe odpojen klient.");
                e.printStackTrace(System.err);
            } finally {
                close(); //odpojit
            }
        }

        private void close() {
            broadcast("Odpojen.", this); //odeslat zprávu o odpojení
            getClients().remove(this); //vymazat ze seznamu
            try {
                out.close(); //zavřít výstupní proud
                in.close(); //zavřít vstupní proud
                socket.close(); //zavřít soket
            } catch (IOException e) {
            }
        }
    }
}
