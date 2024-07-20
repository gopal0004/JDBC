import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection cn = null;
    public static Connection connector(){
        try{
            String URL = "jdbc:mysql://localhost/project1";
            String USERNAME = "root";
            String PASSWORD = "gopal123";

            DB.cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return cn;
    }
}
