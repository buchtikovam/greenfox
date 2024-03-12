import {Player} from "./player.js";

export class Game {
    _board;
    _players;
    _currentPlayer;

    constructor() {
        this._board = new Array(3).fill(null).map(() => new Array(3).fill(0));

        this._players = [
            new Player("player one", 1),
            new Player("player two", 2),
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
            this._board[row][col] = this._players[this._currentPlayer].symbol;
            console.log(this._players[this._currentPlayer].symbol)
            this.switchTurn();
        } else {
            throw new Error("Invalid cell or cell already occupied!");
        }
        console.log(this._board)
    }

    isValidCell(row, col) {
        console.log("validating")
        return this._board[row][col] === 0;
    }

    isVictory(row, col) {
        const winningLines = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ];

        for (let i = 0; i < winningLines.length; i++) {
            const [a, b, c] = winningLines[i];
            const playerSymbol = this._board[row][col];

            if (playerSymbol !== 0 && playerSymbol === this._board[a][c] && playerSymbol === this._board[b][c]) {
                console.log("victory: true");
                return true;
            }
        }

        console.log("victory: false");
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
        this._board = new Array(3).fill(null).map(() => new Array(3).fill(null));
        this._currentPlayer = 0;
    }

    getCurrentPlayerName() {
        return this._players[this._currentPlayer].getName();
    }
}