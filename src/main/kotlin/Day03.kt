import java.io.FileNotFoundException
import java.util.*

class Day03: Parts{

    private val alphabet = "abcdefghijklmnopqrstuvwxyz";

    override fun part1(input: String): Int {

        val items = rucksacks(input).mapNotNull {
            val count = it.count()
            val compartment1 = it.substring(0, (count / 2))
            val compartment2 = it.substring((count / 2), count)

            listOf(compartment1, compartment2).commonItem()
        }

        return items.sumOf { priority(it) }
    }

    override fun part2(input: String): Int {
        val elvesGroups = rucksacks(input).windowed(3, 3)

        val items = elvesGroups.mapNotNull { rucksacks -> rucksacks.commonItem() }

        return items.sumOf { priority(it) }

    }

    private fun rucksacks(input: String) = input.split("\n")
    private fun List<String>.commonItem() = this.first().find { char -> this.all { it.contains(char) } }
    private fun priority(it: Char) =
        if (alphabet.contains(it)) alphabet.indexOf(it) + 1 else alphabet.uppercase().indexOf(it) + 27

}

fun main() {
    val day = Day03()
    try {
        val input = readText("Day03")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day03 file needs to be created in the src folder.")
    }
}
