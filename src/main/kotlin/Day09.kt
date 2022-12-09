import java.io.FileNotFoundException

class Day09: Parts {
    override fun part1(input: String): Int {
        var (tailX, tailY) = 0 to 0
        var (headX, headY) = 0 to 0
        val tailPositions = mutableSetOf(Pair(0,0))

        val moves = input.lines().filter { it.isNotEmpty() }
        moves.forEach {
            val (direction, steps) = it.split(" ")

            (1..steps.toInt()).forEach {
                when(direction){
                    "R" -> headX++
                    "L" -> headX--
                    "D" -> headY--
                    else -> headY++
                }

                val isAdjacent = isAdjacent(tailX, tailY, headX, headY)

                if(!isAdjacent){
                    when(direction){
                        "R" -> {
                            tailY = headY
                            tailX = headX-1
                        }
                        "L" -> {
                            tailY = headY
                            tailX = headX+1
                        }
                        "D" -> {
                            tailX = headX
                            tailY = headY+1
                        }
                        else -> {
                            tailX = headX
                            tailY = headY-1
                        }
                    }

                    tailPositions.add(tailX to tailY)
                }
            }

        }
        return  tailPositions.size
    }

    private fun isAdjacent(tailX: Int, tailY: Int, headX: Int, headY: Int) =
        tailX to tailY == Pair(headX - 1, headY) ||
                tailX to tailY == Pair(headX - 1, headY - 1) ||
                tailX to tailY == Pair(headX - 1, headY + 1) ||
                tailX to tailY == Pair(headX + 1, headY + 1) ||
                tailX to tailY == Pair(headX + 1, headY) ||
                tailX to tailY == Pair(headX + 1, headY - 1) ||
                tailX to tailY == Pair(headX, headY - 1) ||
                tailX to tailY == Pair(headX, headY + 1) ||
                tailX to tailY == Pair(headX, headY)

    override fun part2(input: String): Any {
        TODO("Not yet implemented")
    }

}

fun main() {
    val day = Day09()
    try {
        val input = readText("Day09")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day09 file needs to be created in the src folder.")
    }
}
