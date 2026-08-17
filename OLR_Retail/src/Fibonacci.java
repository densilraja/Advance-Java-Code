public class Fibonacci {
    public static void main(String[] args) {
        int first = 0;
        int second = 1;
        int n = 10;
        System.out.println(first);
        System.out.println(second);
        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.println(next);
            first = second;
            second = next;
        }
    }
}
