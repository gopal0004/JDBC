import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeDAO {

    public static void createEmployee(Employee emp)throws SQLException {
        Connection cn = DB.connector();
        String query = Query.insert;

        PreparedStatement pst = cn.prepareStatement(query);
        pst.setString(1, emp.getId());
        pst.setString(2, emp.getName());
        pst.setString(3,emp.getEmail());
        pst.setDouble(4, emp.getSalary());

        pst.executeUpdate();
        cn.close();
        System.out.println("Employee created successfully");
    }

    public static void updateEmployee(String id , String name)throws SQLException {
        Connection cn = DB.connector();
        String query = Query.update;

        PreparedStatement pst = cn.prepareStatement(query);
        pst.setString(2, id);
        pst.setString(1, name);

        pst.executeUpdate();
        cn.close();
        System.out.println("Employee updated successfully");
    }

    public static ArrayList<Employee> readEmployees() throws SQLException {
        ArrayList<Employee> list = new ArrayList<>();

        Connection cn = DB.connector();
        String query = Query.select;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            Employee emp = new Employee(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getDouble(4));
            list.add(emp);
        }
        return list;
    }

    public static void deleteEmployee(String e_id) throws SQLException {
        Connection cn = DB.connector();
        String query = Query.delete;
        PreparedStatement pst = cn.prepareStatement(query);
        pst.setString(1, e_id);
        pst.execute();
    }
}
