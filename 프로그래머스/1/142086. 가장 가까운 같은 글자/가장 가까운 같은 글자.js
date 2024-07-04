function solution(s) {
    if (s.length === 1) return [-1];

    let map = new Map();
    let result = [];

    for (let i = 0; i < s.length; i++) {
        if (map.has(s.charAt(i))) {
            result.push(i - map.get(s.charAt(i)));
        } else {
            result.push(-1);
        }
        map.set(s.charAt(i), i);
    }
    
    return result;
}
