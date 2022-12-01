import java.io.FileNotFoundException

class Day02: Parts{
    override fun part1(input: String) = 1
    override fun part2(input: String) = 2
}

fun main() {
    val day = Day02()
    try {
        val input = readText("Day02")
        println(day.part1(input))
        println(day.part2(input))
    }catch (e: FileNotFoundException){
        println("Day02 file needs to be created in the src folder.")
    }
}
