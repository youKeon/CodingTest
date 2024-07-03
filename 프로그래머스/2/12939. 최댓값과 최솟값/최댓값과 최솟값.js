function solution(s) {
    let result = [];
    let arr = s.split(' ');
    
    result.push(Math.min(...arr));
    result.push(Math.max(...arr));
    
    return result.join(' ');
}