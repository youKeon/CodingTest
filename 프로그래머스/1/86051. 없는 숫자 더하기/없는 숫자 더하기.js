function solution(numbers) {
    let set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    return set.reduce((acc, cur) => {
        if (!numbers.includes(cur)) {
            acc += cur;
        }
        return acc;
    }, 0);
}