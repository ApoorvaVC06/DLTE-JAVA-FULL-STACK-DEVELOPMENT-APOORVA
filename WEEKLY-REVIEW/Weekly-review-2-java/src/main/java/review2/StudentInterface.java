package review2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

interface StudentInterface {
    void writeRecords(ArrayList<Student> student) throws IOException;
    ArrayList<Student> readRecords() throws IOException, ClassNotFoundException;
}

