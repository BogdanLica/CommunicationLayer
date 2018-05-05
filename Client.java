import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Usage: java Client <port number> <clientNo>");
      System.exit(1);
    }
    
    Conversation first = new Conversation("Hhhhh"); 
    Conversation second = new Conversation("AAAA");
        
    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);

    
    
    
    try (Socket echoSocket = new Socket(hostName, portNumber);
         Comms newC = new Comms(echoSocket);
         BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            if(userInput.equals("1"))
            {

                newC.sendMessage(first);
                Conversation ans = newC.receiveMessage();
                System.out.println(ans.getAnswer());
            }

            else if(userInput.equals("2"))
            {
                newC.sendMessage(second);
                Conversation ans = newC.receiveMessage();
                System.out.println(ans.getAnswer());
            }
        }





      
      
      
    }catch (UnknownHostException e) {
       System.err.println("Don't know about host " + hostName);
       System.exit(1);
    }catch (IOException e) {
       System.err.println("Couldn't get I/O for the connection to " + hostName);
       System.exit(1);
    }
    catch (NullPointerException e)
    {
        System.err.println("The object received is null");
    }
  }
}

