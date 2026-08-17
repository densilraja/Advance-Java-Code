import java.util.*;
import java.util.stream.Collectors;

public class StreamInterviewPractice {

    public static void main(String[] args) {

        // ============================================================
        // SAMPLE DATA
        // ============================================================

        List<Integer> numbers =
                Arrays.asList(10, 20, 20, 30, 40, 50, 60);

        List<String> names =
                Arrays.asList("densil", "raja", "java", "spring");


        // ============================================================
        // 1. stream()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use stream() when you want to process collection elements
         * using Stream API operations.
         *
         * stream() does NOT modify the original collection.
         */

        numbers.stream()
               .forEach(System.out::println);


        // ============================================================
        // 2. filter()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use filter() when you want to SELECT elements
         * based on a condition.
         *
         * Think:
         * filter() = WHERE condition
         *
         * Example:
         * Select only even numbers.
         */

        List<Integer> evenNumbers =
                numbers.stream()
                       .filter(n -> n % 2 == 0)
                       .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);


        // ============================================================
        // 3. map()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use map() when you want to TRANSFORM each element.
         *
         * Example:
         * Convert every name to uppercase.
         *
         * String -> String
         * Integer -> Integer
         * Employee -> String
         */

        List<String> upperCaseNames =
                names.stream()
                     .map(String::toUpperCase)
                     .collect(Collectors.toList());

        System.out.println("Uppercase names: " + upperCaseNames);


        // ============================================================
        // 4. map() - Mathematical transformation
        // ============================================================
        /*
         * Convert every number into its square.
         *
         * 1 -> 1
         * 2 -> 4
         * 3 -> 9
         */

        List<Integer> squares =
                numbers.stream()
                       .map(n -> n * n)
                       .collect(Collectors.toList());

        System.out.println("Squares: " + squares);


        // ============================================================
        // 5. distinct()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use distinct() when you want to REMOVE DUPLICATES.
         *
         * Example:
         *
         * [10, 20, 20, 30, 40]
         *
         * becomes:
         *
         * [10, 20, 30, 40]
         */

        List<Integer> uniqueNumbers =
                numbers.stream()
                       .distinct()
                       .collect(Collectors.toList());

        System.out.println("Unique numbers: " + uniqueNumbers);


        // ============================================================
        // 6. sorted()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use sorted() when you want to SORT elements.
         *
         * Default = ascending order.
         */

        List<Integer> ascending =
                numbers.stream()
                       .sorted()
                       .collect(Collectors.toList());

        System.out.println("Ascending: " + ascending);


        // ============================================================
        // 7. sorted() - Descending
        // ============================================================
        /*
         * Comparator.reverseOrder()
         * gives descending order.
         */

        List<Integer> descending =
                numbers.stream()
                       .sorted(Comparator.reverseOrder())
                       .collect(Collectors.toList());

        System.out.println("Descending: " + descending);


        // ============================================================
        // 8. limit()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use limit() when you need only the FIRST N elements.
         *
         * Example:
         * Get first 3 numbers.
         */

        List<Integer> firstThree =
                numbers.stream()
                       .limit(3)
                       .collect(Collectors.toList());

        System.out.println("First 3: " + firstThree);


        // ============================================================
        // 9. skip()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use skip() when you want to SKIP the first N elements.
         *
         * Useful for pagination.
         */

        List<Integer> afterSkippingTwo =
                numbers.stream()
                       .skip(2)
                       .collect(Collectors.toList());

        System.out.println("After skipping 2: "
                           + afterSkippingTwo);


        // ============================================================
        // 10. count()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use count() when you want the NUMBER OF ELEMENTS.
         *
         * Return type = long
         */

        long count =
                numbers.stream()
                       .filter(n -> n > 20)
                       .count();

        System.out.println("Numbers greater than 20: " + count);


        // ============================================================
        // 11. findFirst()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use findFirst() when you need the FIRST matching element.
         *
         * Return type = Optional<T>
         *
         * Why Optional?
         * Because there might be no matching element.
         */

        Optional<Integer> first =
                numbers.stream()
                       .filter(n -> n > 25)
                       .findFirst();

