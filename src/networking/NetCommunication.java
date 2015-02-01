/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author root
 */
public class NetCommunication {

    private static Server server;
    private static Client client;

    private static int port;
    private static String IP;

    public static void zalozHru() {
        port = 10785;
        while (true) {
            try {
                server = new Server(port);
                server.start();
                break;
            } catch (IOException ex) {
                port++;
            }
        }
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isLoopback() || !iface.isUp()) { //127.xxx loopback
                    continue;
                }
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    String tmp=addr.getHostAddress();
                    if(     tmp.startsWith("192.168.")          //local IP
                            || tmp.startsWith("10.")            //local IP
                            || tmp.startsWith("172.16.")        //local IP
                            || tmp.startsWith("172.31.")        //local IP
                            || tmp.startsWith("169.254")        //single network IP
                            || tmp.equals("255.255.255.255")) { //broadcast address
                        continue;
                    }
                    IP=tmp;
                    System.out.println("-----" + IP);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        client=new Client(port, IP);
    }
    
    public static int getPort() {
        return port;
    }
    
    public static String getIP() {
        return IP;
    }

    public static void pripojSeDoHry(int port) {
        IP="localhost";
        client=new Client(port, IP);
    }
    
    public static void posli(String msg) {
        client.send(msg);
    }
    
    public static String pockejNaOdpoved() {
        return client.receive();
    }

}
