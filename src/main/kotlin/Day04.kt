import java.io.FileNotFoundException
import kotlin.math.max

/**
 * --- Day 4: Camp Cleanup ---.
 */
class Day04 : Parts {
    override fun part1(input: String) = pairs(input).count(SectionAssignmentPair::fullyContained)

    override fun part2(input: String) = pairs(input).count(SectionAssignmentPair::overlapped)

    private fun pairs(input: String) = input.split("\n").filter { it.isNotEmpty() }
        .map {
            val sections = it.split(",", "-").map(String::toInt)

            val firstElfAssignments = sections[0]..sections[1]
            val secondElfAssignments = sections[2]..sections[3]

            SectionAssignmentPair(firstElfAssignments, secondElfAssignments)
        }

}

class SectionAssignmentPair(private val firstSection: IntRange, private val secondSection: IntRange){
    fun fullyContained() = max(firstSection.count(), secondSection.count()) == countAssignments()

    fun overlapped() = (firstSection + secondSection).count() != countAssignments()

    private fun countAssignments() = (firstSection + secondSection).toSet().size

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