import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node

fun main() {
    window.onload = { document.body?.board() }
}

fun Node.board() {
    append {
        div("board grid") {
            (1..15 * 15)
                .toList()
                .forEach { _ ->
                    div("square") {
                        +"test"
                    }
                }
        }
    }
}

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS"

        }
    }
}