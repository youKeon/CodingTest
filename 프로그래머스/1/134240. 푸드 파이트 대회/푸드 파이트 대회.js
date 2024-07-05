function solution(food) {
    let arr = [];
    for (let i = 1; i < food.length; i++) {
        for (let j = 0; j < Math.floor(food[i] / 2); j++) {
            arr.push(i.toString());
        }
    }
    let str1 = arr.join('');
    let str2 = arr.reverse().join('');
    return str1 + '0' + str2;
}
