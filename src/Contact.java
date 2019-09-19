public class Contact{
    // fields
    private String name;
    private    int sent;
    private    int rece;

    //default constructor
    public Contact(){
        this.name = null;
        this.sent =    0;
        this.rece =    0;
    }

    //custom constructor
    public Contact(String name, int sent, int rece){
        this.name = name;
        this.sent = sent;
        this.rece = rece;
    }

    public String getName(){
        return this.name;
    }

    public int getSent(){
        return this.sent;
    }

    public int getReceived(){
        return this.rece;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSent(int sent){
        this.sent = sent;
    }

    public void setReceived(int rece){
        this.rece = rece;
    }

    public String toString(){
        System.out.println(name +"|"+(getSent() + getReceived()));
        return name;
    }
}

