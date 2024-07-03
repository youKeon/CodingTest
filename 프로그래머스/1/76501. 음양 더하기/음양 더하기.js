function solution(absolutes, signs) {
    let result = 0;
    
    for (let i = 0; i < signs.length; i++) {
        let num = absolutes[i];
        let sign = signs[i];
        
        if (sign) {
            result += num;
        } else {
            result -= num;
        }
    }
    return result;
}