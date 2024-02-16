function updateBackground() {
	// Generate a cachebuster to ensure the image is not cached
	const cachebuster = new Date().getTime();

	// Set the background image with cachebuster
	document.body.style.backgroundImage = `url(https://loremflickr.com/g/1280/800/hungary/?${cachebuster})`;
}

function startBackgroundTimer() {
	setInterval(updateBackground, 5000);
}

updateBackground();
startBackgroundTimer();
