package lab2

enum class DictionaryType {
    ARRAY_LIST,
    TREE_SET,
    HASH_SET
}

class DictionaryProvider {

    companion object {
        public fun createDictionary(type: DictionaryType): IDictionary {
            return when (type) {
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.TREE_SET ->  TreeSetDictionary
                DictionaryType.HASH_SET ->  HashSetDictionary
            }
        }
    }
}