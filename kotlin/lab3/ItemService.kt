package lab3

class ItemService(private val itemRepository: ItemRepository) {

    fun selectRandomItems(nrOfItems: Int): List<Item> {
        if(nrOfItems <= 0 || nrOfItems > itemRepository.size()) {
            return emptyList()
        }
        val items = mutableListOf<Item>()
        while (items.size < nrOfItems) {
            val item = itemRepository.randomItem()
            if(!items.contains(item)) {
                items.add(item)
            }
        }
        return items
    }
}