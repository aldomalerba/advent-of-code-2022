import java.io.FileNotFoundException

/**
 *
 */
class Day06 : Parts {
    override fun part1(input: String) =
        input.windowed(4).indexOfFirst { it.toList().distinct().count() == 4 } + 4

    override fun part2(input: String) =
        input.windowed(14).indexOfFirst { it.toList().distinct().count() == 14 } + 14
}


fun main() {
    val day = Day06()
    try {
        val input = readText("Day06")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day06 file needs to be created in the src folder.")
    }
}