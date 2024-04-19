class Solution
{
    public int solution(int n, int a, int b)
    {
        int ans = 0;

        while(a != b) {
            a = (a / 2) + (a % 2); 
            b = (b / 2) + (b % 2);

            ans++; 
        }

        return ans;
    }
}