function highestScore(x){
    let alphabet = 'abcdefghijklmnopqrstuvwxyz'.split('');
    let alphabetMap = new Map();
    let iterator = 1;

    alphabet.forEach((letter) => {
        alphabetMap.set(letter, iterator++)
    })

    let words = x.toString().split(",");
    let score = 0;
    let highestScore = 0;
    let winner = "";


    words.forEach((word) => {
        for(let i = 0; i < word.length; i++) {
            score += alphabetMap.get(word[i]);
        }

        if (score > highestScore) {
            highestScore = score;
            winner = word;
        }

        score = 0;
    })

    return winner;
}

let words = ["hi", "banana", "zoo", "apple", "hedgehog"]
console.log(highestScore(words));