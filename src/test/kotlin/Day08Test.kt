import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day08Test {
    private val day = Day08()
    private val input = readResourceText("Day08_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(21,result)
    }

    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals(8,result)
    }
}