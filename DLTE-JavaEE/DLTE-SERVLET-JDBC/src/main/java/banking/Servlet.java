package banking;

import lombok.Data;
import oracle.jdbc.driver.OracleDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.Card;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.annotation;
@Data
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apoorva","admin");
            String query="select * from card";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            Card card=null;
            List<Card> details=new ArrayList<Card>();
            while(resultSet.next()){
                card.setcard
            }
    }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
}
