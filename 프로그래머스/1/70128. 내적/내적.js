function solution(a, b) {
    let index = 0;
    return a.reduce((acc, cur) => acc += (cur * b[index++]), 0);
}