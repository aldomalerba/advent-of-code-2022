import java.io.FileNotFoundException

class Day02: Parts{
    val wins = listOf("A Y", "B Z", "C X")
    val draws = listOf("A X", "B Y", "C Z")
    val loses = mapOf('A' to 'Z', 'B' to 'X', 'C' to 'Y')

    val scores = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)
    val scoresOpponent = mapOf('A' to 1, 'B' to 2, 'C' to 3)
    override fun part1(input: String): Int {
        val plays = input.split("\n").filter { it.isNotEmpty() }

        val totScore = plays.map{
            val opponent = it.first()
            val myResponse = it.last()
            //X need to loose
            //y draw
            //Z win

            val score = if(wins.contains(it)) 6 else if(draws.contains(it)) 3 else 0
            val point = scores[myResponse]!!
            score + point
        }

        return totScore.sum()
    }
    override fun part2(input: String): Int {
        val plays = input.split("\n").filter { it.isNotEmpty() }

        val totScore = plays.map{
            val opponent = it.first()
            val myResponse = it.last()
            val score = when(myResponse){
                'X' -> 0
                'Y' -> 3
                else -> 6
            }

            val point = when(myResponse){
                'Y' -> scoresOpponent[opponent]!!
                'X' -> scores[loses[opponent]]!!
                else -> scores[wins.single { it.startsWith(opponent) }.last()]!!
            }

            score + point
        }

        return totScore.sum()
    }
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
