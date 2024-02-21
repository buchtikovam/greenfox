function reverseLongWords(string){
    const stringArr = string.split(" ");

    return stringArr.reduce((acc, value) => {
        return value.length >= 5 ?
            acc.concat(value.split("").reverse().join("")) :
            acc.concat(value)
    }, []).join(" ")
}

console.log(reverseLongWords("Hi lovely human"))