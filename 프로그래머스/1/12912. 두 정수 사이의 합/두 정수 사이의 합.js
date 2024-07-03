function solution(a, b) {
    if (a > b) {
        let tmp = a;
        a = b;
        b = tmp;
    }
    
    let result = 0;
    for (let i = a; i <= b; i++) {
        result += i;
    }
    
    return result;
}