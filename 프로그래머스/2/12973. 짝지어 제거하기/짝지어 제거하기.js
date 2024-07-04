function solution(s) {
    let stack = [];

    for (let c of s) {
        if (stack.length === 0) {
            stack.push(c);
            continue;
        }

        if (stack[stack.length - 1] !== c) {
            stack.push(c);
            continue;
        }
        
        while (stack.length > 0 && stack[stack.length - 1] === c) {
            stack.pop();
        }
    }

    return stack.length === 0 ? 1 : 0;
}