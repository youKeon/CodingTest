function solution(arr, divisor) {
    let result = arr.filter(e => e % divisor === 0).sort((o1, o2) => o1 - o2);
    return result.length === 0 ? [-1] : result;

}