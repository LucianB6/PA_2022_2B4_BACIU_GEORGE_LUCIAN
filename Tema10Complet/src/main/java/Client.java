import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client
{
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;
    private DataInputStream in = null;
    ArrayList<String> words = new ArrayList<>();


    public Client(String address, int port) throws IOException {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            System.out.println("Write a command!");
            System.out.println("If you write \"Stop\" command, you'll stop the current program!");

            input = new DataInputStream(System.in);
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        String line = "";
        String user = "";
        String register = "";

        while (!line.equals("Stop"))
        {
            socket.setSoTimeout(10*1000);

            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }

            if(line.equals("Login")) System.out.println("Enter your usernamm!");
            if(line.equals("Register")) System.out.println("Welcome to Lab10! Please enter a new username");

            else System.out.println("Server received the command!");

            if(line.equals("Login")){
                try{
                    user = input.readLine();

                    if(user.equals(register)){

                        out.writeUTF(user);
                        System.out.printf("Login access approved\n");
                    }
                    else System.out.printf("This user doesn't exist!\n");

                } catch (IOException i){
                    System.out.println(i);
                }
            }
            if(line.equals("Register")){
                try{
                    register = input.readLine();

                    if(user.equals(register)){
                        System.out.printf("User already registered! Please enter another username!\n");
                    }
                    else{
                        out.writeUTF(register);
                        System.out.printf("Welcome!\n");
                    }
                } catch (IOException i){
                    System.out.println(i);
                }
            }
            if(line.equals("Friends")){
                System.out.printf("Hello! " + user + " You can add some friends! This is the logged user list:\n");

                BufferedReader br = new BufferedReader(new FileReader("login.txt"));

                String loggedUsers;

                while ((loggedUsers = br.readLine()) != null) {
                    System.out.println(loggedUsers);
                }
                if(line.equals(user)){
                    System.out.printf("User " + user + "added " + user);
                }
            }
            if (line.equals("Send")){
                System.out.printf("Please enter the message that you want to send: \n");

                Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
                System.out.print(user + " ");
                String str= sc.nextLine(); //reads string.


                String loggedUsers;
                BufferedReader br = new BufferedReader(new FileReader("login.txt"));

                while ((loggedUsers = br.readLine()) != null) {
                    System.out.println(loggedUsers + " " + user + " a trimis un mesaj: " + str);
                }

            }
        }

        PrintWriter fw = new PrintWriter("login.txt");
        fw.println("\0");


        System.out.println("Server Stopped");
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[]) throws IOException {
        Client client = new Client("localhost", 5000);



    }
}
