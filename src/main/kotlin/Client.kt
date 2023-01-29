import BoardRenderer.renderBoard
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = { document.body?.renderBoard() }
}