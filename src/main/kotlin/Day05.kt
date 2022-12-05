import java.io.FileNotFoundException

/**
 * --- Day 5: Supply Stacks ---.
 */
class Day05 : Parts {

    override fun part1(input: String) = moveStacks(input, 1)

    override fun part2(input: String) = moveStacks(input, 2)

    private fun moveStacks(input: String, part: Int): String {
        val stacks = mutableMapOf<Char, MutableList<Char>>()

        val inputParts = input.split("\n\n")
        val part1 = inputParts[0].split("\n")
        val part2 = inputParts[1].split("\n").filter { it.isNotEmpty() }
        val indexes = part1.last().mapIndexedNotNull { index, c -> if (c == ' ') null else c to index }
        part1.dropLast(1).reversed().map { row ->
            indexes.forEach {
                val element = row[it.second]
                if (element != ' ') {
                    if (stacks.contains(it.first)) stacks[it.first]!!.add(element) else stacks.put(
                        it.first,
                        mutableListOf(element)
                    )
                }
            }
        }

        val commands = part2.map { it.split("move ", "from ", "to ").takeLast(3) }

        commands.forEach { command ->
            val take = stacks[command[1].trim()[0]]!!.takeLast(command[0].trim().toInt())
            (take.indices).forEach { _ -> stacks[command[1].trim()[0]]!!.removeLast() }
            stacks[command[2].trim()[0]]!!.addAll(if(part == 1) take.reversed() else take)
        }

        return stacks.toSortedMap().map { it.value.last() }.joinToString("")
    }

}


fun main() {
    val day = Day05()
    try {
        val input = readText("Day05")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day04 file needs to be created in the src folder.")
    }
}