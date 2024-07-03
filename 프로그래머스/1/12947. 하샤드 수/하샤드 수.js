function solution(x) {
    
    return x % x.toString()
    .split('')
    .reduce((total, e) => total += Number(e), 0) === 0 ? true : false;
}