import BoardHelper.TileType.*
import BoardHelper.getTileType
import kotlin.test.Test
import kotlin.test.assertEquals

class BoardHelperTest {

    @Test
    fun correctlyReportsTripleLetterTiles() {
        assertEquals(TripleLetter, getTileType(1, 5))
        assertEquals(TripleLetter, getTileType(9, 13))
        assertEquals(TripleLetter, getTileType(5, 5))
    }

    @Test
    fun correctlyReportsDoubleLetterTiles() {
        assertEquals(DoubleLetter, getTileType(3, 0))
        assertEquals(DoubleLetter, getTileType(6, 6))
        assertEquals(DoubleLetter, getTileType(7, 11))
    }

    @Test
    fun correctlyReportsTripleWordTiles() {
        assertEquals(TripleWord, getTileType(0, 0))
        assertEquals(TripleWord, getTileType(14, 14))
        assertEquals(TripleWord, getTileType(7, 0))
    }

    @Test
    fun correctlyReportsDoubleWordTiles() {
        assertEquals(DoubleWord, getTileType(1, 1))
        assertEquals(DoubleWord, getTileType(12, 2))
        assertEquals(DoubleWord, getTileType(11, 11))
    }

}