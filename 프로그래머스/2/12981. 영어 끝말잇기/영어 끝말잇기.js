function solution(n, words) {
    let set = new Set();
    set.add(words[0]);
    
    for (let i = 1; i < words.length; i++) {
        if (set.has(words[i]) || 
            words[i - 1].charAt(words[i - 1].length - 1) !== words[i].charAt(0)
           ) {
            return [Math.floor(i % n + 1), Math.floor(i / n + 1)];
        }
        set.add(words[i]);
    }
    return [0, 0];
}

// 8