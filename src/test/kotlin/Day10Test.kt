import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10Test {
    private val day = Day10()
    private val input = readResourceText("Day10_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(13140,result)
    }

    @Test
    fun `part 2`() {
        val result = day.part2(input)

        val expectedResult = listOf(
            "##..##..##..##..##..##..##..##..##..##..",
            "###...###...###...###...###...###...###.",
            "####....####....####....####....####....",
            "#####.....#####.....#####.....#####.....",
            "######......######......######......####",
            "#######.......#######.......#######....."
        )
        assertEquals(expectedResult,result)
    }
}