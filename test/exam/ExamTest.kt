package exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExamTest {

    @Test
    fun testExample() {
        assertEquals(42, example("input/example.txt"))
    }

    @Test
    fun pressureFromDownToUpTest() {
        val actual = pressure("input/pressure.txt", "x < next")
        val expected = "01.01: 755, 05.01: 758, 12.01: 765, 10.02: 739."
        assertEquals(expected, actual)
    }

    @Test
    fun pressureFromUpToDownTest() {
        val actual = pressure("input/pressure.txt", "x > next")
        val expected = "20.01: 768, 24.01: 763, 30.01: 756, 2.02: 752, 5.02: 745."
        assertEquals(expected, actual)
    }
}