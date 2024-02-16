function generateDivs(repetitions) {
	const section = document.querySelector("section");
	let currentIndex = 0;
	const allDivs = [];

	for (let i = 0; i < repetitions; i++) {
		let div = document.createElement("div");
		div.textContent = i + 1;
		section.append(div);
		allDivs.push(div);
	}

	const interval = setInterval(() => {
		if (currentIndex < allDivs.length) {
			const div = allDivs[currentIndex];

			if (isPrime(div.textContent)) {
				div.classList.add("prime");
			} else {
				div.classList.add("not-prime");
			}
			currentIndex++;
		} else {
			clearInterval(interval);
		}
	}, 100);
}

function isPrime(num) {
	if (num < 2) return false;

	for (let i = 2; i < num; i++) {
		if (num % i === 0) return false;
	}

	return true;
}

generateDivs(100);
