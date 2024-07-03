function solution(d, budget) {
    d.sort((a, b) => a - b);

    let total = 0;
    let count = 0;
    
    for (let i = 0; i < d.length; i++) {
        total += d[i];
        if (total > budget) {
            break;
        }
        count++;
    }
    
    return count;
}
