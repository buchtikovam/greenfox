function sortOnlyOddNumbers(array) {
    let sortedArray = [];
    let oddNumArray = [];
    let evenNumMap = new Map();

    for(let i = 0; i < array.length; i++) {
        if(array[i] % 2 === 0) {
            evenNumMap.set(i, array[i]);
        } else {
            oddNumArray.push(array[i]);
        }
    }

    oddNumArray.sort((a, b) => a - b)

    for (let i = 0; i < array.length; i++) {
        if (evenNumMap.has(i)) {
            for (let [key, value] of evenNumMap) {
                if (key === i) {
                    sortedArray.push(value)
                    break;
                }
            }
        } else {
            sortedArray.push(oddNumArray[0]);
            oddNumArray.splice(0, 1);
        }
    }

    return sortedArray;
}

console.log(sortOnlyOddNumbers([2, 7, 5, 4, 1]))
// expected result [ 2, 1, 5, 4, 7 ]