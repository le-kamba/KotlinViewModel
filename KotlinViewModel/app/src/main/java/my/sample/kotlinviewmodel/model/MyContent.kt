package my.sample.kotlinviewmodel.model

object MyContent {
    val ITEMS: MutableList<Item> = ArrayList()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: Item) {
        ITEMS.add(item)
    }

    private fun createDummyItem(position: Int): Item {
        return Item(position, 10 + position, "タイトル$position", "サマリー$position")
    }

    data class Item(val id: Int, val type: Int, val title: String, val summary: String?)
}
