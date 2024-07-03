function solution(n) {
    let sum = 0;
    
    while (n > 0) {
        sum += Math.floor(n % 10);
        n /= 10;
    }
    
    return sum;
}