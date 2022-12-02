import java.io.FileNotFoundException

class Day02: Parts{

    private val wins = mapOf('A' to 'C', 'B' to 'A','C' to 'B')
    private val draws = mapOf('X' to 'A', 'Y' to 'B', 'Z' to 'C')
    private val scores = mapOf('A' to 1, 'B' to 2, 'C' to 3)

    override fun part1(input: String) = rounds(input).sumOf { roundScorePart1(it) }
    override fun part2(input: String) = rounds(input).sumOf { roundScoresPart2(it) }

    private fun roundScorePart1(it: Pair<Char, Char>): Int {
        val myResponse = draws[it.second]
        val opponent = it.first

        val score = when {
            opponent == myResponse -> 3
            wins[opponent] != myResponse -> 6
            else -> 0
        }

        return score + scores[myResponse]!!
    }

    private fun roundScoresPart2(match: Pair<Char, Char>): Int {
        val opponent = match.first

        return when (match.second) {
            'X' -> scores[wins[opponent]]!!
            'Y' -> 3 + scores[opponent]!!
            else -> 6 + scores[wins.filterValues { it == opponent }.keys.first()]!!
        }
    }

    private fun rounds(input: String) = input.split("\n").filter { it.isNotEmpty() }.map { it.first() to it.last() }
}

fun main() {
    val day = Day02()
    try {
        val input = readText("Day02")
        println(day.part1(input))
        println(day.part2(input))
    }catch (e: FileNotFoundException){
        println("Day02 file needs to be created in the src folder.")
    }
}
