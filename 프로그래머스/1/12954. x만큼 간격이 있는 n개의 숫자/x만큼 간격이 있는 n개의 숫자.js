function solution(x, n) {
    let result = [];
    result.push(x);
    
    for (let i = 1; i < n; i++) {
        result.push(result[i - 1] + x);
    }
    
    return result;
}