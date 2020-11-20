package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class MoveLeftTest {
    private val EMPTY_CELL_IS_CENTERED = arrayOf(1, 2, 3, 4, 5, 6, 7, 0, 8)
    private val EMPTY_CELL_IS_LEFT = arrayOf(1, 2, 3, 4, 5, 6, 0, 7, 8)

    @Test fun testMoveEmptyCellLeft() {
        val currentState = EMPTY_CELL_IS_CENTERED
        val expectedState = EMPTY_CELL_IS_LEFT

        assertArrayEquals(expectedState, MoveLeft().move(currentState))
    }

    @Test fun testDoNothingWhenEmptyCellIsFarLeft() {
        val currentState = EMPTY_CELL_IS_LEFT

        assertArrayEquals(currentState, MoveLeft().move(currentState))
    }
}
