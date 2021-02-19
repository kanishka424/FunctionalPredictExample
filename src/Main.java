import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee charm = new Employee("Charm pizer", 32);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(charm);






//        System.out.println("Employees above age 32"); //ref A
//        employees.forEach(employee->{
//            if(employee.getAge()>30){
//                System.out.println(employee.getName());
//            }
//        });
//
//
//        System.out.println("Employees below age 32");//ref A
//        employees.forEach(employee->{
//            if(employee.getAge()<30){
//                System.out.println(employee.getName());
//            }
//        });


//
//        employees.forEach(employee->{//java 8 method in iterbale interface
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });

        printEmployeeByAge(employees,"Employees older than 30",employee->employee.getAge()>30);
        printEmployeeByAge(employees,"Employees younger than 30",employee->employee.getAge()>30);

    }


    public static void printEmployeeByAge(List<Employee> employees, String lineText, Predicate<Employee> ageCondition){//how to ue Predicate
        System.out.println(lineText);
        System.out.println("===============================");
        employees.forEach(employee->{
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });

    }
}
