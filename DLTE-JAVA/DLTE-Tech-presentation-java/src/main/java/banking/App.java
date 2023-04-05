package banking;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.Map;
import java.io.IOException;
import java.util.Scanner;

public class App {

        private static File file=new File("ticket.doc");
        private static FileOutputStream fileOutputStream=null;
        private static ObjectOutputStream objectOutputStream=null;
        private static FileInputStream fileInputStream=null;//new FileInputStream(file);
        private static ObjectInputStream objectInputStream=null;

        public static Map<String,Ticket> readRecords(){
        try{
           fileInputStream =new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);

            Map<String,Ticket> buffer = (Map<String, Ticket>)objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return buffer;
        }
        catch(IOException | ClassNotFoundException e){}
        return null;
    }

        public static void writeRecords(Map<String,Ticket> ticketDetails){
        try{

            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(ticketDetails);

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException io){}
    }


        public static void main( String[] args )
        {
            Scanner sc = new Scanner(System.in);
            TicketOperations operations = new TicketOperations();
            int choice;
            do{
                System.out.println("Hello Customer!\n Welcome!");
                System.out.println("Menu\n1.Create Ticket\n2.Update Ticket\n3.Exit\nEnter your choice:");
                choice=sc.nextInt();
                switch (choice){
                    case 1:
//                    operations.getTicket(readRecords());
                        operations.createTicket();
                        writeRecords(operations.getTicketDetails());
                        break;

                    case 2:
                        operations.setTicketDetails(readRecords());
                        operations.updateTicket();
                        writeRecords(operations.getTicketDetails());
                        break;

                    default:return;

                }

            }while (true);
}}
