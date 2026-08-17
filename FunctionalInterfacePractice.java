import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfacePractice {

    public static void main(String[] args) {


        // ============================================================
        // WHAT IS A FUNCTIONAL INTERFACE?
        // ============================================================

        /*
         * A Functional Interface is an interface that contains
         * EXACTLY ONE ABSTRACT METHOD.
         *
         * Example:
         *
         * @FunctionalInterface
         * interface MyInterface {
         *     void display();
         * }
         *
         * Because it has only ONE abstract method,
         * we can implement it using a LAMBDA EXPRESSION.
         *
         * Lambda:
         *
         * () -> System.out.println("Hello");
         *
         *
         * IMPORTANT:
         *
         * A Functional Interface can have:
         *
         * 1. Exactly ONE abstract method
         *
         * 2. Any number of default methods
         *
         * 3. Any number of static methods
         *
         * Object class methods do not count as abstract methods.
         */


        // ============================================================
        // 1. Predicate<T>
        // ============================================================

        /*
         * Predicate is a predefined Functional Interface.
         *
         * Package:
         *
         * java.util.function.Predicate
         *
         *
         * METHOD:
         *
         * boolean test(T t)
         *
         *
         * INPUT:
         *     One value
         *
         * OUTPUT:
         *     boolean
         *
         *
         * WHEN TO USE:
         *
         * Use Predicate when you want to CHECK a condition.
         *
         * Think:
         *
         * Predicate -> CONDITION -> true/false
         */


        Predicate<Integer> isEven =
                n -> n % 2 == 0;


        System.out.println(
                "Is 10 even? "
                + isEven.test(10)
        );


        /*
         * Output:
         *
         * Is 10 even? true
         */


        // Another example:

        Predicate<String> isLongName =
                name -> name.length() > 5;

        System.out.println(
                "Is Densil long? "
                + isLongName.test("Densil")
        );


        /*
         * Predicate is very commonly used with Stream filter().
         *
         * filter() expects a Predicate.
         */


        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);


        List<Integer> evenNumbers =
                numbers.stream()

                       // filter() internally accepts Predicate
                       .filter(isEven)

                       .toList();


        System.out.println(
                "Even numbers: "
                + evenNumbers
        );


        // ============================================================
        // 2. Consumer<T>
        // ============================================================

        /*
         * Consumer is another predefined Functional Interface.
         *
         * METHOD:
         *
         * void accept(T t)
         *
         *
         * INPUT:
         *     One value
         *
         * OUTPUT:
         *     Nothing / void
         *
         *
         * WHEN TO USE:
         *
         * Use Consumer when you want to PERFORM AN ACTION
         * on an object.
         *
         * Examples:
         *
         * print data
         * save data
         * send notification
         * update something
         *
         *
         * Think:
         *
         * Consumer -> CONSUMES value -> performs action
         */


        Consumer<String> printName =
                name -> System.out.println(
                        "Name: " + name
                );


        printName.accept("Densil");


        /*
         * Consumer is commonly used with forEach().
         *
         * forEach() accepts a Consumer.
         */


        namesExample().forEach(
                printName
        );


        // ============================================================
        // 3. Function<T, R>
        // ============================================================

        /*
         * Function is used when you want to:
         *
         * TAKE ONE INPUT
         *
         * and
         *
         * RETURN ONE OUTPUT.
         *
         *
         * METHOD:
         *
         * R apply(T t)
         *
         *
         * T = input type
         * R = return type
         *
         *
         * Example:
         *
         * Integer -> String
         *
         *
         * Think:
         *
         * Function -> TRANSFORM
         */


        Function<Integer, Integer> square =
                n -> n * n;


        System.out.println(
                "Square: "
                + square.apply(5)
        );


        // Integer -> String

        Function<Integer, String> convertToString =
                n -> "Number = " + n;


        System.out.println(
                convertToString.apply(100)
        );


        /*
         * Function is commonly used with map().
         *
         * map() accepts a Function.
         */


        List<Integer> squares =
                numbers.stream()

                       .map(square)

                       .toList();


        System.out.println(
                "Squares: "
                + squares
        );


        // ============================================================
        // 4. Supplier<T>
        // ============================================================

        /*
         * Supplier provides/generates a value.
         *
         * METHOD:
         *
         * T get()
         *
         *
         * INPUT:
         *     Nothing
         *
         * OUTPUT:
         *     One value
         *
         *
         * WHEN TO USE:
         *
         * Use Supplier when you need to GET or CREATE
         * a value without providing input.
         *
         *
         * Think:
         *
         * Supplier -> SUPPLIES a value
         */


        Supplier<String> messageSupplier =
                () -> "Welcome to Java";


        System.out.println(
                messageSupplier.get()
        );


        // Generate random number

        Supplier<Integer> randomNumber =
                () -> new Random().nextInt(100);


        System.out.println(
                "Random number: "
                + randomNumber.get()
        );


        /*
         * Supplier is useful when the value should be generated
         * only when required.
         */


        // ============================================================
        // 5. UnaryOperator<T>
        // ============================================================

        /*
         * UnaryOperator is a SPECIAL TYPE OF Function.
         *
         * Input type  = T
         * Output type = T
         *
         *
         * Function:
         *
         * Function<T, R>
         *
         * Input and output can be different.
         *
         *
         * UnaryOperator:
         *
         * UnaryOperator<T>
         *
         * Input and output MUST be the SAME type.
         *
         *
         * METHOD:
         *
         * T apply(T t)
         *
         *
         * WHEN TO USE:
         *
         * Use UnaryOperator when you want to transform
         * a value into another value of the SAME TYPE.
         */


        UnaryOperator<Integer> doubleValue =
                n -> n * 2;


        System.out.println(
                "Double: "
                + doubleValue.apply(10)
        );


        // String -> String

        UnaryOperator<String> upperCase =
                String::toUpperCase;


        System.out.println(
                upperCase.apply("densil")
        );


        // ============================================================
        // 6. BinaryOperator<T>
        // ============================================================

        /*
         * BinaryOperator is used when:
         *
         * TWO INPUTS
         *
         * are of the SAME TYPE
         *
         * and
         *
         * OUTPUT is also the SAME TYPE.
         *
         *
         * METHOD:
         *
         * T apply(T t1, T t2)
         *
         *
         * Example:
         *
         * Integer + Integer -> Integer
         *
         *
         * WHEN TO USE:
         *
         * Use BinaryOperator for operations like:
         *
         * addition
         * multiplication
         * maximum
         * minimum
         * combining values
         */


        BinaryOperator<Integer> addition =
                (a, b) -> a + b;


        System.out.println(
                "Addition: "
                + addition.apply(10, 20)
        );


        BinaryOperator<Integer> maximum =
                Integer::max;


        System.out.println(
                "Maximum: "
                + maximum.apply(10, 50)
        );


        /*
         * BinaryOperator is commonly used with reduce().
         */


        int total =
                numbers.stream()
                       .reduce(
                           0,
                           addition
                       );


        System.out.println(
                "Total: "
                + total
        );


        // ============================================================
        // 7. BiFunction<T, U, R>
        // ============================================================

        /*
         * BiFunction accepts:
         *
         * TWO INPUTS
         *
         * and returns:
         *
         * ONE OUTPUT.
         *
         *
         * METHOD:
         *
         * R apply(T t, U u)
         *
         *
         * Unlike BinaryOperator:
         *
         * BiFunction input types and output type
         * CAN be different.
         */


        BiFunction<Integer, Integer, Integer> add =
                (a, b) -> a + b;


        System.out.println(
                "BiFunction addition: "
                + add.apply(10, 20)
        );


        // Different input types

        BiFunction<String, Integer, String> repeat =
                (text, count) -> text.repeat(count);


        System.out.println(
                repeat.apply("Java ", 3)
        );


        // ============================================================
        // 8. BiPredicate<T, U>
        // ============================================================

        /*
         * BiPredicate accepts:
         *
         * TWO INPUTS
         *
         * and returns:
         *
         * boolean.
         *
         *
         * METHOD:
         *
         * boolean test(T t, U u)
         *
         *
         * WHEN TO USE:
         *
         * Use BiPredicate when you need to CHECK a condition
         * involving TWO values.
         */


        BiPredicate<Integer, Integer> isGreater =
                (a, b) -> a > b;


        System.out.println(
                "Is 20 greater than 10? "
                + isGreater.test(20, 10)
        );


        // ============================================================
        // 9. BiConsumer<T, U>
        // ============================================================

        /*
         * BiConsumer accepts:
         *
         * TWO INPUTS
         *
         * and returns:
         *
         * NOTHING.
         *
         *
         * METHOD:
         *
         * void accept(T t, U u)
         *
         *
         * WHEN TO USE:
         *
         * Use BiConsumer when you want to perform an action
         * using TWO values.
         */


        BiConsumer<String, Integer> printUser =
                (name, age) ->
                        System.out.println(
                                "Name: " + name
                                + ", Age: " + age
                        );


        printUser.accept("Densil", 22);


        // ============================================================
        // 10. Custom Functional Interface
        // ============================================================

        /*
         * We can create our OWN Functional Interface.
         *
         * @FunctionalInterface is optional,
         * but highly recommended.
         *
         * It tells the compiler:
         *
         * "This interface should contain only ONE
         *  abstract method."
         */


        Calculator calculator =
                (a, b) -> a + b;


        System.out.println(
                "Calculator result: "
                + calculator.calculate(10, 20)
        );


        // ============================================================
        // 11. Functional Interface with method reference
        // ============================================================

        /*
         * Lambda:
         *
         * n -> System.out.println(n)
         *
         *
         * can be simplified using method reference:
         *
         * System.out::println
         */


        Consumer<Integer> printer =
                System.out::println;


        printer.accept(100);


        // ============================================================
        // 12. Predicate with multiple conditions
        // ============================================================

        /*
         * Predicate provides useful methods:
         *
         * and()
         * or()
         * negate()
         */


        Predicate<Integer> greaterThan10 =
                n -> n > 10;


        Predicate<Integer> lessThan50 =
                n -> n < 50;


        // AND condition

        Predicate<Integer> between10And50 =
                greaterThan10.and(lessThan50);


        System.out.println(
                "20 between 10 and 50? "
                + between10And50.test(20)
        );


        // OR condition

        Predicate<Integer> greaterThan10OrLessThan5 =
                greaterThan10.or(
                        n -> n < 5
                );


        System.out.println(
                greaterThan10OrLessThan5.test(3)
        );


        // NEGATE condition

        Predicate<Integer> notGreaterThan10 =
                greaterThan10.negate();


        System.out.println(
                notGreaterThan10.test(5)
        );


        // ============================================================
        // 13. Function chaining
        // ============================================================

        /*
         * Function provides:
         *
         * andThen()
         * compose()
         *
         *
         * andThen():
         *
         * First function executes,
         * then second function executes.
         */


        Function<Integer, Integer> multiplyBy2 =
                n -> n * 2;


        Function<Integer, Integer> add10 =
                n -> n + 10;


        Function<Integer, Integer> finalFunction =
                multiplyBy2.andThen(add10);


        /*
         * 5
         * ↓
         * multiplyBy2
         * ↓
         * 10
         * ↓
         * add10
         * ↓
         * 20
         */

        System.out.println(
                "Function result: "
                + finalFunction.apply(5)
        );


        // ============================================================
        // 14. Real-world example
        // ============================================================

        /*
         * Suppose we have Employee objects.
         *
         * Requirement:
         *
         * Find employees whose salary is greater than 50000.
         *
         * Predicate is perfect here because:
         *
         * Employee -> true/false
         */


        List<Employee> employees =
                Arrays.asList(

                        new Employee(
                                "Densil",
                                "IT",
                                60000
                        ),

                        new Employee(
                                "Raja",
                                "HR",
                                40000
                        ),

                        new Employee(
                                "John",
                                "IT",
                                70000
                        )
                );


        Predicate<Employee> highSalary =
                employee ->
                        employee.getSalary() > 50000;


        List<Employee> highSalaryEmployees =
                employees.stream()

                         // filter() accepts Predicate
                         .filter(highSalary)

                         .toList();


        System.out.println(
                "High salary employees: "
                + highSalaryEmployees
        );


        /*
         * Now convert Employee -> Employee Name.
         *
         * Function is used by map().
         */


        Function<Employee, String> getEmployeeName =
                Employee::getName;


        List<String> highSalaryNames =
                employees.stream()

                         .filter(highSalary)

                         // map() accepts Function
                         .map(getEmployeeName)

                         .toList();


        System.out.println(
                "High salary employee names: "
                + highSalaryNames
        );


        /*
         * Finally, print each name.
         *
         * Consumer is used by forEach().
         */


        highSalaryNames.forEach(
                System.out::println
        );
    }


    // ================================================================
    // HELPER METHOD
    // ================================================================

    static List<String> namesExample() {

        return Arrays.asList(
                "Densil",
                "Raja",
                "Java"
        );
    }
}


// ====================================================================
// CUSTOM FUNCTIONAL INTERFACE
// ====================================================================

@FunctionalInterface
interface Calculator {

    /*
     * Exactly ONE abstract method.
     */

    int calculate(int a, int b);


    /*
     * Default methods are allowed.
     */

    default void display() {

        System.out.println(
                "Calculator interface"
        );
    }


    /*
     * Static methods are also allowed.
     */

    static void info() {

        System.out.println(
                "This is a Calculator"
        );
    }
}


// ====================================================================
// EMPLOYEE CLASS
// ====================================================================

class Employee {

    private String name;
    private String department;
    private double salary;


    public Employee(
            String name,
            String department,
            double salary) {

        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    public String getName() {

        return name;
    }


    public String getDepartment() {

        return department;
    }


    public double getSalary() {

        return salary;
    }


    @Override
    public String toString() {

        return name
                + " - "
                + department
                + " - "
                + salary;
    }
}