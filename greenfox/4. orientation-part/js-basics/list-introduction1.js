const listOfNames = [];
console.log(listOfNames.length);

listOfNames.push("William");
console.log(listOfNames.length === 0);

listOfNames.push("John");
listOfNames.push("Amanda");
console.log(listOfNames.length);
console.log(listOfNames[2]);

for (let i = 0; i < listOfNames.length; i++) {
	console.log(listOfNames[i]);
}

for (let i = 0; i < listOfNames.length; i++) {
	console.log(i + 1 + ". " + listOfNames[i]);
}

listOfNames.splice(1, 1);

for (let i = listOfNames.length - 1; i >= 0; i--) {
	console.log(listOfNames[i]);
}

listOfNames.length = 0;

console.log(listOfNames.length);