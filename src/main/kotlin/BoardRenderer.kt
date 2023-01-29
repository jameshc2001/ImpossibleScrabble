import BoardHelper.TileType.*
import BoardHelper.getTileType
import kotlinx.html.DIV
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.p
import org.w3c.dom.Node

object BoardRenderer {

    private const val size = 15

    fun Node.renderBoard() = append {
        div("grid board") {
            (0 until size).toList().forEach { x ->
                (0 until size).toList().forEach { y ->
                    renderCell(x, y)
                }
            }
        }
    }

    private fun DIV.renderCell(x: Int, y: Int) {
        val tileType = getTileType(x, y)
        val cssClass = when (tileType) {
            TripleWord -> "tripleWord"
            DoubleWord -> "doubleWord"
            TripleLetter -> "tripleLetter"
            DoubleLetter -> "doubleLetter"
            Normal -> ""
        }
        val tileText = when (tileType) {
            TripleWord -> "TW"
            DoubleWord -> "DW"
            TripleLetter -> "TL"
            DoubleLetter -> "DL"
            Normal -> ""
        }
        div("square $cssClass") {
            id = "tile$x-$y"
            p("tileText") { +tileText }
        }
    }
}