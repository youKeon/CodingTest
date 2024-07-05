function solution(k, score) {
    let arr = [];
    let ans = [];
    for (let i of score) {
        if (arr.length < k) {
            arr.push(i);
        } else {
            arr.sort((a, b) => a - b);
            if (arr[0] < i) {
                arr[0] = i
            }
        }
        ans.push(Math.min(...arr));
    }    
    return ans;
}