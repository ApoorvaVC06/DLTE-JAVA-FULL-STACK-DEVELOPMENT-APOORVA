package client;

import client.host.Card;
import client.host.CardCRUDLService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        client.host.CardCRUDLService service=new CardCRUDLService();
        client.host.CardCRUDL cardCRUDL=service.getCardCRUDLPort();
        client.host.ListOfCards list= cardCRUDL.showcards();
        for(client.host.Card object:list.getCards()){
            System.out.println(object.getCardHolder()+" "+object.getCardNumber());

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter card details ");
            client.host.Card card=new Card();
            System.out.println("Enter the name of card holder ");
            card.setCardHolder(scanner.nextLine());
            System.out.println("Enter the card num ");
            card.setCardNumber(scanner.nextLong());
        }
    }
}
