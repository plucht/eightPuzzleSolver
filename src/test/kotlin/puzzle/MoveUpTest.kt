package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class MoveUpTest {
    private val EMPTY_CELL_IS_CENTERED = arrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8)
    private val EMPTY_CELL_IN_TOP_ROW = arrayOf(1, 0, 3, 4, 2, 5, 6, 7, 8)

    @Test fun testMoveEmptyCellUp() {
        assertArrayEquals(EMPTY_CELL_IN_TOP_ROW, MoveUp().move(EMPTY_CELL_IS_CENTERED))
    }
}
