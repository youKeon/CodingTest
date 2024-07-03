function solution(t, p) {
    let result = 0;
    let num = Number(p);
    for (let i = 0; i <= t.length - p.length; i++) {
        let tmp = t.substring(i, i + p.length);
        if (Number(tmp) <= num) {
            result++;
        }
    }
    return result;
}