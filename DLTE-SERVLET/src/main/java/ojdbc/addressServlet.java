package ojdbc;

import oracle.jdbc.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addressServlet")
public class addressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Apoorva",
                    "admin");
            String query="select * from adresses";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Adresses> store=new ArrayList<>();
            Adresses adresses=null;
            while(resultSet.next()){
                adresses=new Adresses();
                adresses.setAddId(resultSet.getInt("add_id"));
                adresses.setDoorNo(resultSet.getInt("door_no"));
                adresses.setStreet(resultSet.getString("street"));
                adresses.setCity(resultSet.getString("city"));
                adresses.setPin(resultSet.getInt("pincode"));
                store.add(adresses);
            }
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("addressweb.jsp");
            request.setAttribute("addressDB",store);
            requestDispatcher.forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

