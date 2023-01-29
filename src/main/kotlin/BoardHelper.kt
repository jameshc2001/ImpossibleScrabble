object BoardHelper {

    enum class TileType {
        TripleWord,
        DoubleWord,
        TripleLetter,
        DoubleLetter,
        Normal
    }

    private val tripleWordScores = setOf(
        Pair(0, 0),
        Pair(14, 14),
        Pair(14, 0),
        Pair(0, 14),
        Pair(7, 0),
        Pair(0, 7),
        Pair(7, 14),
        Pair(14, 7),
    )

    private val doubleWordScores = (1 until 14)
        .toList()
        .filterNot { it in listOf(5, 6, 7, 8, 9) }
        .flatMap { x -> listOf(Pair(x, x), Pair(14-x, x)) }
        .toSet()

    fun getTileType(x: Int, y: Int) = when(Pair(x, y)) {
        in tripleWordScores -> TileType.TripleWord
        in doubleWordScores -> TileType.DoubleWord
        else -> TileType.Normal
    }
}