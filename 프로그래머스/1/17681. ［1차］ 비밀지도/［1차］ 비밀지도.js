function solution(n, arr1, arr2) {
    return arr1.map((value, index) => {
        let binaryString = (value | arr2[index]).toString(2).padStart(n, '0');
        return [...binaryString].map(char => char === '1' ? '#' : ' ').join('');
    });
}