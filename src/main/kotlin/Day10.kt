import java.io.FileNotFoundException

class Day10 : Parts {
    override fun part1(input: String): Any {

        var cycleToSum = 20
        var result = 0

        cycles(input).forEachIndexed { index, it ->
            if (index == cycleToSum) {
                cycleToSum += 40
                result += (index * it)
            }
        }
        return result
    }

    override fun part2(input: String): List<String> {
        return cycles(input).drop(1).windowed(40, 40)
            .map {
                it.mapIndexed { index, i ->
                    if ((i - 1..i + 1).contains(index)) "#" else "."
                }.joinToString("")
            }
    }

    private fun cycles(input: String): Array<Int> {
        var X = 1
        val cycleValue = mutableListOf(0)
        input.lines().filter { it.isNotEmpty() }.forEachIndexed { index, instruction ->
            var name = instruction.split(" ").first()
            var value = instruction.split(" ").last().toIntOrNull()

            if (name == "addx") {
                cycleValue.add(X)
                cycleValue.add(X)
                X += value!!
            } else {
                cycleValue.add(X)
            }

        }

        return cycleValue.toTypedArray()
    }

}

fun main() {
    val day = Day10()
    try {
        val input = readText("Day10")
        println(day.part1(input))
        day.part2(input).forEach { println(it) }
    } catch (e: FileNotFoundException) {
        println("Day10 file needs to be created in the src folder.")
    }
}
