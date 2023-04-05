package host;

import oracle.jdbc.OracleDriver;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.*;
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class cardCRUDL {
    private Driver driver;
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public cardCRUDL(){

        try {
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apoorva","admin");
            System.out.println("Connection towards Oracle is success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @WebMethod
    @WebResult(name = "listofcards")
    public ListOfCards showcards(){
        ListOfCards listOfCards=new ListOfCards();

        try {
            query="select * from card";
            preparedStatement=connection.prepareStatement(query);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                CARD card=new CARD();
                card.setCard_number(resultSet.getLong("card_number"));
                card.setCard_holder(resultSet.getString("card_holder"));
                card.setCard_pin(resultSet.getInt("card_pin"));
                card.setCard_expiry(resultSet.getDate("card_expiry"));
                card.setCard_limit(resultSet.getInt("card_limit"));
                listOfCards.getCards().add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCards;
    }

}
