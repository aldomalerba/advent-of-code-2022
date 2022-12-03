import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day03Test {
    private val day = Day03()
    private val input = readResourceText("Day03_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(157,result)
    }


    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals(70, result)
    }
}