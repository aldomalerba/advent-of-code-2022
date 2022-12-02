import java.io.FileNotFoundException

class Day03: Parts{

    override fun part1(input: String) = 1
    override fun part2(input: String) = 1

}

fun main() {
    val day = Day03()
    try {
        val input = readText("Day03")
        println(day.part1(input))
        println(day.part2(input))
    }catch (e: FileNotFoundException){
        println("Day03 file needs to be created in the src folder.")
    }
}
