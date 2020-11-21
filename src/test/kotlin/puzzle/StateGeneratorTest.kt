package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class StateGeneratorTest {
    private val EMPTY_CELL_IS_LEFT = arrayOf(1, 2, 3, 4, 5, 6, 0, 7, 8)
    private val EMPTY_CELL_IS_RIGHT = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 0)

    @Test fun testDoNothingWhenEmptyCellIsFarRight() {
        assertArrayEquals(EMPTY_CELL_IS_RIGHT, StateGenerator(arrayOf(MoveRight())).generate(EMPTY_CELL_IS_RIGHT))
    }

    @Test fun testDoNothingWhenEmptyCellIsFarLeft() {
        assertArrayEquals(EMPTY_CELL_IS_LEFT, StateGenerator(arrayOf(MoveLeft())).generate(EMPTY_CELL_IS_LEFT))
    }
}
