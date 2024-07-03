function solution(arr) {
    return arr.filter((e, i) => {
        if (i == 0) return true;
        if (arr[i - 1] != e) return true;
        return false;
    });
}