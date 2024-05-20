import java.io.*;
import java.util.*;

class Main {
    static class Location {
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n + 1][n + 1];
        Location heartLocation = new Location(0, 0);
        boolean isFind = false;

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = tmp.charAt(j - 1);

                if (!isFind && map[i][j] == '*') {
                    heartLocation.y = i + 1; // y
                    heartLocation.x = j; // x
                    isFind = true;
                }
            }
        }
        bw.write(heartLocation.y + " " + heartLocation.x);
        bw.newLine();

        int leftArmLength = getLeftArmLength(map, heartLocation);
        int rightArmLength = getRightArmLength(map, heartLocation);
        int waistLength = getWaistLength(map, heartLocation);
        int leftLegLength = getLeftLegLength(map, heartLocation, waistLength);
        int rightLegLength = getRightLegLength(map, heartLocation, waistLength);

        bw.write(leftArmLength + " " + rightArmLength + " " + waistLength + " " + leftLegLength + " " + rightLegLength);
        bw.close();
        br.close();
    }

    private static int getWaistLength(char[][] map, Location heartLocation) {
        int y = heartLocation.y + 1;
        int x = heartLocation.x;
        int count = 0;
        while (map[y][x] == '*') {
            y++;
            count++;
        }
        return count;
    }

    private static int getRightLegLength(char[][] map, Location heartLocation, int waistLength) {
        Location waistEndLocation = new Location(heartLocation.y + waistLength, heartLocation.x);
        Location rightLegLocation = new Location(waistEndLocation.y + 1, waistEndLocation.x + 1);

        int y = rightLegLocation.y;
        int x = rightLegLocation.x;
        int count = 0;
        while (y < map.length && map[y][x] == '*') {
            y++;
            count++;
        }
        return count;
    }

    private static int getLeftLegLength(char[][] map, Location heartLocation, int waistLength) {
        Location waistEndLocation = new Location(heartLocation.y + waistLength, heartLocation.x);
        Location leftLegLocation = new Location(waistEndLocation.y + 1, waistEndLocation.x - 1);

        int y = leftLegLocation.y;
        int x = leftLegLocation.x;
        int count = 0;
        while (y < map.length && map[y][x] == '*') {
            y++;
            count++;
        }
        return count;
    }

    private static int getRightArmLength(char[][] map, Location heartLocation) {
        int y = heartLocation.y;
        int x = heartLocation.x + 1;
        int count = 0;
        while (x < map.length && map[y][x] == '*') {
            x++;
            count++;
        }
        return count;
    }

    private static int getLeftArmLength(char[][] map, Location heartLocation) {
        int y = heartLocation.y;
        int x = heartLocation.x - 1;
        int count = 0;
        while (map[y][x] == '*') {
            x--;
            count++;
        }
        return count;
    }
}