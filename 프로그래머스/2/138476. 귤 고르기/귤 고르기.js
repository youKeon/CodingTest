function solution(k, tangerine) {
    let fre = tangerine.reduce((acc, cur) => {
        acc[cur] = (acc[cur] || 0) + 1; 
        return acc;
    }, {});
    
    let sortedFre = Object.values(fre).sort((a, b) => b - a);
    
    let ans = 0;
    for (let i of sortedFre) {
        k -= i;
        ans++;
        
        if (k <= 0) {
            return ans;
        }
    }
    
    return ans;
}