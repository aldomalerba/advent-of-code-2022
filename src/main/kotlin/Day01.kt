class Day01 {
    fun part1(input: List<String>): Int {

        return inventories(input).maxOf { it.sum() }
    }
    fun part2(input: List<String>): Int {
        return inventories(input).sortedByDescending { it.sum() }.take(3).flatten().sum()
    }
    private fun inventories(input: List<String>): List<List<Int>> {
        var inventoryIndex = 0
        val inventories = mutableMapOf<Int, List<Int>>()
        val inventory = mutableListOf<Int>()
        for (calories in input) {
            if (calories.isNotEmpty()) {
                inventory.add(calories.toInt())
                inventories[inventoryIndex] = inventory.toList()
            } else {
                inventory.clear()
                inventoryIndex++
            }
        }
        return inventories.map { it.value }
    }
}

fun main() {
    val day = Day01()
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(day.part1(testInput) == 24000)
    check(day.part2(testInput) == 45000)

    val input = readInput("Day01")
    println(day.part1(input))
    println(day.part2(input))
}
