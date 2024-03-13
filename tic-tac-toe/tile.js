class Tile {
    constructor(index) {
        this.index = index;
        this.value = null;
    }

    mark(player) {
        if (this.value === null) {
            this.value = player.symbol;
        }
    }

}