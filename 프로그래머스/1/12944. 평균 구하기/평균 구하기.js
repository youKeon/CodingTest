function solution(arr) {
    return arr.reduce((total, e) => total += e, 0) / arr.length;
}