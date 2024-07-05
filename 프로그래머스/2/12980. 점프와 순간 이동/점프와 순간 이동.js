function solution(n) {
    if (n === 1) {
        return 1;
    }
    
    let ans = 0;
    
    while (n > 0) {
        if (n % 2 === 0) {
            n /= 2;
        } else {
            n--;
            ans++;
        }
    }
    
    return ans;
}