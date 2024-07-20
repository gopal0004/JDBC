public class Employee {
    private String id;
    private String name;
    private String email;
    private double salary;

    public Employee(String id,String name,String email,double salary){
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public double getSalary(){
        return this.salary;
    }

    public String toString(){
        return "Employee [id=" + this.id +", name=" + this.name +", email=" + this.email +", salary=" + this.salary + "]";
    }
}
