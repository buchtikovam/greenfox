const items = ["eggs", "milk", "fish", "apples", "bread", "chicken"];

console.log("Do we have milk in the shopping list? (yes/no)");
console.log(doesItemExist(items, "milk"));
console.log("");

console.log("Do we have bananas in the shopping list? (yes/no)");
console.log(doesItemExist(items, "bananas"));

function doesItemExist(list, param) {
	return list.includes(param);
}