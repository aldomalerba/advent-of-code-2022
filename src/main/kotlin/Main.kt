import java.io.FileNotFoundException

fun main() {

    val days = mapOf<() -> Parts, String>(
        ::Day01 to "Day01",
        ::Day02 to "Day02",
        ::Day03 to "Day03",
        ::Day04 to "Day04",
    )

    days.forEach { dayToName ->

        try {
            val day = dayToName.key()
            val input = readText(dayToName.value)
            println(dayToName.value)
            println("Part 1 :" + day.part1(input))
            println("Part 2 :" + day.part2(input))
            println()
        } catch (e: FileNotFoundException) {
            println("$dayToName.value file needs to be created in the src folder.\n")
        }
    }
}