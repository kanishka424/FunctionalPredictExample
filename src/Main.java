import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        printEmployeeByAge(employees,"Employees older than 30",employee->employee.getAge()>30);//predicate with lambda
        printEmployeeByAge(employees,"Employees younger than 30",employee->employee.getAge()>30);
        printEmployeeByAge(employees, "\n Employees younger than 25", new Predicate<Employee>() {//predicate with anonymous
            @Override
            public boolean test(Employee employee) {
                    return employee.getAge()<25;
            }
    });


        IntPredicate greatThan15=i->i>15;
        IntPredicate lessThan10=i->i<10;
        System.out.println("28 checked with great than 15\n"+greatThan15.test(28));
        System.out.println("12 checked with great than 15\n"+greatThan15.test(12));
        System.out.println("34 checked with less than 10\n"+ lessThan10.test(34));
        System.out.println("4 checked with less than 10\n"+ lessThan10.test(4));


        Random random =new Random();
        Supplier<Integer> randomSupplier=()->random.nextInt(1000);//Supplier interface
        for(int i=0;i<10;i++){
            System.out.println(randomSupplier.get());
        }





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



//NOTES
//1.Predicate  is a one parameter lambda and it returns a boolean(we also can use anonymous classes to it)
//2.from this we can infer type of the predicate "Predicate<Employee> ageCondition",use generics to infer type
