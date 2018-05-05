import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class RequestHandler implements Runnable {
  private Socket client;
  ServerSocket serverSocket = null;
  Comms newC;



    public RequestHandler(Socket client) {
      this.client = client;
      newC = new Comms(this.client);
    }

    @Override
    public void run() {
	System.out.println("Thread started with name:" + Thread.currentThread().getName());
	Conversation tmp;
	while ((tmp = newC.receiveMessage()) != null)
    {
        System.out.println("Received message from " + Thread.currentThread().getName() + " : " + tmp.getRequest());

        tmp.setAnswer("THis is your answer");

        newC.sendMessage(tmp);
    }
	

    }
    


}


