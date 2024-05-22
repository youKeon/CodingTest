import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] requests = new int[n];
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }
        int totalBudget = sc.nextInt();

        System.out.println(findMaxAllocation(requests, totalBudget));
    }

    public static int findMaxAllocation(int[] requests, int totalBudget) {
        int low = 0;
        int high = 0;
        for (int req : requests) {
            if (req > high) {
                high = req;
            }
        }

        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(requests, totalBudget, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static boolean isFeasible(int[] requests, int totalBudget, int cap) {
        int sum = 0;
        for (int req : requests) {
            sum += Math.min(req, cap);
        }
        return sum <= totalBudget;
    }
}
