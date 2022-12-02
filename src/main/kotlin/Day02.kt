import java.io.FileNotFoundException

class Day02: Parts{

    private val wins = mapOf('A' to 'C', 'B' to 'A','C' to 'B')
    private val draws = mapOf('X' to 'A', 'Y' to 'B', 'Z' to 'C')
    private val scores = mapOf('A' to 1, 'B' to 2, 'C' to 3)

    override fun part1(input: String): Int {
        val plays = parsInput(input)

        val totScore = plays.map{
            val myResponse = draws[it.last()]
            val score = if(it.first() == draws[it.last()]) 3 else if(myResponse != wins[it.first()]) 6 else 0

            score + scores[myResponse]!!
        }

        return totScore.sum()
    }
    override fun part2(input: String): Int {
        val plays = parsInput(input)

        val totScore = plays.map{
            val opponent = it.first()

            when(it.last()){
                'X' -> scores[wins[opponent]]!!
                'Y' -> 3 + scores[opponent]!!
                else -> 6 + scores[ wins.filterValues { it == opponent }.keys.first()]!!
            }


        }

        return totScore.sum()
    }

    private fun parsInput(input: String) = input.split("\n").filter { it.isNotEmpty() }
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
