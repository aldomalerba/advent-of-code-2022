import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day03Test {
    private val day = Day03()
    private val input = readResourceText("Day02_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(1,result)
    }


    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals(1, result)
    }
}