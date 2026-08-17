public class PrimeNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 57, 7, -9, 4,};
        for (int j = 0; j < arr.length; j++) {
            boolean isPrime = true;
            if (arr[j] <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i < arr[j]/2; i++) {
                    if (arr[j] % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println(arr[j] + " is Prime Number");
            } else {
                System.out.println(arr[j] + " is Not Prime Number");
            }
        }
    }
}
