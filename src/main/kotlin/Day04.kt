import java.io.FileNotFoundException
import kotlin.math.max

class Day04: Parts {

    override fun part1(input: String): Int {
        return input.split("\n").filter { it.isNotEmpty() }.map {pair ->
            val pair = pair.split(",")
            val firstElfSections = pair.first().split("-")
            val secondElfSections = pair.last().split("-")

            val firstElfRange = firstElfSections.first().toInt()..firstElfSections.last().toInt()
            val secondElfRange = secondElfSections.first().toInt()..secondElfSections.last().toInt()

            val overlapSections = (firstElfRange.toSet() + secondElfRange.toSet()).size

            max(firstElfRange.count(), secondElfRange.count()) == overlapSections
        }.count { it }
    }

    override fun part2(input: String): Int {
        return input.split("\n").filter { it.isNotEmpty() }.map {pair ->
            val pair = pair.split(",")
            val firstElfSections = pair.first().split("-")
            val secondElfSections = pair.last().split("-")

            val firstElfRange = firstElfSections.first().toInt()..firstElfSections.last().toInt()
            val secondElfRange = secondElfSections.first().toInt()..secondElfSections.last().toInt()

            val overlapSections = (firstElfRange.toSet() + secondElfRange.toSet()).size

           firstElfRange.count() + secondElfRange.count() != overlapSections
        }.count { it }
    }

}

fun main() {
    val day = Day04()
    try {
        val input = readText("Day04")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day04 file needs to be created in the src folder.")
    }
}