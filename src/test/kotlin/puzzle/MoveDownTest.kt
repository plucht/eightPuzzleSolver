package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class MoveDownTest {
    private val EMPTY_CELL_IS_CENTERED = arrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8)
    private val EMPTY_CELL_IN_BOTTOM_ROW = arrayOf(1, 2, 3, 4, 7, 5, 6, 0, 8)

    @Test fun testMoveEmptyCellUp() {
        assertArrayEquals(EMPTY_CELL_IN_BOTTOM_ROW, MoveDown().move(EMPTY_CELL_IS_CENTERED))
    }
}
