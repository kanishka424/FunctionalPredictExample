import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);


        employees.forEach(employee->{//java 8 method in iterbale interface
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });


    }
}
