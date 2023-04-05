package credcust;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receiveId=request.getParameter("customerId");
        String receivePin=request.getParameter("customerPin");
        int custId=Integer.parseInt(receiveId);
        try {
        Driver driver=new OracleDriver();
        ServletContext obj=request.getServletContext();
        OracleDataSource source=new OracleDataSource();
        source.setUser("system");source.setPassword("Apoorva@098");
        source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
        obj.setAttribute("connection",source);
        DriverManager.registerDriver(driver);
        Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Apoorva@098");
            String query="select * from customer where customer_id=? and customer_passcode=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, custId);
            preparedStatement.setString(2,receivePin);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request,response);
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
