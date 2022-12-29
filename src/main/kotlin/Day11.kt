import java.io.FileNotFoundException

class Day11: Parts {
    override fun part1(input: String): Any {
        return result(input, 1, 20)
    }

    override fun part2(input: String): Any {
        return result(input,2, 10000)
    }

    private fun result(input: String, part: Int, rounds: Int): Long {
        val monkeys = input.split("\n\n").map { it.split("\n") }
        val monkeyItems = mutableListOf<MutableList<Long>>()
        val monkeyInspections = mutableMapOf<Int, Long>()
        val monkeyOperations = mutableListOf<(Long) -> Pair<Int, Long>>()
        val monkeysTests = monkeys.map { it[3].replace(Regex(".*\\s"), "").toLong() }
        val minMultiple = monkeysTests.reduce { acc, i -> acc * i }

        monkeys.forEachIndexed { index, it ->
            monkeyItems.add(it[1].drop(17).split(",").map { it.trim().toLong() }.toMutableList())

            monkeyOperations.add { old ->
                val operation = it[2].drop(23).split(" ")
                val test = monkeysTests[index]
                val success = it[4].replace(Regex(".*\\s"), "").toInt()
                val fail = it[5].replace(Regex(".*\\s"), "").toInt()
                var new = when (operation.first()) {
                    "+" -> old + operation.last().toLong()
                    else -> (old * if (operation.last() == "old") old else operation.last().toLong())
                }

                new = if(part==1) new/3 else new%minMultiple

                (if (new % test == 0L) success else fail) to new
            }
        }

        (1..rounds).forEach { _ ->
            monkeyItems.forEachIndexed { monkey, items ->
                monkeyInspections[monkey] = monkeyInspections.getOrPut(monkey) { 0L } + items.size
                val items = items.map {
                    monkeyOperations[monkey](it)
                }
                monkeyItems[monkey].clear()
                items.forEach { monkeyItems[it.first].add(it.second) }
            }
        }

        return monkeyInspections.values.sortedDescending().take(2).reduce { acc, i -> acc * i }
    }

}

fun main() {
    val day = Day11()
    try {
        val input = readText("Day11")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day11 file needs to be created in the src folder.")
    }
}

