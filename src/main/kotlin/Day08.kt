import java.io.FileNotFoundException

class Day08 : Parts {
    override fun part1(input: String): Int {
        val lines = input.lines().filter { it.isNotEmpty() }
        return lines.mapIndexed { rowIndex, row ->
            if (rowIndex == 0 || rowIndex == lines.size - 1) row.length
            else row.mapIndexed { treeIndex, tree ->

                val visible = if (treeIndex == 0 || treeIndex == row.length - 1) true
                else tree > (0..rowIndex -1).maxOf { lines[it][treeIndex] } ||
                        tree > (0..treeIndex -1).maxOf { lines[rowIndex][it] } ||
                        tree > (rowIndex+1..lines.size-1).maxOf { lines[it][treeIndex] } ||
                        tree > (treeIndex+1..row.length-1).maxOf { lines[rowIndex][it] }
                println("$tree at $rowIndex , $treeIndex is visible $visible")
                visible
            }.count{ it }
        }.sum()
    }

    override fun part2(input: String): Int {
        val lines = input.lines().filter { it.isNotEmpty() }
        return lines.mapIndexed { rowIndex, row ->
            if (rowIndex == 0 || rowIndex == lines.size - 1) 0
            else row.mapIndexed { treeIndex, tree ->
                val visible = if (treeIndex == 0 || treeIndex == row.length - 1) 0

                else (((rowIndex - 1 downTo 0).indexOfFirst { lines[it][treeIndex] >= tree }.takeIf { it != -1 } ?: (rowIndex - 1)) + 1) *
                        (((treeIndex -1 downTo 0).indexOfFirst { lines[rowIndex][it] >= tree }.takeIf { it != -1 } ?: (treeIndex - 1))+ 1) *
                        (((rowIndex+1..lines.size-1).indexOfFirst { lines[it][treeIndex] >= tree}.takeIf { it != -1 } ?: ((rowIndex+1..lines.size-1).count() - 1)) +1) *
                        (((treeIndex+1..row.length-1).indexOfFirst { lines[rowIndex][it] >= tree }.takeIf { it != -1 } ?: ((treeIndex+1..row.length-1).count() -1)) +1)
                println("$tree at $rowIndex , $treeIndex is visible $visible")
                visible
            }.maxOf { it }
        }.maxOf { it }
    }

}

fun main() {
    val day = Day08()
    try {
        val input = readText("Day08")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day06 file needs to be created in the src folder.")
    }
}
