function solution(s){
    let arr = s.toLowerCase().split('');
    let count = 0;
    arr.forEach(e => {
        if (e === 'p') {
            count++;
        } else if (e === 'y'){
            count--;
        }
    });

    return count === 0;
}