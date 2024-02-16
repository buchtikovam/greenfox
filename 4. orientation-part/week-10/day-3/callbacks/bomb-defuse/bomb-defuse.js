const time = 10;
let remainingTime = time;
const button = document.querySelector("button");
const display = document.querySelector(".display");
button.setAttribute("onclick", "defuse()");

const interval = setInterval(() => {
	if (remainingTime > 0) {
		display.textContent = remainingTime;
		remainingTime--;
	} else {
		clearInterval(interval);
		explode();
	}
}, 1000);

function defuse() {
	clearInterval(interval);
	display.textContent = "Bomb defused! :)";
}

function explode() {
	display.textContent = "Bomb exploded! :(";
}
