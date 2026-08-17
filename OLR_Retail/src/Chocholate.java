public class Chocholate {
    public static void main(String[] args) {
        String s = "chocholate";
        int n = 4;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0 ; i--) {
            sb.append(s.substring(0, i));
        }
        System.out.println(sb);
    }
}
