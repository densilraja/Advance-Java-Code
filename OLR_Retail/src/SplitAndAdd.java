public class SplitAndAdd {
    public static void main(String[] args) {
        String str1 = "<<<>>>";
        String str2 = "Hello";
        int n = str1.length();
        String first = str1.substring(0, n / 2);
        String second = str1.substring(n / 2, n);
        System.out.println(first + str2 + second);
    }
}
