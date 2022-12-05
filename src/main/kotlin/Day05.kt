import java.io.FileNotFoundException

/**
 * --- Day 5: Supply Stacks ---.
 */
class Day05 : Parts {

    override fun part1(input: String) = moveStacks(input, 1)

    override fun part2(input: String) = moveStacks(input, 2)

    private fun moveStacks(input: String, part: Int): String {

        val inputParts = input.split("\n\n").map { it.split("\n").filter { it.isNotEmpty() } }
        val firstInputPart = inputParts.first()
        val secondInputPart = inputParts.last()

        val stacks = stacks(firstInputPart)
        val commands = commands(secondInputPart)

        commands.forEach { command ->
            val cratesToMove = command[0].toInt()
            val from = command[1][0]
            val to = command[2][0]

            val take = stacks[from]!!.takeLast(cratesToMove)
            (1..cratesToMove).forEach { _ -> stacks[from]!!.removeLast() }
            stacks[to]!!.addAll(if(part == 1) take.reversed() else take)
        }

        return stacks.toSortedMap().map { it.value.last() }.joinToString("")
    }

    private fun commands(inputParts: List<String>) =
        inputParts.map { it.split("move ", "from ", "to ").takeLast(3).map { it.trim() } }

    private fun stacks(firstInputPart: List<String>): MutableMap<Char, MutableList<Char>> {
        val indexes = firstInputPart.last().mapIndexedNotNull { index, c -> if (c != ' ') c to index else null }.toMap()

        return firstInputPart.dropLast(1).reversed().fold(mutableMapOf()) { acc, row ->
            indexes.forEach {
                val element = row[it.value]
                if (element != ' ') {
                    if (acc.contains(it.key)) {
                        acc[it.key]!!.add(element)
                    } else {
                        acc[it.key] = mutableListOf(element)
                    }
                }
            }
            acc
        }
    }

}


fun main() {
    val day = Day05()
    try {
        val input = readText("Day05")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day05 file needs to be created in the src folder.")
    }
}