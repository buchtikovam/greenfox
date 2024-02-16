const expenses = [500, 1000, 1250, 175, 800, 120];

console.log("How much did we spent?");
console.log(sum(expenses));
console.log("");

console.log("What was out greatest expense?");
console.log(getGreatest(expenses));

console.log("What was the cheapest?");
console.log(getCheapest(expenses));
console.log("");

console.log("What was the average of our expenses?");
console.log(getAverage(expenses));
console.log("");

function sum(listA) {
	let result = 0;

	listA.forEach((number) => {
		result += number;
	});

	return result;
}

function getGreatest(listA) {
	let result = 0;

	listA.forEach((number) => {
		if (number > result) {
			result = number;
		}
	});

	return result;
}

function getCheapest(listA) {
	listA.sort(function (a, b) {
		return a - b;
	});
	return listA[0];
}

function getAverage(listA) {
	let length = listA.length;
	return sum(listA) / length;
}
