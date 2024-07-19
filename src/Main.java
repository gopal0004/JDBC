import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Student std = new Student();
        std.createDatabase();
        std.createTable();
        std.insertData();
        std.readData();
        std.updateData();
        std.deleteData();
    }
}
