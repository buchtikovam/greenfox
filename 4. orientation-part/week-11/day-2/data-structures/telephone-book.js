const contacts = new Map([
	["William A. Lathan", "405-709-1865"],
	["John K. Miller", "402-247-8568"],
	["Hortensia E. Foster", "606-481-6467"],
	["Amanda D. Newland", ""],
	["Brooke P. Askew", "307-687-2982"],
]);

console.log("What is John K. Miller's phone number?");
console.log(contacts.get("John K. Miller"));
console.log("");

console.log("Whose phone number is 307-687-2982?");
console.log(getKeyByValue(contacts, "307-687-2982"));
console.log("");

console.log("Do we know Chris E. Myers' phone number? (yes/no)");
console.log(doesEntryExist(contacts, "Chris E. Myers"));

function getKeyByValue(map, value) {
	for (let [k, v] of map.entries()) {
		if (v === value) {
			return k;
		}
	}
	return null;
}

function doesEntryExist(map, key) {
	return map.has(key);
}
