function solution(people, limit) {
    people.sort((a, b) => a - b);
    
    let ans = 0;
    let p1 = 0;
    let p2 = people.length - 1;
    
    while (p1 <= p2) {
        let sum = people[p1] + people[p2];
        
        if (sum <= limit) {
            ans++;
            p1++;
            p2--;
        } else {
            ans++;
            p2--;
        }
    }
    return ans;
}