function solution(progresses, speeds) {
    let remain = progresses.map((e, i) => {
        let tmp = 100 - e;
        return tmp % speeds[i] === 0 ? 
            Math.floor(tmp / speeds[i]) :
            Math.floor(tmp / speeds[i]) + 1;
    });
    
    let count = 1;
    let ans = [];
    let max = remain[0];
    
    for (let i = 1; i < remain.length; i++) {
        if (remain[i] > max) {
            ans.push(count);
            count = 1;
            max = remain[i];
        } else {
            count++;
        }
    }
    
    ans.push(count);
    
    return ans;
}


