public class Palindrome {
    public static void main(String[] args) {
        String str = "abcdfcba";
        int low = 0;
        int high = str.length() - 1;
        char[] ch = str.toCharArray();
        while (low < high){
            if (ch[low] != ch[high]){
                System.out.println("Not Pallindrome");
                return;
            }
            low++;
            high--;
        }
        System.out.println("Pallindrome");
    }
}
