public class Query {
    public static String  insert = "insert into employee(id,name,email,salary) values(?,?,?,?)";
    public static final String update = "update employee set name = ? where id = ?";
    public static final String select = "select * from employee";
    public static final String delete = "delete from employee where id = ?"; //#
}
