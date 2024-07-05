function solution(cards1, cards2, goal) {
    let p1 = 0;
    let p2 = 0;
    let ans = 'Yes';
    
    goal.forEach(e => {
        if (p1 < cards1.length && e === cards1[p1]) p1++;
        else if (p2 < cards2.length && e === cards2[p2]) p2++;
        else ans = 'No';
    });
    
    return ans;
}