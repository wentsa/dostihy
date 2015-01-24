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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Client {

    private Socket client = null;

    private PrintStream out = null;
    private BufferedReader in = null;

    public Client(int port, String host) {
        try {
            client = new Socket(host, port);
            out = new PrintStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void send(String msg) {
        System.out.println("<<<<<." + msg + ".");
        out.println(msg);
    }

    public String receive() {
        String msg=null;
        while (true) {
            try {
                msg=in.readLine();
                if(msg==null) continue;
                break;
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }

}
