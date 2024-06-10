class Solution {
    public long solution(int price, int money, int count) {
        long needMoney = 0;
        for (int i = 1; i <= count; i++) {
            needMoney += price * i;
        }
        return needMoney <= money ? 0 : needMoney - money;
    }
}