import java.io.FileNotFoundException


data class Elevation(val name: String, val value: Int)

class Day12: Parts {
    override fun part1(input: String): Any {
        val adjacentElevations = mutableMapOf<String,Set<Elevation>>()
        input.lines().forEachIndexed { y, row ->
            row.forEachIndexed { x, value ->
                val name = if(value=='S'||value=='E') "$value" else "$x$y"
                val code = when(value){
                    'S' -> 'a'.code
                    'E' -> 'z'.code
                    else -> value.code
                }

                val adjacents = adjacents(input, y, x).filter { it.value <= code +1  }.toSet()

                adjacentElevations[name] = adjacents
            }
        }


        var shortestDistance = -1
        val previous = mutableMapOf<String,String>()
        fun dfs(currentNode: String, depth:Int) {
            if (currentNode == "E") {
                shortestDistance = depth;
            } else {
                for (neighbour in adjacentElevations[currentNode]!!) {
                    previous[neighbour.name] = currentNode
                    dfs(neighbour.name, depth + 1)
                }
            }
        }
        dfs("S", 0);
        return shortestDistance
    }

    private fun adjacents(input: String, y: Int, x: Int) = setOfNotNull(
        elevationAt(input, y - 1, x),
        elevationAt(input, y, x - 1),
        elevationAt(input, y, x + 1),
        elevationAt(input, y + 1, x),
    )

    private fun elevationAt(input: String, y: Int, x: Int): Elevation? {
        val elevationValue = input.lines().getOrNull(y)?.getOrNull(x)
        if(elevationValue=='S'||elevationValue=='E') return Elevation("$elevationValue", elevationValue.code)
        return elevationValue?.let { Elevation("$x$y", it.code) }
    }


    override fun part2(input: String): Any {
        TODO("Not yet implemented")
    }

}

fun main() {
    val day = Day12()
    try {
        val input = readText("Day12")
        println(day.part1(input))
        println(day.part2(input))
    } catch (e: FileNotFoundException) {
        println("Day12 file needs to be created in the src folder.")
    }
}
