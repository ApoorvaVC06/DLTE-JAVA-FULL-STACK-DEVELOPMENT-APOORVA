package review3;

import java.sql.SQLException;

interface StudentInterface {
    void insert(Student student,Address address ) throws SQLException;
    void viewDetails() throws SQLException;
    void delete( int reg_no) throws SQLException;
}
