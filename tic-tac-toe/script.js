import { Game } from "./game.js";

disableTiles(); // start with disabled game

let game;
let gameAction = document.querySelector(".gameAction");
let gameText = document.createElement("h3");
let startButton = document.createElement("button");
let resetBtn = document.querySelector(".resetBtn")
resetBtn.addEventListener("click", gameReset)

gameAction.appendChild(startButton)
startButton.textContent = "START GAME";
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
        tile.setAttribute("class", "tile active")
        tile.addEventListener("click", clickTileHandler)
    });
}

function clickTileHandler() {
    const row = parseInt(this.dataset.row, 10);
    const col = parseInt(this.dataset.col, 10);

    if (game.isValidCell(row, col)) {
        game.markCell(row, col);

        if (game.isVictory()) {
            gameText.textContent = `${game.getCurrentPlayerName()} wins!`;
            console.log(`${game.getCurrentPlayerName()} wins!`)
            disableTiles()
        } else {
            game.switchTurn();
            updatePlayText();
        }
    } else {
        console.warn("Invalid move");
    }

    if (game.isBoardFull()) {
        gameText.textContent = "It's a tie!";
        disableTiles()
        console.log("tie")
    }
}


function disableTiles() {
    console.log("disabling")
    let tiles = Array.from(document.getElementsByClassName("tile"));

    tiles.forEach(tile => {
        tile.setAttribute("class", "tile disabled")
        tile.removeEventListener("click", clickTileHandler)
    })
}

function gameReset() {
    game.resetGame();
    gameAction.removeChild(gameText);
    gameAction.appendChild(startButton);
    disableTiles()
    document.querySelectorAll('.tile').forEach(tile => {
        tile.textContent = '';
    });
}