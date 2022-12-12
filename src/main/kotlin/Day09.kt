import java.io.FileNotFoundException

class Day09 : Parts {
    override fun part1(input: String): Int {
        val ropeSize = 2
        return moveRopeWith(ropeSize, input)
    }

    override fun part2(input: String): Any {
        val ropeSize = 10
        return moveRopeWith(ropeSize, input)
    }


    private fun moveRopeWith(ropeSize: Int, input: String): Int {
        val tailPositions = mutableSetOf(Pair(0, 0))
        val rope = (1..ropeSize).map { 0 to 0 }.toMutableList()
        val ropeMoves = mutableListOf<String>()
        input.lines().filter { it.isNotEmpty() }.forEach {
            val (direction, steps) = it.split(" ")
            ropeMoves.addAll(List(steps.toInt()) {
                direction
            })
        }

        var prevPositions = 0 to 0
        ropeMoves.forEachIndexed { ropeMovesindex, direction ->

            var (headX, headY) = rope.last()
            prevPositions = rope.last()

            when (direction) {
                "R" -> headX++
                "L" -> headX--
                "D" -> headY--
                else -> headY++
            }

            rope[rope.size - 1] = headX to headY

            (rope.dropLast(1).size - 1 downTo 0).mapIndexed { index, i ->
                var (tailX, tailY) = rope[i]
                var (headX, headY) = rope[i+1]

                val isAdjacent = isAdjacent(tailX, tailY, headX, headY)
                if (!isAdjacent) {
                    val tmp = rope[i]
                    var (x,y) = rope[i]
                    rope[i] = when (direction) {
                        "R" -> x+1 to prevPositions.second
                        "L" -> x-1 to prevPositions.second
                        "D" -> prevPositions.first to y-1
                        else -> prevPositions.first to y+1
                    }
                    prevPositions = tmp
                }

            }

            tailPositions.add(rope.first())
        }


        return tailPositions.size
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
