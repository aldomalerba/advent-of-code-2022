import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day06Test {
    private val day = Day06()

    @Test
    fun `part 1 with mjqjpqmgbljsphdztnvjfqwrcgsmlb returns 7`() {
        val result = day.part1("mjqjpqmgbljsphdztnvjfqwrcgsmlb")

        assertEquals(7,result)
    }

    @Test
    fun `part 1 with bvwbjplbgvbhsrlpgdmjqwftvncz returns 5`() {
        val result = day.part1("bvwbjplbgvbhsrlpgdmjqwftvncz")

        assertEquals(5,result)
    }



    @Test
    fun `part 2 with mjqjpqmgbljsphdztnvjfqwrcgsmlb returns 19`() {
        val result = day.part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb")

        assertEquals(19, result)
    }
}