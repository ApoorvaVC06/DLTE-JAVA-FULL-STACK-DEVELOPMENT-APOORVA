package javaee;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "loginServlet", value="/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int adminId = Integer.parseInt(request.getParameter("adminId"));
            String passCode = request.getParameter("passCode");
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


        try {
                Driver driver = new OracleDriver();
                DriverManager.registerDriver(driver);
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "apoorva", "admin");
                String query = "select * from admin where admin_id=? and pass_code=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, adminId);
                preparedStatement.setString(2, passCode);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
                    request.setAttribute("LoginAccessed", "authenticated");
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("student", resultSet.getInt("admin_id"));
                    logger.log(Level.INFO,"Authenticated");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                    logger.log(Level.WARNING,"Not Authenticated");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

