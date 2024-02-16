const myMap = new Map([
	["978-1-60309-452-8", "A Letter to Jo"],
	["978-1-60309-459-7", "Lupus"],
	["978-1-60309-444-3", "Red Panda and Moon Bear"],
	["978-1-60309-461-0", "The Lab"],
]);

myMap.forEach(function (value, key) {
	console.log(key + " (" + value + ")");
});

myMap.delete("978-1-60309-444-3");
myMap.delete(getKeyByValue(myMap, "The Lab"));

myMap.forEach(function (value, key) {
	console.log(key + " (" + value + ")");
});

myMap.set("978-1-60309-450-4", "They Called Us Enemy");
myMap.set("978-1-60309-453-5", "Why Did We Trust Him?");

console.log(myMap.has("478-0-61159-424-8"));
console.log(myMap.get("978-1-60309-453-5"));

function getKeyByValue(map, value) {
	for (let [k, v] of map.entries()) {
		if (v === value) {
			return k;
		}
	}
	return null;
}