        System.out.println("First number > 25: " + first);


        // ============================================================
        // 12. findAny()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use findAny() when ANY matching element is sufficient.
         *
         * Difference:
         *
         * findFirst() -> first matching element
         * findAny()   -> any matching element
         */

        Optional<Integer> any =
                numbers.stream()
                       .filter(n -> n > 25)
                       .findAny();

        System.out.println("Any number > 25: " + any);


        // ============================================================
        // 13. anyMatch()
        // ============================================================
        /*
         * WHEN TO USE:
         * Check whether AT LEAST ONE element satisfies the condition.
         *
         * Returns boolean.
         */

        boolean hasNumberGreaterThan50 =
                numbers.stream()
                       .anyMatch(n -> n > 50);

        System.out.println(
                "Any number > 50: "
                + hasNumberGreaterThan50
        );


        // ============================================================
        // 14. allMatch()
        // ============================================================
        /*
         * WHEN TO USE:
         * Check whether ALL elements satisfy the condition.
         */

        boolean allPositive =
                numbers.stream()
                       .allMatch(n -> n > 0);

        System.out.println(
                "All numbers positive: "
                + allPositive
        );


        // ============================================================
        // 15. noneMatch()
        // ============================================================
        /*
         * WHEN TO USE:
         * Check whether NO element satisfies the condition.
         */

        boolean noNegativeNumbers =
                numbers.stream()
                       .noneMatch(n -> n < 0);

        System.out.println(
                "No negative numbers: "
                + noNegativeNumbers
        );


        // ============================================================
        // 16. reduce()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use reduce() when you want to combine MANY elements
         * into ONE result.
         *
         * Example:
         *
         * 10 + 20 + 30 + 40
         *
         * = 100
         *
         * reduce(0, ...)
         *
         * 0 = initial value
         */

