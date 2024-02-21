function alphabetPosition(text) {
    let alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
    let lowText = text.toLowerCase();
    let result = '';

    for(let i = 0; i < lowText.length; i++) {
        let currentLetter = lowText[i];

        for(let j = 0; j < alphabet.length; j++) {

            if(currentLetter === alphabet[j]) {
                result += j + 1 + ' ';
            }
        }
    }

    return result.trim();
}

console.log(alphabetPosition("banana"));