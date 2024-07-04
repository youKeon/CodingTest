function solution(n) {
    let arr = [];
    for (let i = 1; i <= n; i++) {
        arr.push(i);
    }
    
    let p1 = 0;
    let p2 = 0;
    let ans = 0;
    let sum = 0;
    
    while (p2 <= n) {
        sum += arr[p2++];
        
        while (sum > n) {
            sum -= arr[p1++];
        }
        
        if (sum == n) {
            ans++;
        }
    }
    return ans;
}