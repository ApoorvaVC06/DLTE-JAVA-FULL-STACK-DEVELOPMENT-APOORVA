package ojdbc;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "insertServlet", value="/insert")
public class insertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO,"Servlet called");
        String reg_no = request.getParameter("RegistrationNumber");
        String name = request.getParameter("Name");
        String age = request.getParameter("StudentAge");
        String email = request.getParameter("Email");

        int regNo = Integer.parseInt(reg_no);
        int Age = Integer.parseInt(age);
        logger.log(Level.INFO,"Student details received");

        String doorNum = request.getParameter("curDoorNo");
        String street = request.getParameter("curStreet");
        String city = request.getParameter("curCity");
        String pincode = request.getParameter("curPincode");

        int door_no = Integer.parseInt(doorNum);
        int pin = Integer.parseInt(pincode);
        logger.log(Level.INFO,"Current address received");

        String perdoorNo = request.getParameter("perDoorNo");
        String perstreet = request.getParameter("perStreet");
        String percity = request.getParameter("perCity");
        String perpincode = request.getParameter("perPincode");

        int perdoor_no = Integer.parseInt(perdoorNo);
        int perpin = Integer.parseInt(perpincode);

        logger.log(Level.INFO,"Permanent address received");
        logger.log(Level.INFO, "working");

      try {
          Driver driver = new OracleDriver();
          DriverManager.registerDriver(driver);
          Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "apoorva", "admin");

          String query1 = "insert into students values(?,?,?,?)";
          PreparedStatement preparedStatement = connection.prepareStatement(query1);
          preparedStatement.setInt(1, regNo);
          preparedStatement.setString(2, name);
          preparedStatement.setInt(3, Age);
          preparedStatement.setString(4, email);
          int ack1 = preparedStatement.executeUpdate();
          logger.log(Level.INFO,"student detailes entered into DB");

          String query2 = "insert into adresses values(adress_id.nextval,?,?,?,?,?)";
          preparedStatement=connection.prepareStatement(query2);
          preparedStatement.setInt(1, door_no);
          preparedStatement.setString(2, street);
          preparedStatement.setString(3, city);
          preparedStatement.setInt(4, pin);
          preparedStatement.setString(5,"current");
          int ack2 = preparedStatement.executeUpdate();
          logger.log(Level.INFO,"current adress entered into DB");

          String query3 = "insert into adrress_mapper values(?,adress_id.currval)";
          preparedStatement=connection.prepareStatement(query3);
          preparedStatement.setInt(1, regNo);
          int ack3=preparedStatement.executeUpdate();
          logger.log(Level.INFO,"current address entered into DB mapper");

          String query4 = "insert into adresses values(adress_id.nextval,?,?,?,?,?)";
          preparedStatement=connection.prepareStatement(query4);
          preparedStatement.setInt(1, perdoor_no);
          preparedStatement.setString(2, perstreet);
          preparedStatement.setString(3,percity  );
          preparedStatement.setInt(4,perpin );
          preparedStatement.setString(5,"permanent");
          int ack4 = preparedStatement.executeUpdate();
          logger.log(Level.INFO,"permanent address entered into DB");

          String query5 = "insert into adrress_mapper values(?,adress_id.currval)";
          preparedStatement=connection.prepareStatement(query5);
          preparedStatement.setInt(1, regNo);
          int ack5=preparedStatement.executeUpdate();
          logger.log(Level.INFO,"permanent address entered into DB mapper");

          if(ack1>0 && ack2>0 && ack3>0 && ack4>0 && ack5>0){
              RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentweb.jsp");
              logger.log(Level.INFO,"Details inderted");
              requestDispatcher.forward(request,response);
      }
          else{
              RequestDispatcher requestDispatcher=request.getRequestDispatcher("insertweb.jsp");
              logger.log(Level.INFO,"insertion failed");
              requestDispatcher.forward(request,response);
          }
      }
        catch (SQLException e) {
            e.printStackTrace();
        }
   }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {


        }
    }