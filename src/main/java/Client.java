import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;

        try(Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (!clientSocket.isOutputShutdown()) {

                String flag = in.readLine();
                System.out.println(flag);
                String start_flag = reader.readLine();
                out.println(start_flag);
                if (start_flag.equalsIgnoreCase("no")) {
                    System.out.println("Client kill connections");
                    int c = in.read();
                    if (c > -1) {
                        System.out.println("reading...");
                        //String ms = (char) c + in.lines().collect(Collectors.joining());
                        String ms = (char) c + in.readLine();
                        System.out.println(ms);
                    }
                    break;
                }


                String name = in.readLine();
                System.out.println(name);
                String replay1 = reader.readLine();
                out.println(replay1);

                String email = in.readLine();
                System.out.println(email);
                String replay2 = reader.readLine();
                out.println(replay2);

                String age = in.readLine();
                System.out.println(age);
                String reply3 = reader.readLine();
                out.println(reply3);
                if(Integer.parseInt(reply3) < 18){
                    int c = in.read();
                    if (c > -1) {
                        System.out.println("reading...");
                        String ms = (char) c + in.readLine();
                        System.out.println(ms);
                    }
                    break;
                }

                String child = in.readLine();
                System.out.println(child);
                String reply4 = reader.readLine();
                out.println(reply4);

                String end = in.readLine();
                System.out.println(end);
                break;

            }
            System.out.println("Closing connections & channels on clientSide - DONE.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
