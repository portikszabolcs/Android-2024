import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

fun main() {
    print(groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat").toTypedArray()))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result: MutableList<MutableList<String>> = arrayListOf()
    strs.forEach {
        var isAdded = false
        result.forEach { resIt ->
            val charArray1 = resIt[0].lowercase().toCharArray()
            val charArray2 = it.lowercase().toCharArray()
            charArray1.sort()
            charArray2.sort()
            if(String(charArray1) == String(charArray2)) {
                resIt.add(it.lowercase())
                isAdded = true
            }
        }
        if(!isAdded) result.add(mutableListOf(it.lowercase()))
    }
    return result
}

class AnagramsGrouperTest {
    @Test
    fun threeGroupsAllLowerCase() {
        val anagrams = groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat").toTypedArray())
        assertEquals(3, anagrams.size)
        assertTrue(anagrams.contains(listOf("eat", "tea", "ate")))
        assertTrue(anagrams.contains(listOf("tan", "nat")))
        assertTrue(anagrams.contains(listOf("bat")))
    }

    @Test
    fun threeGroupsSomeUpperCase() {
        val anagrams = groupAnagrams(listOf("eat", "tEa", "Tan", "atE", "NAT", "bat").toTypedArray())
        assertEquals(3, anagrams.size)
        assertTrue(anagrams.contains(listOf("eat", "tea", "ate")))
        assertTrue(anagrams.contains(listOf("tan", "nat")))
        assertTrue(anagrams.contains(listOf("bat")))
    }

    @Test
    fun validOneGroup() {
        val anagrams = groupAnagrams(listOf("eat").toTypedArray())
        assertEquals(1, anagrams.size)
        assertTrue(anagrams.contains(listOf("eat")))
    }

    @Test
    fun noGroup() {
        val anagrams = groupAnagrams(emptyList<String>().toTypedArray())
        assertEquals(0, anagrams.size)
    }
}
