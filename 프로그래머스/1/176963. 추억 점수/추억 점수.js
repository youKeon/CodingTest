function solution(name, yearning, photo) {
    const map = name.reduce((acc, cur, index) => {
        acc[cur] = yearning[index];
        return acc;
    }, {});

    return photo.map(e => {
        return e.reduce((acc, cur) => {
            acc += map[cur] || 0;
            return acc;
        }, 0)
    });
}
