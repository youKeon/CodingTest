class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;

        for (String s : skill_trees) {
            int pointer = 0;
            boolean isAble = true;

            for (int i = 0; i < s.length(); i++) {
                if (skill.indexOf(s.charAt(i)) == -1) {
                    continue;
                }

                if (skill.indexOf(s.charAt(i)) != pointer) {
                    isAble = false;
                    break;
                }

                pointer++;
            }

            if (isAble) {
                ans++;
            }
        }
        return ans;
    }
}