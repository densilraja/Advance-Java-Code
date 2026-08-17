public class AmstrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int copy = num;
        int len = 0;
        while (copy > 0){
            len++;
            copy /= 10;
        }
        copy = num;
        int amstro = 0;
        while (copy > 0){
            int digit = copy % 10;
            amstro += (int) Math.pow(digit, len);
            copy /= 10;
        }
        System.out.println(num == amstro);
    }
}
