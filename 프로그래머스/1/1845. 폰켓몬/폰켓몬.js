function solution(nums) {
    let set = new Set();
    let n = nums.length / 2;
    let filted = nums.filter(e => {
        if (set.has(e)) return false;
        set.add(e);
        return true;
    }).length;

    return Math.min(filted, n);
}