import java.io.FileNotFoundException
import java.util.*

class Day03: Parts{

    private val alphabet = "abcdefghijklmnopqrstuvwxyz";

    override fun part1(input: String): Int {
        val rucksacks = input.split("\n")
        val items = rucksacks.mapNotNull {
            it.subSequence(0, (it.count()/2)).find {
                    char -> it.subSequence((it.count()/2), it.count()).contains(char)
            } }

        return items.sumOf { priority(it) }
    }
    override fun part2(input: String): Int {
        val rucksacks = input.split("\n").windowed(3,3)

        val items = rucksacks.mapNotNull {
            it[0].find { char -> it[1].contains(char) && it[2].contains(char) }
        }

        val scores = items.map { priority(it) }

        return scores.sum()
    }

    private fun priority(it: Char) = if (alphabet.contains(it)) alphabet.indexOf(it) + 1 else alphabet.uppercase().indexOf(it) + 27

}

fun main() {
    val day = Day03()
    try {
        val input = readText("Day03")
        println(day.part1(input))
        println(day.part2(input))
    }catch (e: FileNotFoundException){
        println("Day03 file needs to be created in the src folder.")
    }
}
