package Comparator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "densil", 12500.0);
        Employee e2 = new Employee(103, "raja", 1500.0);
        Employee e3 = new Employee(102, "daniel", 10500.0);

        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(103, "Ravi", 50000));
        list.add(new Employee(101, "Arun", 70000));
        list.add(new Employee(102, "Bala", 40000));
        list.add(new Employee(104, "Raju", 50000));

//        System.out.println(e1);
        System.out.println(list);
//        list.sort((s1, s2) -> s1.id - s2.id);    // Not safer due to int limit
        list.sort((s1, s2) -> Integer.compare(s2.id, s1.id)); //safer because of Integer
        System.out.println(list);

        list.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println(list);

        list.sort((s1, s2) -> Double.compare(s2.salary, s1.salary));
        System.out.println(list);

        list.sort((s1, s2) -> {
            if (s1.salary != s2.salary) return Double.compare(s1.salary, s2.salary);
            return s1.name.compareTo(s2.name);
        });

        list.sort((s1, s2) -> {
            int res = Double.compare(s2.salary, s1.salary);
            if (res != 0) return res;
            res = s1.name.compareTo(s2.name);
            if (res != 0) return res;
            return Integer.compare(s1.id, s2.id);
        });
    }
}
