import java.sql.*;

public class CreateDB {

   public static void main(String[] args) {
      try{
         String URL = "jdbc:mysql://localhost";
         String userName = "root";
         String password = "gopal123";
         String query = "create database Java";

         Connection cn = DriverManager.getConnection(URL, userName, password);
         Statement st = cn.createStatement();
         st.execute(query);
         System.out.println("Database created successfully");
         cn.close();
      }catch (Exception e){
         e.printStackTrace();
      }
   }
}