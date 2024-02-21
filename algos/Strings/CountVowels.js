function getCount(str) {
    const vowelArr = ["a", "e", "i", "o", "u"];
    const letterArr = str.toLowerCase().split("");

    return letterArr.reduce((acc, value) => {
        return vowelArr.includes(value) ? acc + 1 : acc;
    }, 0);
}

console.log(getCount("hello lovely human looking at my github"))