function solution(n) {
    for (let i = 1; i <= Math.floor(Math.sqrt(n)); i++) {
        if (Math.pow(i, 2) == n) {
            return Math.pow(i + 1, 2);
        }
    }
    return -1;
}