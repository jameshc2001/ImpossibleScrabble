import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class DictionaryTest {

    @Test
    fun containsRealWords() = runTest {
        assertTrue(Dictionary.inDictionary("hello"))
        assertTrue(Dictionary.inDictionary("character"))
        assertTrue(Dictionary.inDictionary("zoo"))
    }

    @Test
    fun doesNotContainFakeWords() = runTest {
        assertFalse(Dictionary.inDictionary("scroipeadoi"))
        assertFalse(Dictionary.inDictionary("unfolypywhy"))
        assertFalse(Dictionary.inDictionary("xasyzte"))
    }

    @Test
    fun doesNotConsiderEmptyStringToBeWord() = runTest {
        assertFalse(Dictionary.inDictionary(""))
    }

    @Test
    fun doesNotConsiderSpaceToBeWord() = runTest {
        assertFalse(Dictionary.inDictionary(" "))
    }
}