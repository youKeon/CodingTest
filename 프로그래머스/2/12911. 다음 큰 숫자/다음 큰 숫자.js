function solution(n) {
    let count = n.toString(2).split('0').join('').length;
    let num = n + 1;
    
    while (true) {
        if (isTarget(num, count)) {
            return num;
        }
        num++;
    }
}

const isTarget = (num, count) => {
    return num.toString(2).split('0').join('').length === count;
}