import java.io.FileNotFoundException

/**
 * --- Day 6: Tuning Trouble ---
 */
class Day06 : Parts {

    override fun part1(input: String) = input.indexFirstMarkerOfSize(4)

    override fun part2(input: String) = input.indexFirstMarkerOfSize(14)

    private fun String.indexFirstMarkerOfSize(size: Int) =
        this.windowed(size).indexOfFirst { it.toSet().size == size } + size
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