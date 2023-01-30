object BoardHelper {

    enum class TileType {
        Centre,
        TripleWord,
        DoubleWord,
        TripleLetter,
        DoubleLetter,
        Normal
    }

    private val tripleWordScores = setOf(Pair(0, 0), Pair(7, 0), Pair(0, 7)).forAllQuadrants()

    private val tripleLetterScore = setOf(Pair(5, 1), Pair(1, 5), Pair(5, 5)).forAllQuadrants()

    private val doubleWordScores = setOf(Pair(1, 1), Pair(2, 2), Pair(3, 3), Pair(4, 4)).forAllQuadrants()

    private val doubleLetterScore = setOf(Pair(0, 3), Pair(6, 2), Pair(7, 3), Pair(6, 6))
        .flatMap { setOf(it, Pair(it.second, it.first)) }
        .toSet()
        .forAllQuadrants()

    private fun Set<Pair<Int, Int>>.forAllQuadrants() =
        flatMap{ (x, y) -> setOf(Pair(x, y), Pair(14 - x, y), Pair(x, 14 - y), Pair(14 - x, 14 - y)) }.toSet()

    fun getTileType(x: Int, y: Int) = when (Pair(x, y)) {
        in tripleWordScores -> TileType.TripleWord
        in doubleWordScores -> TileType.DoubleWord
        in tripleLetterScore -> TileType.TripleLetter
        in doubleLetterScore -> TileType.DoubleLetter
        Pair(7, 7) -> TileType.Centre
        else -> TileType.Normal
    }
}