import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // získání horní meze prvočísel
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ceiling of the prime numbers: "); // horní mez = ceiling
        int n = sc.nextInt();
        sc.close();

        // init numbers array, type boolean - where ture denotes primality
        boolean[] isPrime = new boolean[n];

        // initialze all elements to true because in default the are all false
        isPrime[0] = false;
        for (int i = 1; i < n; i++) { // začínám 1, protože 1 není prvočíslo tak nechám false
            isPrime[i] = true;
        }

        // check every number >= 2 for primality
        for (int j = 2; j <= n; j++) {

            // i is prime if it hasnt been crossed off yet
            if(isPrime[j - 1]){ // není potřeba isPrime[j - 1] == true, protože samo osobě isPrime[j - 1] bude platit jestlo je true

                // print out prime number
                System.out.println(j);

                // crossing of all the subsequent multiples of j
                //for (int k = 2*j; k <= n; k += j)
                for (int k = j*j; k <= n; k += j) { //more efficient
                    isPrime[k-1] = false;
                }
            }

        }
    }
}