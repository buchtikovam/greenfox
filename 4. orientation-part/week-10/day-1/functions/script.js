// doubling exercise
console.log('Doubling:')

let baseNumber = 123;

function doubleNumber(number) {
    return number + number;
}

console.log(doubleNumber(baseNumber));
console.log('');


// greeting exercise
console.log('Greet:')
let nameToGreet = 'Green fox'

function Greet(name) {
    if (name != null) {
        return 'Greetings dear ' + name;
    }
    return 'Please provide a name to greet!'
}

console.log(Greet(nameToGreet));
console.log('');


// append a exercise
console.log('Append a:');

let typo = 'Chinchill';

function appendAFunc(typo) {
    return typo += 'a';
}

console.log(appendAFunc(typo));
console.log('');


// sum exercise
console.log('Sum');

function sum(number) {
    let result = 0;
    for (let i = 0; i <= number; i++) {
        result += i;
    }
    return result;
}

console.log(sum(5));
console.log('');