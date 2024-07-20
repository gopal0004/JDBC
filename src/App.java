import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("1. insert employee");
            System.out.println("2. update employee");
            System.out.println("3. read employees");
            System.out.println("4. delete employee");
            System.out.println("5. exit");
            System.out.println("-----------------------------");
            System.out.println("enter choice");
            choice = sc.nextInt();
            System.out.println("-----------------------------");

            switch (choice) {
                case 1:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("enter id,name,email & salary respectively");
                    String id = sc1.nextLine();
                    String name = sc1.nextLine();
                    String email = sc1.nextLine();
                    int salary = sc1.nextInt();
                    // sc1.close();

                    System.out.println(id + name + email + salary);
                    Employee emp = new Employee(id, name, email, salary);
                    EmployeeDAO.createEmployee(emp);
                    break;
                case 2:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("enter id and name to update name for respective id");
                    String id1 = sc2.nextLine();
                    String name1 = sc2.nextLine();
                    EmployeeDAO.updateEmployee(id1, name1);
                    // sc2.close();
                    break;
                case 3:
                    try{
                        ArrayList<Employee> list = EmployeeDAO.readEmployees();
                        for(Employee emp1 : list){
                            System.out.println(emp1);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("enter id to delete the employee");
                    String id2 = sc3.nextLine();
                    EmployeeDAO.deleteEmployee(id2);
                    // sc3.close();
                    break;
                case 5:
                    System.exit(0);
                default:
                System.out.println("Invalid choice");
                    break;
            }
        }while(choice != 5);
        sc.close();
    }
}
