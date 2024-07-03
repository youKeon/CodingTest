function solution(left, right) {
    let sum = 0;
    for (let i = left; i <= right; i++) {
        if (isEven(i)) {
            sum += i;
        } else {
            sum -= i;
        }
    }
    return sum;
}

const isEven = (n) => {
    if (n === 1) {
        return false;
    }
    
    let count = 0;
    
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) {
            count++;
        }
    }
    
    return count % 2 === 0;
}