import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day05Test {
    private val day = Day05()
    private val input = readResourceText("Day05_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals("CMZ",result)
    }


    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals("MCD", result)
    }
}