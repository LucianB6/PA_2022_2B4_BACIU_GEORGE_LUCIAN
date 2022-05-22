import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.FILE;

public class Server
{
    private Socket		 socket = null;
    private ServerSocket server = null;
    private DataInputStream in	 = null;
    File file = new File("login.txt");
    int id = 0;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";
            String user = "";
            String register = "";

            ArrayList<String> words = new ArrayList<>();

            while (!line.equals("Stop")) {

                socket.setSoTimeout(10*1000);

                try {
                    line = in.readUTF();
                    System.out.println("Client wrote the commend: " + line);
                } catch (IOException i) {
                    System.out.println(i);
                }
                try
                {
                    Scanner s = new Scanner(file);
                    while(s.hasNext())
                    {
                        words.add(s.next());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (line.equals("Register")){
                    try{
                        register = in.readUTF();

                            FileWriter reg = new FileWriter("register.txt", true);
                            BufferedWriter bw = new BufferedWriter(reg);
                            bw.write(register + "\n");
                            bw.close();


                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (line.equals("Login")) {
                    try {
                        user = in.readUTF();
                            try {
                                if(user.equals(register)) {
                                    FileWriter fw = new FileWriter("login.txt", true);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    bw.write(id + ". " + user + "\n");
                                    bw.close();
                                    id++;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch(IOException i){
                            System.out.println(i);
                        }
                    }
                }

            PrintWriter fw = new PrintWriter("login.txt");
            fw.println("\0");
            fw.close();

            PrintWriter reg = new PrintWriter("register.txt");
            reg.println("\0");
            reg.close();

                socket.close();
                in.close();

        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[]){

        Server server = new Server(5000);

    }
}
