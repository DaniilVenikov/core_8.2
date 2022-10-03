import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server started");
        int port = 8089;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                    System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                    out.println("Аre you ready to sign up to use the server? (yes/no)");
                    final String start = in.readLine();
                    if (start.equalsIgnoreCase("no")) {
                        System.out.println("Client initialize connections suicide ...");
                        out.println("Server reply - " + start + " - OK");
                        break;
                    }

                    out.println("Enter your name");
                    final String name = in.readLine();
                    System.out.println("Name: " + name);

                    out.println("Enter your email");
                    final String email = in.readLine();
                    System.out.println("Email: " + email);

                    out.println("Enter your age");
                    final int age = Integer.parseInt(in.readLine());
                    if(age < 18){
                        System.out.println("The client is too small");
                        out.println("Server reply - You are still too young.");
                        break;
                    }
                    System.out.println("Age: " + age);

                    out.println("Are you child? (yes/no)");
                    String flag = in.readLine();
                    if (flag.equals("yes")){
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s!" +
                                " Have a good rest, or a good working day!", name));
                    }
                    break;
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
