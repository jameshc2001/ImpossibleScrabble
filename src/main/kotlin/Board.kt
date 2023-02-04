import Game.PlayedTile

class Board {

    private val raw: Array<CharArray> = (0 until 14).map { CharArray(15) }.toTypedArray()

    private fun setCell(playedTile: PlayedTile) {
        raw[playedTile.x][playedTile.y] = playedTile.letter
    }

    fun setCells(playedTiles: List<PlayedTile>) = playedTiles.forEach { setCell(it) }
}