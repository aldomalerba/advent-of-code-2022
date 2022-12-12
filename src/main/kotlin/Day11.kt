import java.io.FileNotFoundException
import java.lang.Exception

class Day11: Parts {
    override fun part1(input: String): Any {
        val monkeyItems = mutableListOf<MutableList<Int>>()
        val monkeyInspections = mutableMapOf<Int,Int>()
        val monkeyOperations = mutableListOf<(Int) -> Pair<Int, Int>>()
        val monkeys = input.split("\n\n").map { it.split("\n") }

        monkeys.forEach {
            monkeyItems.add(it[1].drop(17).split(",").map { it.trim().toInt() }.toMutableList())
            val operation = it[2].drop(23).split(" ")
            val test = it[3].drop(21).toInt()
            val success = it[4].replace(Regex(".*\\s"), "").toInt()
            val fail = it[5].replace(Regex(".*\\s"), "").toInt()
            monkeyOperations.add { old ->
                val new = when(operation.first()){
                    "+" -> (old + if(operation.last() =="old") old else operation.last().toInt()) / 3
                    else ->  (old * if(operation.last() =="old") old else operation.last().toInt()) /3
                }

                (if(new%test==0) success else fail) to new
            }
        }

        (1..20).forEach {
            monkeyItems.forEachIndexed { monkey, items ->
                monkeyInspections[monkey] = monkeyInspections.getOrPut(monkey) { 0 } + items.size
                val items = items.map { monkeyOperations[monkey](it) }
                monkeyItems[monkey].clear()
                items.forEach { monkeyItems[it.first].add(it.second) }
            }
        }

        return monkeyInspections.values.sortedDescending().take(2).reduce { acc, i ->  acc * i }
    }

    override fun part2(input: String): Any {
        val monkeyItems = mutableListOf<MutableList<Long>>()
        val monkeyInspections = mutableMapOf<Int,Long>()
        val monkeyOperations = mutableListOf<(Long) -> Pair<Int, Long>>()
        val monkeys = input.split("\n\n").map { it.split("\n") }

        monkeys.forEach {
            monkeyItems.add(it[1].drop(17).split(",").map { it.trim().toLong() }.toMutableList())
            val operation = it[2].drop(23).split(" ")
            val test = it[3].replace(Regex(".*\\s"), "").toLong()
            val success = it[4].replace(Regex(".*\\s"), "").toInt()
            val fail = it[5].replace(Regex(".*\\s"), "").toInt()
            monkeyOperations.add { old ->
                val new = when(operation.first()){
                    "+" -> (old + if(operation.last() =="old") old else operation.last().toLong())
                    else ->  (old * if(operation.last() =="old") old else operation.last().toLong())
                }

                (if(new%test==0L) success else fail) to new
            }
        }

        (1 ..10000).forEach {
            monkeyItems.forEachIndexed { monkey, items ->
                monkeyInspections[monkey] = monkeyInspections.getOrPut(monkey) { 0L } + items.size
                val items = items.map { monkeyOperations[monkey](it) }
                monkeyItems[monkey].clear()
                items.forEach { monkeyItems[it.first].add(it.second) }
            }
        }

        return monkeyInspections.values.sortedDescending().take(2).reduce { acc, i ->  acc * i }
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

