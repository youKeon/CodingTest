import java.util.*;

public class Main {
    static final int MAX = 4000000 + 10;
    static int N;
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean[] isPrime = new boolean[MAX+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sieve();
        System.out.println(countCases());
    }

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }

    static int countCases() {
        int cnt = 0;
        int end = 0;
        int sum = 0;
        
        for (int start = 0; start < primes.size(); start++) {
            while (sum < N && end < primes.size()) {
                sum += primes.get(end++);
            }
            if (sum == N) cnt++;
            sum -= primes.get(start);
        }
        return cnt;
    }
}
