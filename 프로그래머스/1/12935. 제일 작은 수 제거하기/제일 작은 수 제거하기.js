function solution(arr) {
    if (arr.length === 1) return [-1];
    let min = Number.MAX_VALUE;
    
    arr.forEach(e => min = Math.min(min, e));
    
    return arr.filter(e => e !== min);
}