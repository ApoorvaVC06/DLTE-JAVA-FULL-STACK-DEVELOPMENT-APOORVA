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

@WebServlet(name = "studentServlet", value="/stud")
public class studentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Apoorva",
                    "admin");
             String query="select * from students";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Students> information=new ArrayList<>();
            Students students=null;
            while(resultSet.next()){
                students=new Students();
                students.setRegisterNumber(resultSet.getInt("register_num"));
                students.setName(resultSet.getString("name"));
                students.setAge(resultSet.getInt("age"));
                students.setEmail(resultSet.getString("email"));
                information.add(students);
            }
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentweb.jsp");
            request.setAttribute("studentDB",information);
            requestDispatcher.forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