        int sum =
                numbers.stream()
                       .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);


        // ============================================================
        // 17. reduce() - Maximum
        // ============================================================
        /*
         * reduce() can also be used to find maximum.
         */

        Optional<Integer> maximum =
                numbers.stream()
                       .reduce(Integer::max);

        System.out.println("Maximum: " + maximum);


        // ============================================================
        // 18. max()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use max() when you directly want the maximum element.
         *
         * It returns Optional<T>.
         */

        Optional<Integer> max =
                numbers.stream()
                       .max(Integer::compareTo);

        System.out.println("Max: " + max);


        // ============================================================
        // 19. min()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use min() when you directly want the minimum element.
         */

        Optional<Integer> min =
                numbers.stream()
                       .min(Integer::compareTo);

        System.out.println("Min: " + min);


        // ============================================================
        // 20. mapToInt() + sum()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use mapToInt() when you want to convert
         * Stream<Integer> into IntStream.
         *
         * Then we can directly use sum().
         */

        int total =
                numbers.stream()
                       .mapToInt(Integer::intValue)
                       .sum();

        System.out.println("Total: " + total);


        // ============================================================
        // 21. average()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use average() when you want the average value.
         *
         * Return type = OptionalDouble
         */

        OptionalDouble average =
                numbers.stream()
                       .mapToInt(Integer::intValue)
                       .average();

        System.out.println("Average: " + average);


        // ============================================================
        // 22. collect()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use collect() when you want to convert the Stream
         * result into a collection.
         *
         * Stream -> List
         */

        List<Integer> collectedList =
                numbers.stream()
                       .filter(n -> n > 20)
                       .collect(Collectors.toList());

        System.out.println(
                "Collected List: "
                + collectedList
        );


        // ============================================================
        // 23. Collect into Set
        // ============================================================
        /*
         * Stream -> Set
         *
         * Set automatically removes duplicates.
         */

        Set<Integer> collectedSet =
                numbers.stream()
                       .collect(Collectors.toSet());

        System.out.println(
                "Collected Set: "
                + collectedSet
        );


        // ============================================================
        // 24. flatMap()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use flatMap() when you have NESTED collections
         * and want to FLATTEN them.
         *
         * Example:
         *
         * [[1,2], [3,4], [5,6]]
         *
         * becomes:
         *
         * [1,2,3,4,5,6]
         */

        List<List<Integer>> nestedNumbers =
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(5, 6)
                );

        List<Integer> flattenedNumbers =
                nestedNumbers.stream()
                             .flatMap(List::stream)
                             .collect(Collectors.toList());

        System.out.println(
                "Flattened: "
                + flattenedNumbers
        );


        // ============================================================
        // 25. map() vs flatMap()
        // ============================================================
        /*
         * map():
         *
         * One element -> One element
         *
         * flatMap():
         *
         * One element -> Multiple elements
         *
         * map:
         *
         * List<List<Integer>>
         *        ↓
         * Stream<List<Integer>>
         *
         * flatMap:
         *
         * List<List<Integer>>
         *        ↓
         * Stream<Integer>
         */


        // ============================================================
        // 26. groupingBy()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use groupingBy() when you want to GROUP objects
         * based on a particular property.
         *
         * Similar to SQL:
         *
         * GROUP BY department
         */

        List<Employee> employees =
                Arrays.asList(

                        new Employee(
                                101,
                                "Densil",
                                "IT",
                                60000
                        ),

                        new Employee(
                                102,
                                "Raja",
                                "HR",
                                50000
                        ),

                        new Employee(
                                103,
                                "John",
                                "IT",
                                70000
                        ),

                        new Employee(
                                104,
                                "David",
                                "HR",
                                55000
                        )
                );


        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                         .collect(
                             Collectors.groupingBy(
                                 Employee::getDepartment
                             )
                         );

        System.out.println(
                "Employees by department: "
                + employeesByDepartment
        );


        // ============================================================
        // 27. partitioningBy()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use partitioningBy() when you want exactly TWO groups:
         *
         * true
         * false
         *
         * Example:
         * Employees with salary >= 60000
         */

        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                         .collect(
                             Collectors.partitioningBy(
                                 e -> e.getSalary() >= 60000
                             )
                         );

        System.out.println(
                "Salary partition: "
                + salaryPartition
        );


        // ============================================================
        // 28. toMap()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use toMap() when you want to convert objects into:
         *
         * Map<Key, Value>
         *
         * Here:
         *
         * Employee ID -> Employee Name
         */

        Map<Integer, String> employeeMap =
                employees.stream()
                         .collect(
                             Collectors.toMap(
                                 Employee::getId,
                                 Employee::getName
                             )
                         );

        System.out.println(
                "Employee Map: "
                + employeeMap
        );


        // ============================================================
        // 29. toMap() with duplicate key handling
        // ============================================================
        /*
         * IMPORTANT INTERVIEW QUESTION:
         *
         * What happens if duplicate keys exist?
         *
         * Without a merge function:
         *
         * IllegalStateException
         *
         * To solve it, provide a merge function.
         */

        Map<String, String> departmentEmployees =
                employees.stream()
                         .collect(
                             Collectors.toMap(
                                 Employee::getDepartment,
                                 Employee::getName,

                                 // If duplicate department exists,
                                 // keep the old employee name.
                                 (oldValue, newValue) -> oldValue
                             )
                         );

        System.out.println(
                "Department Map: "
                + departmentEmployees
        );


        // ============================================================
        // 30. joining()
        // ============================================================
        /*
         * WHEN TO USE:
         * Use joining() when you want to combine Strings.
         */

        String joinedNames =
                names.stream()
                     .collect(
                         Collectors.joining(", ")
                     );

        System.out.println(
                "Joined names: "
                + joinedNames
        );


        // ============================================================
        // 31. Employee filtering
        // ============================================================
        /*
         * REAL-WORLD INTERVIEW EXAMPLE:
         *
         * Find employees who:
         *
         * 1. Work in IT
         * 2. Have salary > 50000
         */

        List<Employee> itEmployees =
                employees.stream()

                         // First filter:
                         // Only IT employees
                         .filter(e ->
                                 e.getDepartment()
                                  .equals("IT"))

                         // Second filter:
                         // Salary greater than 50000
                         .filter(e ->
                                 e.getSalary() > 50000)

                         .collect(Collectors.toList());

        System.out.println(
                "IT employees > 50000: "
                + itEmployees
        );


        // ============================================================
        // 32. Employee sorting
        // ============================================================
        /*
         * Find employees sorted by salary DESCENDING.
         */

        List<Employee> sortedEmployees =
                employees.stream()
                         .sorted(
                             Comparator.comparing(
                                 Employee::getSalary
                             ).reversed()
                         )
                         .collect(Collectors.toList());

        System.out.println(
                "Sorted by salary: "
                + sortedEmployees
        );


        // ============================================================
        // 33. Employee -> Employee Name using map()
        // ============================================================
        /*
         * WHEN TO USE:
         * map() is useful when you want to extract/transform
         * an object into another value.
         *
         * Employee -> String
         */

        List<String> employeeNames =
                employees.stream()
                         .map(Employee::getName)
                         .collect(Collectors.toList());

        System.out.println(
                "Employee names: "
                + employeeNames
        );


        // ============================================================
        // 34. Highest salary employee
        // ============================================================
        /*
         * WHEN TO USE:
         * max() is useful when you need the object
         * having the maximum value of a property.
         */

        Optional<Employee> highestPaid =
                employees.stream()
                         .max(
                             Comparator.comparing(
                                 Employee::getSalary
                             )
                         );

        System.out.println(
                "Highest paid employee: "
                + highestPaid
        );


        // ============================================================
        // 35. Lowest salary employee
        // ============================================================

        Optional<Employee> lowestPaid =
                employees.stream()
                         .min(
                             Comparator.comparing(
                                 Employee::getSalary
                             )
                         );

        System.out.println(
                "Lowest paid employee: "
                + lowestPaid
        );


        // ============================================================
        // 36. Top 2 highest-paid employees
        // ============================================================
        /*
         * VERY COMMON INTERVIEW QUESTION:
         *
         * Steps:
         *
         * 1. Sort salary descending
         * 2. limit(2)
         */

        List<Employee> topTwo =
                employees.stream()
                         .sorted(
                             Comparator.comparing(
                                 Employee::getSalary
                             ).reversed()
                         )
                         .limit(2)
                         .collect(Collectors.toList());

        System.out.println(
                "Top 2 employees: "
                + topTwo
        );


        // ============================================================
        // 37. Calculate total salary
        // ============================================================
        /*
         * REAL-WORLD DATABASE/REPORTING USE CASE:
         *
         * Calculate total salary of all employees.
         *
         * Employee -> salary
         * salary values -> double
         * double values -> sum
         */

        double totalSalary =
                employees.stream()
                         .mapToDouble(
                             Employee::getSalary
                         )
                         .sum();

        System.out.println(
                "Total salary: "
                + totalSalary
        );


        // ============================================================
        // 38. Calculate average salary
        // ============================================================

        OptionalDouble averageSalary =
                employees.stream()
                         .mapToDouble(
                             Employee::getSalary
                         )
                         .average();

        System.out.println(
                "Average salary: "
                + averageSalary
        );


        // ============================================================
        // 39. Complete Stream Pipeline
        // ============================================================
        /*
         * This is the kind of pipeline you should be able to
         * construct during an interview.
         *
         * Requirement:
         *
         * Find names of IT employees whose salary is
         * greater than 50000.
         *
         * Sort them by salary descending.
         */

        List<String> result =
                employees.stream()

                         // SELECT IT employees
                         .filter(e ->
                                 e.getDepartment()
                                  .equals("IT"))

                         // SELECT salary > 50000
                         .filter(e ->
                                 e.getSalary() > 50000)

                         // Sort salary descending
                         .sorted(
                             Comparator.comparing(
                                 Employee::getSalary
                             ).reversed()
                         )

                         // Employee -> String
                         .map(Employee::getName)

                         // Stream -> List
                         .collect(Collectors.toList());


        System.out.println(
                "Final result: "
                + result
        );
    }
}


/*
 * ================================================================
 * EMPLOYEE CLASS
 * ================================================================
 */

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;


    public Employee(
            int id,
            String name,
            String department,
            double salary) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    public int getId() {
        return id;
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

        return name +
                " (" +
                department +
                ", " +
                salary +
                ")";
    }
}