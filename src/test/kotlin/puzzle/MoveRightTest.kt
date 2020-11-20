package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class MoveRightTest {
    private val EMPTY_CELL_IS_CENTERED = arrayOf(1, 2, 3, 4, 5, 6, 7, 0, 8)
    private val EMPTY_CELL_IS_RIGHT = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 0)

    @Test fun testMoveEmptyCellRight() {
        assertArrayEquals(EMPTY_CELL_IS_RIGHT, MoveRight().move(EMPTY_CELL_IS_CENTERED))
    }

    @Test fun testDoNothingWhenEmptyCellIsFarRight() {
        assertArrayEquals(EMPTY_CELL_IS_RIGHT, MoveRight().move(EMPTY_CELL_IS_RIGHT))
    }
}
