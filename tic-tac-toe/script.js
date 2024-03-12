import {Game} from "./game.js";

let game;
let gameAction = document.querySelector(".gameAction");
let startButton = document.createElement("button");
let gameText = document.createElement("p");

startButton.textContent = "START GAME";
gameAction.appendChild(startButton)

startButton.addEventListener("click", () => {
    gameLoop()
})

function updatePlayText() {
    gameText.textContent = `It's ${game.getCurrentPlayerName()}'s turn!`
}

function gameLoop() {
    game = new Game()

    gameAction.removeChild(startButton);
    gameAction.appendChild(gameText);

    updatePlayText();

    let tiles = Array.from(document.getElementsByClassName("tile"));

    tiles.forEach(tile => {
        tile.addEventListener("click", () => {
            const row = parseInt(tile.dataset.row, 10);
            const col = parseInt(tile.dataset.col, 10);

            if (game.isBoardFull()) {
                gameText.textContent = "It's a tie!";
                console.log("tie")
                // add tie screen
            }

            if (game.isValidCell(row, col)) {
                if (game.isVictory(row, col)) {
                    gameText.textContent = `${game.getCurrentPlayerName()} wins!`;
                    console.log(`${game.getCurrentPlayerName()} wins!`)
                    // add victory screen
                }

                game.markCell(row, col);
                updatePlayText();
            } else {
                console.warn("Invalid move: Cell is already occupied or out of bounds!");
            }
        });
    });
}
