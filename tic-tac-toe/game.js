import { Player } from "./player.js";

export class Game {
    _board;
    _players;
    _currentPlayer;

    constructor() {
        this._board = new Array(3).fill(null).map(() => new Array(3).fill(0));

        this._players = [
            new Player("player one", "X"),
            new Player("player two", "O"),
        ];

        this._currentPlayer = 0;
    }

    switchTurn() {
        console.log("switching turns")
        this._currentPlayer = (this._currentPlayer + 1) % this._players.length;
    }

    markCell(row, col) {
        console.log("marking")
        if (this.isValidCell(row, col)) {
            const symbol = this._players[this._currentPlayer].getSymbol();
            this._board[row][col] = symbol;

            let textSymbol = document.createElement("p")
            textSymbol.textContent = symbol;
            document.querySelector(`[data-row="${row}"][data-col="${col}"]`).appendChild(textSymbol);
        } else {
            throw new Error("Invalid cell or cell already occupied!");
        }
    }

    isValidCell(row, col) {
        console.log("validating")
        return this._board[row][col] === 0;
    }

    isVictory() {
        const symbols = ['X', 'O'];

        // Check rows and columns
        for (let i = 0; i < 3; i++) {
            if ((this._board[i][0] === this._board[i][1] && this._board[i][0] === this._board[i][2]) && symbols.includes(this._board[i][0])) {
                console.log("victory")
                return true;
            }
            if ((this._board[0][i] === this._board[1][i] && this._board[0][i] === this._board[2][i]) && symbols.includes(this._board[0][i])) {
                console.log("victory")
                return true;
            }
        }

        // Check diagonals
        if ((this._board[0][0] === this._board[1][1] && this._board[0][0] === this._board[2][2]) && symbols.includes(this._board[0][0])) {
            console.log("victory")
            return true;
        }
        if ((this._board[0][2] === this._board[1][1] && this._board[0][2] === this._board[2][0]) && symbols.includes(this._board[0][2])) {
            console.log("victory")
            return true;
        }

        console.log("checked for victory")
        return false;
    }

    isBoardFull() {
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (this._board[i][j] === 0) {
                    return false;
                }
            }
        }
        return true;
    }

    resetGame() {
        console.log("new board")
        this._board = new Array(3).fill(null).map(() => new Array(3).fill(null));
        console.log(this._board)
        this._currentPlayer = 0;
    }

    getCurrentPlayerName() {
        return this._players[this._currentPlayer].getName();
    }
}