const button = document.querySelector("button");
const div = document.querySelector("div");

button.setAttribute("onclick", "getJoke()");

function getJoke() {
	fetch("https://api.chucknorris.io/jokes/random")
		.then((response) => response.json())
		.then((data) => renderJoke(data))
		.catch((error) => console.log(console.error()));
}

function renderJoke(data) {
	let h2 = document.createElement("h2");
	h2.textContent = data.value;
	div.append(h2);
}
