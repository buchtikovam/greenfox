const products = new Map([
	["Eggs", 200],
	["Milk", 200],
	["Fish", 400],
	["Apples", 150],
	["Bread", 50],
	["Chicken", 550],
]);

console.log("How much is the fish?");
console.log(products.get("Fish"));
console.log("");

console.log("What is the most expensive product?");
console.log(getGreatest(products));
console.log("");

console.log("What is the average price?");
console.log(getAverage(products));
console.log("");

console.log("How many products' price is below 300?");
console.log(getCheaperThan(products, 300));
console.log("");

console.log("Is there anything we can buy for exactly 125?");
console.log(isItemEqaulToParam(products, 150));
console.log("");

console.log("What is the cheapest product?");
console.log(getCheapest(products));
console.log("");

function getGreatest(map) {
	let result = 0;

	for (let [k, v] of map.entries()) {
		if (v > result) {
			result = v;
		}
	}

	return getKeyByValue(map, result);
}

function getKeyByValue(map, value) {
	for (let [k, v] of map.entries()) {
		if (v === value) {
			return k;
		}
	}

	return null;
}

function getAverage(map) {
	let sum = 0;
	let items = 0;

	for (let [k, v] of map.entries()) {
		sum += v;
		items++;
	}

	return sum / items;
}

function getCheaperThan(map, param) {
	let result = 0;

	for (let [k, v] of map.entries()) {
		if (v < param) {
			result++;
		}
	}

	return result;
}

function isItemEqaulToParam(map, param) {
	for (let [k, v] of map.entries()) {
		if (v === param) {
			return true;
		}
	}

	return false;
}

function getCheapest(map) {
	let num = Infinity;

	for (let [k, v] of map.entries()) {
		if (v < num) {
			num = v;
		}
	}

	return getKeyByValue(map, num);
}
