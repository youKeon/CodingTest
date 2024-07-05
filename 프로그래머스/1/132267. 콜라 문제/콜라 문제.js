function solution(a, b, n) {
    let emptyCoke = n;
    let coke = 0;
    let ans = 0;
    
    while (emptyCoke >= a) {
        coke = Math.floor((emptyCoke / a)) * b;
        ans += coke;
        emptyCoke = Math.floor(emptyCoke % a);
        emptyCoke += coke;
    }
    
    return ans;
}