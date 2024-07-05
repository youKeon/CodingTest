function solution(array, commands) {
    let ans = [];

    for (let e of commands) {
        let start = e[0] - 1;
        let end = e[1];
        let index = e[2] - 1;

        let arr = array.slice(start, end).sort((o1, o2) => o1 - o2);
        ans.push(arr[index]);
    }

    return ans;
}
