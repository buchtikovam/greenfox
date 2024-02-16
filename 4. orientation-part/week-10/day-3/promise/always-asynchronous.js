const promise = new Promise((fulfill, reject) => {
	fulfill("PROMISE VALUE")
});

promise.then(console.log);
console.log("MAIN PROGRAM");

// If you had a then block for your promise, it would be here.

// But for this task, we are only interested in the order of console logs.
