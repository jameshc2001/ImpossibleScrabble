import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
object Dictionary {

    private val dictionary = GlobalScope.async {
        val url = "https://raw.githubusercontent.com/jameshc2001/ImpossibleScrabble/master/src/main/resources/words_alpha.txt"
        val client = HttpClient(Js) { install(HttpTimeout) }
        val response = async { client.get(url) { timeout { requestTimeoutMillis = 10000 } } }.await()
        response.body<String>().split("\n").toSet() - setOf(" ", "")
    }

    suspend fun inDictionary(word: String) = dictionary.await().contains(word)
}