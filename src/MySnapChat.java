import java.io.*;
import java.util.Scanner;

/**
 * This is a program to evaluate
 * social meadia contacts and
 * their interactions
 *
 * @author Erick Avalos
 * @since September 4, 2018
 */

public class MySnapChat{


    /*
     * This is the main method with the purpose of
     * reading a file, storing contact info, and
     * writing and output file with the info
     */
    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(new File("contacts.txt"));
//        scan.close();
        int contacts = scan.nextInt();//determines value to determine size
        scan.nextLine();
        Contact[] names = new Contact[contacts];//creates new object with size of determined value
        int count = 0;

        while(scan.hasNext()){//loop to read each line and split the info
            String info = scan.nextLine();
            String[] token = info.split(",");//splits each line by comma
            String name = token[0];
            int sent = Integer.parseInt(token[1]);
            int rece = Integer.parseInt(token[2]);
            Contact c = new Contact(name, sent, rece);
            names[count] = c;
            count++;
        }

        PrintWriter output = new PrintWriter("statistics.txt");//creates a new file and prints info
        output.print("Contacts: ");
        for(int i = 0; i < names.length; i++){
            output.print(names[i]+",");
        }
        output.println();//moves cursor down
        output.println("Average number of sent messages is: "+ getAverageSent(names));
        output.println("Average number of received messages is: "+ getAverageReceived(names));
        output.println("Individual with the most meassage sent was: "+findMaxSent(names));
        output.println("Individual with the most meassage received was: "+findMaxReceived(names));
        output.println("Individual with the least meassage sent was: "+findMinSent(names));
        output.println("Individual with the least meassage received was: "+findMinReceived(names));
        output.close();
    }

    /**
     * The purpose of this method is to print(display)
     * the contacts and number of messages through
     * using toString.
     *
     * @param c This is the contact info
     */
    public static void printContacts(Contact[] c){
        Contact c1 = new Contact();
        System.out.println(c1.toString());//calls toString
    }

    /**
     * The purpose of this method is to calculate
     * the averages of sent messages
     *
     * @param c This is the contact info
     * @return Returns the average sent
     */
    public static double getAverageSent(Contact[] c){
        int sum = 0;
        for(int i = 0; i < c.length; i++){
            sum = sum + c[i].getSent();//gets sent messages and adds
        }
        return (double) sum/c.length;//determines average
    }

    /** The purpose of this method is to calculate
     * the average of received messages
     *
     * @param c This is the contact info
     * @return Returns the average received
     */
    public static double getAverageReceived(Contact[] c){
        int sum = 0;
        for(int i = 0; i < c.length; i++){
            sum = sum + c[i].getReceived();//gets received messages and adds
        }
        return (double) sum/c.length;//determines average
    }

    /**
     * The purpose of this method is to
     * determine which contact has sent
     * the most amount of messages
     *
     * @param c This is the contact info
     * @return Returns the name of the contact
     */
    public static String findMaxSent(Contact[] c){
        int max = c[0].getSent();
        int x = 0;
        for(int i = 1; i < c.length; i++){
            if(max < c[i].getSent()){//compares values
                max = c[i].getSent();//determines max sent
                x = i;
            }
        }
        return c[x].getName();//determines matching contact name
    }

    /**
     * The purpose of this method is to
     * determine which contact has received
     * the most amount of messages
     *
     * @param c This is the contact info
     * @return Returns the name of the contact
     */
    public static String findMaxReceived(Contact[] c){
        int max = c[0].getReceived();
        int x = 0;
        for(int i = 1; i < c.length; i++){
            if(max < c[i].getReceived()){//compares values
                max = c[i].getReceived();//determin max received
                x = i;
            }
        }
        return c[x].getName();//determines matching contact name
    }

    /**
     * The purpose of this method is to
     * determine which contact has sent
     * the least amount of messages
     *
     * @param c This is the contact info
     * @return Returns the name of the contact
     */
    public static String findMinSent(Contact[] c){
        int min = c[0].getSent();
        int x = 0;
        for(int i = 1; i < c.length; i++){
            if(min > c[i].getSent()){//compares values
                min = c[i].getSent();//determines min sent
                x = i;
            }
        }
        return c[x].getName();//determines matching contact name
    }

    /**
     * The purpose of this method is to
     * determine which contact has received
     * the least amount of messages
     *
     * @param c This is the contact info
     * @return Returns the name of the contact
     */
    public static String findMinReceived(Contact[] c){
        int min = c[0].getReceived();
        int x = 0;
        for(int i = 1; i < c.length; i++){
            if(min > c[i].getReceived()){//compares values
                min = c[i].getReceived();//determines min received
                x = i;
            }
        }
        return c[x].getName();//determines matching contact name
    }
}


