function solution(strings, n) {
    return strings.sort((o1, o2) => {
        if (o1.charAt(n) < o2.charAt(n)) return -1;
        if (o1.charAt(n) > o2.charAt(n)) return 1;
        if (o1 < o2) return -1;
        if (o1 > o2) return 1;
        return 0;
    });
}