import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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


        Function<Employee,String> getLastName=(employee)->{
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };




        Function<Employee,String> getFirstName=(employee)->{
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        } ;


//        System.out.println("First Name from function "+getFirstName.apply(employees.get(1)));
//        System.out.println("Last Name from function "+getLastName.apply(employees.get(1)));

        Random random =new Random();
        for(Employee employee:employees){
            if(random.nextBoolean()){
                System.out.println("**Employee First Name: "+getFirstName.apply(employee));
            }else{
                System.out.println("**Employee Last Name: "+getLastName.apply(employee));
            }
        }




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


        Random randomInt =new Random();
        Supplier<Integer> randomSupplier=()->randomInt.nextInt(1000);//Supplier interface
        for(int i=0;i<10;i++){
            System.out.println(randomSupplier.get());
        }



        Function<Employee,String> toUpperCase=(employee)->employee.getName().toUpperCase();
        Function<String,String>  firstName=(name)->name.substring(0,name.indexOf(' '));
        Function chainedFunction=toUpperCase.andThen(firstName);
        System.out.println("Chained function result: "+chainedFunction.apply(employees.get(1)));


        BiFunction<Employee,String,String> concatAge=(Employee employee,String name)->{
            return name.concat(""+employee.getAge());//name taken will be passed from "toUpperCase()"

        };

        String upperCaseName=toUpperCase.apply(employees.get(1));
        String concatAgeName=concatAge.apply(employees.get(1),upperCaseName);
        System.out.println("concatAgeName "+ concatAgeName);


        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));//unary

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");





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
//3.Supplier doesn't expect arguments but returns something
