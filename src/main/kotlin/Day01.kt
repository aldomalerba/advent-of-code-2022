import java.io.FileNotFoundException

typealias Inventory = List<Int>
class Day01: Parts {
    override fun part1(input: String) =
        inventories(input).maxOf { it.sum() }

    override fun part2(input: String) =
        inventories(input).sortedByDescending { it.sum() }.take(3).flatten().sum()

    private fun inventories(input: String): List<Inventory> {
        return input.split("\n\n").map { it.trim().split("\n").map { calories -> calories.trim().toInt()  }}
    }

}

fun main() {
    val day = Day01()
    try {
        val input = readText("Day01")
        println(day.part1(input))
        println(day.part2(input))
    }catch (e: FileNotFoundException){
        println("Day01 file needs to be created in the src folder.")
    }
}
