import java.sql.*;

public class Student {

    public void createDatabase() {
        try{
            String url = "jdbc:mysql://localhost";
            String username = "root";
            String password = "gopal123";
            String query = "create database java";
    
            Connection cn = DriverManager.getConnection(url, username, password);
            Statement st = cn.createStatement();
            st.execute(query);
            System.out.println("Database created successfully");
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createTable(){
        try {
            String url = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "gopal123";
            String query = "create table student (s_id varchar(7) , s_name varchar(200) , s_marks decimal(10,2))";

            Connection cn = DriverManager.getConnection(url, username, password);
            Statement st = cn.createStatement();
            st.execute(query);
            cn.close();
            System.out.println("Table created successfully" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(){
        try {
            String url = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "gopal123";
            // String query = "insert into student values('std-002' , 'Virat Kohli' , 79.99)"; //also used
            String query =  "insert into student values(?,?,?)";

            Connection cn = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, "std-003");
            pst.setString(2, "Suresh Raina");
            pst.setDouble(3, 81.99);
            pst.execute();
            System.out.println("Data inserted successfully");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        try {
            String url = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "gopal123";
            String query = "select * from student";

            Connection cn = DriverManager.getConnection(url, username, password);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                System.out.print("\tid : " + rs.getString(1));
                System.out.print("\tname : " + rs.getString(2));
                System.out.print("\tmarks : " + rs.getDouble("s_marks"));
                System.out.println();
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(){
        try{
            String url = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "gopal123";
            String query = "update student set s_name = 'Gopal Bera' where s_id = 'std-003'";

            Connection cn = DriverManager.getConnection(url, username, password);
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("Data updated successfully");
            cn.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(){
        try{
            String url = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "gopal123";
            String query = "delete from student where s_id = 'std-004'";

            Connection cn = DriverManager.getConnection(url, username, password);
            Statement st = cn.createStatement();
            st.execute(query);
            cn.close();
            System.out.println("Record delete successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
