function solution(s){
    let stack = [];
    
    for (const e of s) {
        if (stack.length === 0) {
            stack.push(e);
        } else {
            if (e === '(' || e === '{' || e === '[') {
                stack.push(e);
            } else {
                if (e === ')' && stack[stack.length - 1] === '(') {
                    stack.pop();
                    continue;
                }
                if (e === '}' && stack[stack.length - 1] === '{') {
                    stack.pop();
                    continue;
                }
                if (e === ']' && stack[stack.length - 1] === '[') {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
    }
    return stack.length === 0;
}