function solution(n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    
    let result = 1;
    for (let i = 2; i <= n; i++) {
        if (n % i == 0) {
            result += i;
        }
    }
    return result;
}