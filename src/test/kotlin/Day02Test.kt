import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02Test{
    private val input = readResourceText("Day02_test")

    @Test
    fun `part 1`() {
        val day = Day02()

        val result = day.part1(input)

         assertEquals(15, result)
    }


    @Test
    fun `part 2`() {
        val day = Day02()

        val result = day.part2(input)

        assertEquals(12, result)
    }
}