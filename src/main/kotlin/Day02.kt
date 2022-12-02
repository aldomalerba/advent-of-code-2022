import java.io.FileNotFoundException

class Day02: Parts{

    private val wins = mapOf('A' to 'C', 'B' to 'A','C' to 'B')
    private val draws = mapOf('X' to 'A', 'Y' to 'B', 'Z' to 'C')
    private val scores = mapOf('A' to 1, 'B' to 2, 'C' to 3)

    override fun part1(input: String): Int {
        val plays = parsInput(input)

        val totScore = plays.sumOf {
            val myResponse = draws[it.second]
            val opponent = it.first

            val score = when {
                opponent == myResponse -> 3
                wins[opponent] != myResponse -> 6
                else -> 0
            }

            score + scores[myResponse]!!
        }

        return totScore
    }
    override fun part2(input: String): Int {
        val plays = parsInput(input)

        val totScore = plays.sumOf {
            val opponent = it.first

            when (it.second) {
                'X' -> scores[wins[opponent]]!!
                'Y' -> 3 + scores[opponent]!!
                else -> 6 + scores[wins.filterValues { it == opponent }.keys.first()]!!
            }

        }

        return totScore
    }

    private fun parsInput(input: String) = input.split("\n").filter { it.isNotEmpty() }.map { it.first() to it.last() }
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
