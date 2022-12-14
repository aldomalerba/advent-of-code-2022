import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled

@Disabled
class Day12Test {
    private val day = Day12()
    private val input = readResourceText("Day12_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(10605,result)
    }

    @Test
    fun `part 2`() {
        val result = day.part2(input)
        assertEquals(2713310158,result)
    }
}