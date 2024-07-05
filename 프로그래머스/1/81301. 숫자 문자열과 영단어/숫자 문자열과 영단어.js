function solution(s) {
    let arr = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];

    arr.forEach((e, i) => {
        s = s.replaceAll(e, i);
    });

    return Number(s);
}