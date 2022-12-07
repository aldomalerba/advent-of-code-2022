import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day07Test {
    private val day = Day07()
    private val input = readResourceText("Day07_test")

    @Test
    fun `part 1`() {
        val result = day.part1(input)

        assertEquals(95437,result)
    }

    @Test
    fun `part 2`() {
        val result = day.part2(input)

        assertEquals(24933642,result)
    }
}