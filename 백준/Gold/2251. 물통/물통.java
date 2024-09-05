import java.util.*;

class Main {
    static class State {
        int[] jugs;
        State(int a, int b, int c) {
            jugs = new int[]{a, b, c};
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Arrays.equals(jugs, state.jugs);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(jugs);
        }
    }

    public static Set<Integer> solve(int A, int B, int C) {
        int[] capacities = {A, B, C};
        Set<Integer> result = new TreeSet<>();
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State initial = new State(0, 0, C);
        queue.offer(initial);
        visited.add(initial);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.jugs[0] == 0) {
                result.add(current.jugs[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        State next = pour(current, i, j, capacities);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static State pour(State current, int from, int to, int[] capacities) {
        int[] newJugs = Arrays.copyOf(current.jugs, 3);
        int amount = Math.min(current.jugs[from], capacities[to] - current.jugs[to]);
        newJugs[from] -= amount;
        newJugs[to] += amount;
        return new State(newJugs[0], newJugs[1], newJugs[2]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        Set<Integer> result = solve(A, B, C);
        for (int amount : result) {
            System.out.print(amount + " ");
        }
    }
}