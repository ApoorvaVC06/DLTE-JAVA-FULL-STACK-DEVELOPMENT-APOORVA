package banking;

import java.sql.SQLException;
import java.util.List;

public interface StudentRemote {
    public void AddDetails();
    public List<Student> ViewDetails();
}
