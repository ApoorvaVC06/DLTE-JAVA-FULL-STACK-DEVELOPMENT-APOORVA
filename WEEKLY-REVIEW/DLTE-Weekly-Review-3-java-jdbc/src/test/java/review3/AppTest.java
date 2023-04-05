package review3;

import static java.util.stream.Stream.*;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    ResultSet resultSet;
    @Mock
    StudentImplements studentImplements;
    @BeforeEach
    public void assemble() throws SQLException {

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate()).thenReturn(1);
    }

    @Test
    public void testInsertion() throws SQLException {
        Student student1= new Student(232,"Arpitha",21,"arpitha@gmail.com");
        Student student2= new Student(543,"Ankitha",20,"ankitha@gmail.com");
        Address address1=new Address("InfantryRoad","GanddhiNagr","Banglore",344);
        when(studentImplements.insert(student1,address1)).thenReturn(student1,address1);
        assertSame(student1,studentImplements.insert(student1,address1));

    }

    @Test
   public void testFetch(){
        List<Student> testdata= Stream.
    }
}
