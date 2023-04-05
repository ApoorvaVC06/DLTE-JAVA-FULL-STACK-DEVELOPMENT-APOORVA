package banking;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class TicketOperations implements Ticketinterface {
    Scanner scanner=new Scanner(System.in);
    private Map<String,Ticket> ticketDetails=new TreeMap<>();

    @Override
    public void createTicket() {
        System.out.println("Enter the ticket id :");
        String id= scanner.next();

        if(ticketDetails.containsKey(id)){
            System.out.println("Ticket ID exists already! Enter another one :");
            id= scanner.next();
        }
        System.out.println("Enter the issue ");
        String tissue= scanner.next();

        System.out.println("Enter the card number :");
        String card_no = scanner.next();
        String card_regex ="\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        if (!card_no.matches(card_regex)){
            System.out.println("Invalid Card number, Enter again");
            card_no = scanner.next();
        }

        String date_regex = "\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        System.out.println("Enter the date in the format (DDMMYYYY)");
        String dateOfTicket = scanner.next();
        if (dateOfTicket.matches(date_regex)){
            System.out.println("Enter the date in correct format :");
            dateOfTicket = scanner.next();
        }

        System.out.println("Enter the status of the ticket :");
        String tstatus = scanner.next();

        System.out.println(id+tissue+card_no+dateOfTicket+tstatus);
        Ticket ticket = new Ticket(id,tissue,card_no,dateOfTicket,tstatus);
        ticketDetails.put(id,ticket);
        System.out.println("A ticket is generated");
        return ;
    }

    @Override
    public void updateTicket() {
        System.out.println("Enter the ticket ID of the ticket you wish to update :");
        String id = scanner.next();
        if(!ticketDetails.containsKey(id)){
            System.out.println("The entered key does not exist! Re-enter an existing one:");
            id=scanner.next();
        }
        System.out.println("Enter the updated details:");
        System.out.println("Enter the issue ");
        String tissue= scanner.next();

        System.out.println("Enter the card number :");
        String card_no = scanner.next();
        String card_regex ="\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        if (!card_no.matches(card_regex)){
            System.out.println("Invalid Card number, Enter again");
            card_no = scanner.next();
        }

        String date_regex = "\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        System.out.println("Enter the date in the format (DDMMYYYY)");
        String dateOfTicket = scanner.next();
        if (dateOfTicket.matches(date_regex)){
            System.out.println("Enter the date in correct format :");
            dateOfTicket = scanner.next();
        }

        System.out.println("Enter the status of the ticket :");
        String tstatus = scanner.next();

        Ticket updatedticket = new Ticket(id,tissue,card_no,dateOfTicket,tstatus);
        ticketDetails.put(id,updatedticket);
    }

    public Map<String, Ticket> getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(Map<String, Ticket> ticketDetails) {
        this.ticketDetails = ticketDetails;
    }
}
