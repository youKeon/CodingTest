class Solution {
    Queue<Node> queue;
    int[][] image;
    boolean[][] isVisited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        queue = new LinkedList<>();
        queue.add(new Node(sr, sc));
        isVisited = new boolean[image.length][image[0].length];
        this.image = image;
        int target = image[sr][sc];
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curNode.y + dy[i];
                int nx = curNode.x + dx[i];

                if (isInBound(ny, nx) && !isVisited[ny][nx] && image[ny][nx] == target) {
                    image[ny][nx] = color;
                    isVisited[ny][nx] = true;
                    queue.add(new Node(ny, nx));
                }
            }
        }
        return image;
    }

    private boolean isInBound(int ny, int nx) {
        return (ny >= 0 && ny < image.length) && (nx >= 0 && nx < image[0].length);
    }
}