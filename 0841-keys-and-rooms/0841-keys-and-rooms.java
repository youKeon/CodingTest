class Solution {
    List<List<Integer>> rooms;
    boolean ans = false;
    boolean[] isVisited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        this.isVisited = new boolean[rooms.size()];

        dfs(0);
        isValidate();

        return ans;
    }

    private void dfs(int l) {
        isVisited[l] = true;
        for (int i = 0; i < rooms.get(l).size(); i++) {
            if (!isVisited[rooms.get(l).get(i)]) {
                dfs(rooms.get(l).get(i));
            }
        }
    }

    private void isValidate() {
        for (boolean visited : isVisited) {
            if (!visited) return;
        }
        ans = true;
    }
}