function solution(s) {
    if (s.length !== 4 && s.length !== 6) {
        return false;
    }
    
    for (let char of s) {
        if (char < '0' || char > '9') {
            return false;
        }
    }
    
    return true;
}