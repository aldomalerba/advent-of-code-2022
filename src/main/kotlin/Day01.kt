class Day01 {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0

        for(calorie in input){

            if(calorie.isNotEmpty()){
                current += calorie.toInt()
                if(current > max){
                    max = current
                }
            }else{
                current = 0
            }

        }
        return  max
    }

    fun part2(input: List<String>): Int {
        val maxs = mutableMapOf(1 to 0, 2 to 0, 3 to 0)
        var current = 0
        var min = maxs.minBy { it.value }

        for (calorie in input) {
            if(calorie.isNotEmpty()){
                current += calorie.toInt()
                val max = if (current > min.value){
                    current
                }else min.value
                maxs[min.key] = max
            }else {
                min = maxs.minBy { it.value }
                current = 0
            }
        }


        return  maxs.values.sum()
    }
}

fun main() {
    val day = Day01()
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(day.part1(testInput) == 24000)
    check(day.part2(testInput) == 45000)

    val input = readInput("Day01")
    println(day.part1(input))
    println(day.part2(input))
}
