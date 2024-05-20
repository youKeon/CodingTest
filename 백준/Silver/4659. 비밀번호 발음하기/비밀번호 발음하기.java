import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            boolean vowelsCheck = false;
            boolean consonantsCheck = true;
            int vowelsCount = 0;
            int consonantsCount = 0;

            String statement = br.readLine();
            if (statement.equals("end")) break;

            for (int i = 0; i < statement.length(); i++) {
                char cur = statement.charAt(i);

                if (i > 0 && cur == statement.charAt(i - 1)) {
                    if (!(cur == 'o' || cur == 'e')) {
                        vowelsCheck = false;
                        break;
                    }
                }

                if (isVowels(cur)) {
                    vowelsCheck = true;
                    vowelsCount++;
                    consonantsCount = 0;

                    if (vowelsCount == 3) {
                        vowelsCheck = false;
                        break;
                    }

                } else {
                    vowelsCount = 0;
                    consonantsCount++;
                    if (consonantsCount == 3) {
                        consonantsCheck = false;
                        break;
                    }
                }
            }
            String result = vowelsCheck && consonantsCheck ? "acceptable." : "not acceptable.";
            bw.write("<" + statement + "> is " + result);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static boolean isVowels(char cur) {
        return cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u';
    }
}