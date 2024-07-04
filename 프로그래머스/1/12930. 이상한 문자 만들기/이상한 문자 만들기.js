function solution(s) {
    return s.split(' ').map(e => e.split('').map((char, index) => index % 2 === 0 ? char.toUpperCase() : char.toLowerCase()).join('')).join(' ');
}