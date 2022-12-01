import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test{
    private val day1 = Day01()
    private val input = readResourceText("Day01_test")

    @Test
    fun `part 1`() {
        val result = day1.part1(input)

        assertEquals(24000, result)
    }

    @Test
    fun `part 2`() {
        val result = day1.part2(input)

        assertEquals(45000, result)
    }
}