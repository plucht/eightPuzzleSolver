package puzzle

import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

internal class StateGeneratorTest {
    private val EMPTY_CELL_IN_LEFT_COLUMN = arrayOf(1, 2, 3, 4, 5, 6, 0, 7, 8)
    private val EMPTY_CELL_IN_RIGHT_COLUMN = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 0)
    private val EMPTY_CELL_IN_BOTTOM_ROW = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 0)
    private val EMPTY_CELL_IN_TOP_ROW = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    @Test fun testDoNotMoveRightWhenEmptyCellInRightColumn() {
        assertArrayEquals(EMPTY_CELL_IN_RIGHT_COLUMN, StateGenerator(arrayOf(MoveRight())).generate(EMPTY_CELL_IN_RIGHT_COLUMN))
    }

    @Test fun testDoNotMoveLeftWhenEmptyCellInLeftColumn() {
        assertArrayEquals(EMPTY_CELL_IN_LEFT_COLUMN, StateGenerator(arrayOf(MoveLeft())).generate(EMPTY_CELL_IN_LEFT_COLUMN))
    }

    @Test fun testDoNotMoveUpWhenEmptyCellInTopRow() {
        assertArrayEquals(EMPTY_CELL_IN_TOP_ROW, StateGenerator(arrayOf(MoveUp())).generate(EMPTY_CELL_IN_TOP_ROW))
    }

    @Test fun testDoNotMoveDownWhenEmptyCellInBottomRow() {
        assertArrayEquals(EMPTY_CELL_IN_BOTTOM_ROW, StateGenerator(arrayOf(MoveDown())).generate(EMPTY_CELL_IN_BOTTOM_ROW))
    }
}
