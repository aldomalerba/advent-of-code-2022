import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled

class Day11Test {
    private val day = Day11()
    private val input = readResourceText("Day11_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(10605,result)
    }

    @Disabled
    @Test
    fun `part 2`() {
        val result = day.part2(input)
        assertEquals(2713310158,result)
    }
}