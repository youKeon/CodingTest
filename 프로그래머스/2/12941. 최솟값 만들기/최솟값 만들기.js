function solution(A,B){
    A.sort((o1, o2) => o1 - o2);
    B.sort((o1, o2) => o2 - o1);
    
    let index = 0;
    return A.reduce((acc, cur) => acc += (cur * B[index++]), 0);
}