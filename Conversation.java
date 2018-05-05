import java.io.Serializable;

public class Conversation implements Serializable
{

    private Object request;
    private Object answer;
    
    
    
    public Conversation(Object request)
    {
    this.request = request;
    }
    
    
    
    
    public Object getRequest()
    {
        return this.request;
    }
    
    
    public Object getAnswer()
    {
        return this.answer;

    }
    
    
    public void setAnswer(Object answer)
    {
        this.answer = answer;
    }
}
