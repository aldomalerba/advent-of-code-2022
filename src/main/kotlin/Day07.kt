import java.io.FileNotFoundException

/**
 * --- Day 6: Tuning Trouble ---
 */
class Day07 : Parts {

    override fun part1(input: String): Int {
        val tree = directoriesSizes(input)

        return tree.filter { it.value < 100000 }.values.sum()
    }

    override fun part2(input: String): Int {
        val tree = directoriesSizes(input)
        val spaceNeeded = 30000000 - (70000000 - tree.get("root")!!)
        return tree.filter { it.value > spaceNeeded }.minOf { it.value }
    }

    private fun directoriesSizes(input: String): Map<String, Int> {
        val tree = mutableMapOf<String, Int>()

        val lines = input.lines().filter { it.isNotEmpty() }
        val path = mutableListOf("root")
        var isDescribe = false

        lines.drop(1).forEach {
            if (it == "$ cd ..") {
                isDescribe = false
                path.removeLast()
            } else if (it == "$ cd /") {
                path.clear()
                path.add("root")
                isDescribe = false
            } else if (it.startsWith("$ cd")) {
                path.add(it)
                isDescribe = false
            }

            if (it == "$ ls") {
                isDescribe = true
            } else if (isDescribe) {
                path.forEachIndexed { index, _ ->
                    val value = tree.getOrPut(path.take(index + 1).joinToString("/")) { 0 }
                    if (!it.startsWith("dir")) {
                        tree[path.take(index + 1).joinToString("/")] = value + it.split(" ").first().toInt()
                    }
                }
            }
        }
        return tree
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