package review4;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operations {
    Connection connection;
    Students students;
    Adresses adresses;
    public Operations() {
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "apoorva", "admin");
            System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
        }}
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        public void insertDB(Students students){
            try {
                String query1 = "insert into students values(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, students.getRegisterNumber());
                preparedStatement.setString(2, students.getName());
                preparedStatement.setInt(3, students.getAge());
                preparedStatement.setString(4, students.getEmail());
                int ack1 = preparedStatement.executeUpdate();
                if(ack1>0){
                logger.log(Level.INFO, "student detailes entered into DB");}

                for(Adresses adresses:students.getMyaddress()) {
                    String query2 = "insert into adresses values(adress_id.nextval,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(query2);
                    preparedStatement.setInt(1, adresses.getDoorNo());
                    preparedStatement.setString(2, adresses.getStreet());
                    preparedStatement.setString(3, adresses.getCity());
                    preparedStatement.setInt(4, adresses.getPin());
                    preparedStatement.setString(5,adresses.getType());
                    int ack2 = preparedStatement.executeUpdate();
                    if(ack2>0){
                    logger.log(Level.INFO, "adress entered into DB");}

                    String query3 = "insert into adrress_mapper values(?,adress_id.currval)";
                    preparedStatement = connection.prepareStatement(query3);
                    preparedStatement.setInt(1, students.getRegisterNumber());
                    int ack3 = preparedStatement.executeUpdate();
                    if(ack3>0){
                    logger.log(Level.INFO, "address entered into DB mapper");}
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public List<Students> fetchStudentdetails(){
            List<Students> information = new ArrayList<>();
            try {
                String query = "select * from students";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return information;
        }
        public List<Adresses> fetchCurAddress(int regNo) {
            List<Adresses> store = new ArrayList<>();
            try {
                String query = "select * from adresses,adrress_mapper where adrress_mapper.reg_num=? and adrress_mapper.addr_id=adresses.add_id";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, regNo);
               // preparedStatement.setString(2,type);
                ResultSet resultSet = preparedStatement.executeQuery();
                Adresses adresses1 = null;
                while (resultSet.next()) {
                    adresses1 = new Adresses();
                    adresses1.setAddId(resultSet.getInt("add_id"));
                    adresses1.setDoorNo(resultSet.getInt("door_no"));
                    adresses1.setStreet(resultSet.getString("street"));
                    adresses1.setCity(resultSet.getString("city"));
                    adresses1.setPin(resultSet.getInt("pincode"));
                    store.add(adresses1);
                }}
             catch (SQLException e) {
                e.printStackTrace();
            }
            return store;}
        }




