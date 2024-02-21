function encodeRoman(number){
    if (number < 1 || number > 3999) {
        return "invalid input";
    }

    const symbolMap = new Map([
        [1000, "M"],
        [900, "CM"],
        [500, "D"],
        [400, "CD"],
        [100, "C"],
        [90, "XC"],
        [50, "L"],
        [40, "XL"],
        [10, "X"],
        [9, "IX"],
        [5, "V"],
        [4, "IV"],
        [1, "I"],
    ]);

    let romanNumeral = "";

    for (const [value, symbol] of symbolMap) {
        while (number >= value) {
            romanNumeral += symbol;
            number -= value;
        }
    }

    return romanNumeral;
}

console.log(encodeRoman(2561))