package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class MoveRightTest {
    private val EMPTY_CELL_IS_CENTERED = arrayOf(1, 2, 3, 4, 5, 6, 7, 0, 8)
    private val EMPTY_CELL_IS_RIGHT = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 0)

    @Test fun testMoveEmptyCellRight() {
        val currentState = EMPTY_CELL_IS_CENTERED
        val expectedState = EMPTY_CELL_IS_RIGHT

        assertArrayEquals(expectedState, MoveRight().move(currentState))
    }

    @Test fun testDoNothingWhenEmptyCellIsFarRight() {
        val currentState = EMPTY_CELL_IS_RIGHT

        assertArrayEquals(currentState, MoveRight().move(currentState))
    }
}
