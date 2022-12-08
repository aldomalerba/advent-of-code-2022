import java.io.FileNotFoundException

/**
 * --- Day 6: Tuning Trouble ---
 */
class Day07 : Parts {

    override fun part1(input: String): Int {
        return directoriesSizes(input).filter { it.value < 100000 }.values.sum()
    }

    override fun part2(input: String): Int {
        val tree = directoriesSizes(input)
        val spaceNeeded = 30000000 - (70000000 - tree["root"]!!)
        return tree.filter { it.value > spaceNeeded }.minOf { it.value }
    }

    private fun directoriesSizes(input: String): Map<String, Int> {
        val dirSizes = mutableMapOf<String, Int>()

        val lines = input.lines().filterNot { it.isEmpty() || it == "$ ls" }.drop(1)
        val path = mutableListOf("root")

        lines.forEach {
            if (it.startsWith("$")) {
                when (it) {
                    "$ cd .." -> path.removeLast()
                    else -> path.add(it)
                }
            } else {
                (path.indices).forEach {index ->
                    val pathName = path.take(index + 1).joinToString("/")

                    val name = it.split(" ").first()
                    if (name != "dir") {
                        dirSizes[pathName] = dirSizes.getOrPut(pathName) { 0 } + name.toInt()
                    }
                }
            }

        }
        return dirSizes
    }
}


fun main() {
    val day = Day07()
    try {
        val input = readText("Day07")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day06 file needs to be created in the src folder.")
    }
}