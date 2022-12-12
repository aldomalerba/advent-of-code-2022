import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled

class Day09Test {
    private val day = Day09()
    private val input = readResourceText("Day09_test")
    private val largerInput = readResourceText("Day09_larger_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(13,result)
    }

    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals(1,result)
    }

    @Disabled
    @Test
    fun `part 2 larger input`() {
        val result = day.part2(largerInput)

        assertEquals(36,result)
    }
}