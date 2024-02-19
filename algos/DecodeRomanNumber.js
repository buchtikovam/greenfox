const symbolsMap = new Map([
    ["I", 1],
    ["V", 5],
    ["X", 10],
    ["L", 50],
    ["C", 100],
    ["D", 500],
    ["M", 1000],
    ["IV", 4],
    ["IX", 9],
    ["XL", 40],
    ["XC", 90],
    ["CD", 400],
    ["CM", 900],
]);

function decodeRoman(romanNumeral) {
    let result = 0;

    for (let i = 0; i < romanNumeral.length; i++) {
        const currentSymbol = romanNumeral[i];
        const nextSymbol = romanNumeral[i + 1];

        if (symbolsMap.has(currentSymbol + nextSymbol)) {
            result += symbolsMap.get(currentSymbol + nextSymbol);
            i++;
        } else if (symbolsMap.has(currentSymbol)) {
            result += symbolsMap.get(currentSymbol);
        } else {
            throw new Error(`Invalid Roman numeral symbol: ${currentSymbol}`);
        }
    }

    if (result > 3999) {
        throw new Error("Roman numeral value exceeds supported range (max 3999)");
    }

    return result;
}

console.log(decodeRoman("CMLXLI"))