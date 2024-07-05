function solution(numbers) {
    let set = [];

    for (let i = 0; i < numbers.length - 1; i++) {
        for (let j = i + 1; j < numbers.length; j++) {
            if (!set.includes(numbers[i] + numbers[j])) {
                set.push(numbers[i] + numbers[j]);
            }
        }
    }
    return set.sort((o1, o2) => o1 - o2);
}