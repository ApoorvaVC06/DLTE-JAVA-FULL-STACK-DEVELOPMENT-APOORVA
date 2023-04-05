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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "studentServlet", value="/details")
public class fetchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Apoorva",
                    "admin");
            String query = "select * from students";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Students> information = new ArrayList<>();
            Students students = null;
            while (resultSet.next()) {
                students = new Students();
                students.setRegisterNumber(resultSet.getInt("register_num"));
                students.setName(resultSet.getString("name"));
                students.setAge(resultSet.getInt("age"));
                students.setEmail(resultSet.getString("email"));
                information.add(students);
                logger.log(Level.INFO, "details fetched");

            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("student.jsp");
            request.setAttribute("studentDB", information);
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }}