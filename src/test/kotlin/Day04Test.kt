import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day04Test {
    private val day = Day04()
    private val input = readResourceText("Day04_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(2,result)
    }


    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals(4, result)
    }
}