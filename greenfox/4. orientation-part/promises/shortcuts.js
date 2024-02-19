const promise = new Promise((resolve, reject) => {
	resolve("RESOLVED");
});

promise.catch(err => console.log(err));

const promise1 = new Promise.resolve("RESOLVED TOO");
const promise2 = new Promise.reject("REJECTED");

