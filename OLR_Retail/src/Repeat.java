public class Repeat {
    public static void main(String[] args) {
        String s = "AB";
        int n = 3;
//        System.out.println(s.repeat(n));
        String ans = repeatString(s, n);
        System.out.println(ans);
    }
    public static String repeatString(String s, int n){
        if (n == 0) return "";
        return s + repeatString(s, n - 1);
    }
}
