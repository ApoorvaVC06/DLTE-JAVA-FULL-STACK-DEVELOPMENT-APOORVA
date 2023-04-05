package javaee;

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

@WebServlet(name = "addressServlet" ,value="/adrress")
public class fetchAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int reg_num=Integer.parseInt("reg_num");
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apoorva",
                    "admin");
            String query="select door_no,street,city,pincode from adresses,adrress_mapper where adrress_mapper.reg_num=? and adrress_mapper.addr_id=adresses.add_id";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,reg_num);
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Adresses> store=new ArrayList<>();
            Adresses adresses1=null;
            while(resultSet.next()){
                adresses1=new Adresses();
                adresses1.setAddId(resultSet.getInt("add_id"));
                adresses1.setDoorNo(resultSet.getInt("door_no"));
                adresses1.setStreet(resultSet.getString("street"));
                adresses1.setCity(resultSet.getString("city"));
                adresses1.setPin(resultSet.getInt("pincode"));
                store.add(adresses1);
            }
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewAddress.jsp");
            request.setAttribute("addressDB",store);
            requestDispatcher.forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

