import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Comms implements AutoCloseable {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Conversation currentMessage;


    public Comms(Socket connect)
    {
        this.socket=connect;
        this.setUpStreams();
    }


    private void setUpStreams()
    {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void sendMessage(Object o)
    {
        try {
            output.writeObject(o);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Conversation receiveMessage()
    {
        try {
            output.flush();
            currentMessage=(Conversation)input.readObject();
        } catch (EOFException ex)
        {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return currentMessage;
    }


    @Override
    public void close() {
        try {
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




