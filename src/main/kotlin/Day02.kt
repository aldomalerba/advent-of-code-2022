class Day02 : Parts {
    override fun part1(input: List<String>) = input.size

    override fun part2(input: List<String>) = input.size
}

fun main() {
    val day = Day02()
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(day.part1(testInput) == 1)
    check(day.part2(testInput) == 1)

    val input = readInput("Day01")
    println(day.part1(input))
    println(day.part2(input))
}
