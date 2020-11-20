package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class MoveLeftTest {
    private val EMPTY_CELL_IS_CENTERED = arrayOf(1, 2, 3, 4, 5, 6, 7, 0, 8)
    private val EMPTY_CELL_IS_LEFT = arrayOf(1, 2, 3, 4, 5, 6, 0, 7, 8)

    @Test fun testMoveEmptyCellLeft() {
        assertArrayEquals(EMPTY_CELL_IS_LEFT, MoveLeft().move(EMPTY_CELL_IS_CENTERED))
    }

    @Test fun testDoNothingWhenEmptyCellIsFarLeft() {
        assertArrayEquals(EMPTY_CELL_IS_LEFT, MoveLeft().move(EMPTY_CELL_IS_LEFT))
    }
}
