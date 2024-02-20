function goodVsEvil(goodCount, evilCount) {
    let power = [
        [1, 2, 3, 3, 4, 10], // good side
        [1, 2, 2, 2, 3, 5, 10] // evil side
    ];

    let good = goodCount
        .split(' ')
        .reduce((acc, value, index) => acc + power[0][index] * value, 0);
    let evil = evilCount
        .split(' ')
        .reduce((acc, value, index) => acc + power[1][index] * value, 0);

    if (good > evil) {
        return "Battle Result: Good triumphs over Evil";
    } else if (evil > good) {
        return "Battle Result: Evil eradicates all trace of Good";
    } else {
        return "Battle Result: No victor on this battle field";
    }
}

console.log(goodVsEvil('3 1 1 1 1 1', '1 1 1 1 1 1 1'))