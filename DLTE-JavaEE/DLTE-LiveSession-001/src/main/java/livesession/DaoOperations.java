package livesession;

import oracle.jdbc.driver.OracleDriver;
import sun.security.mscapi.CPublicKey;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOperations {
    private Driver driver;
    private String query;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Customer customer;
    public DaoOperations(){
    try {
         driver = new OracleDriver();                     //JDBC conncetion
        DriverManager.registerDriver(driver);
        connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apoorva","admin");
        System.out.println("Database Connected");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    public Customer insert(Customer customer) throws SQLException {
        query="insert into taskcustomer values(customer_seq.nextval,?,?,?,?,?)";        //sql query
        preparedStatement=connection.prepareStatement(query);                          //pass the query
        preparedStatement.setString(1,customer.getCustomerName());
        preparedStatement.setString(2,customer.getCustomerEmail());
        preparedStatement.setString(3,customer.getCustomerPan());
        preparedStatement.setInt(4,customer.getCustomerContact());
        preparedStatement.setInt(5,customer.getCustomerPin());
        int ack=preparedStatement.executeUpdate();
        if(ack>0){
            return customer;
        }
        else return null;
    }
  public List<Loan> fetch() throws SQLException {
        query="select * from loan,loan_mapper where loan_mapper.cust_id=? and loan_mapper.loan_num=loan.loan_number";
        preparedStatement=connection.prepareStatement(query);
      resultSet=preparedStatement.executeQuery();
      List<Loan> data=new ArrayList<Loan>();
      while(resultSet.next()){
     Loan loan=new Loan();
     loan.setBorrowerName(resultSet.getString("borrower_name"));
     loan.setLoanType(resultSet.getString("loan_type"));
     loan.setLoanAmount(resultSet.getDouble("loan_amount"));
     loan.setIssueDate(resultSet.getDate("issue_date"));
     data.add(loan);
  }
      return data;
    }}
