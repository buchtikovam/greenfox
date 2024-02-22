function likes(names) {
    const arrSize = names.length;

    switch (arrSize) {
        case 0 :
            return "no one likes this";
            break;
        case 1 :
            return names[0] + " likes this";
            break;
        case 2 :
            return names[0] + ' and ' + names[1] + " like this";
            break;
        case 3 :
            return names[0] + ', ' + names[1] + " and " + names[2] + " like this";
            break;
        default:
            return names[0] + ', ' + names[1] + " and " + (names.length - 2) + " others like this";
    }
}

console.log(likes(["Moni", "Juraj", "Kare"]))
// expected output: "Moni, Juraj and Kare like this"