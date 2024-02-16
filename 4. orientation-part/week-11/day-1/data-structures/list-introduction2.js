const listA = ["Apple", "Avocado", "Blueberries", "Durian", "Lychee"];

const listB = ["Apple", "Avocado", "Blueberries", "Durian", "Lychee"];

console.log(listA.includes("Durian"));

listB.splice(2, 1);
listA.push("Kiwifruit");

console.log(compareFunction(listA, listB));
console.log(listA.indexOf("Avocado"));
console.log(listB.indexOf("Durian"));

listB.push("Passion fruit", "Pomelo");

console.log(listA[2]);
console.log(listA.toString());
console.log(listB.toString());

function compareFunction(listA, listB) {
	if (listA.length === listB.length) {
		return "Lists are even.";
	}

	if (listA.length > listB.length) {
		return "List A is bigger.";
	}

	if (listA.length < listB.length) {
		return "List B is bigger.";
	}
}
