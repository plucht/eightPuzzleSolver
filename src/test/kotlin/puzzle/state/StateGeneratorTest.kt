package puzzle.state

import org.junit.Assert.assertArrayEquals
import puzzle.moves.DownMove
import puzzle.moves.LeftMove
import puzzle.moves.RightMove
import puzzle.moves.UpMove
import kotlin.test.Test
import kotlin.test.assertSame

internal class StateGeneratorTest {
    private val EMPTY_CELL_IN_CENTER = arrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8)
    private val EMPTY_CELL_IN_LEFT_COLUMN = arrayOf(1, 2, 3, 0, 4, 5, 6, 7, 8)
    private val EMPTY_CELL_IN_RIGHT_COLUMN = arrayOf(1, 2, 3, 4, 5, 0, 6, 7, 8)
    private val EMPTY_CELL_IN_BOTTOM_ROW = arrayOf(1, 2, 3, 4, 7, 5, 6, 0, 8)
    private val EMPTY_CELL_IN_TOP_ROW = arrayOf(1, 0, 3, 4, 2, 5, 6, 7, 8)

    @Test fun testMoveEmptyCellRight() {
        assertArrayEquals(EMPTY_CELL_IN_RIGHT_COLUMN, StateGenerator(arrayOf(RightMove())).generate(EMPTY_CELL_IN_CENTER).first())
    }

    @Test fun testDoNotMoveRightWhenEmptyCellInRightColumn() {
        assertSame(0, StateGenerator(arrayOf(RightMove())).generate(EMPTY_CELL_IN_RIGHT_COLUMN).size)
    }

    @Test fun testMoveEmptyCellLeft() {
        assertArrayEquals(EMPTY_CELL_IN_LEFT_COLUMN, StateGenerator(arrayOf(LeftMove())).generate(EMPTY_CELL_IN_CENTER).first())
    }

    @Test fun testDoNotMoveLeftWhenEmptyCellInLeftColumn() {
        assertSame(0, StateGenerator(arrayOf(LeftMove())).generate(EMPTY_CELL_IN_LEFT_COLUMN).size)
    }

    @Test fun testMoveEmptyCellUp() {
         assertArrayEquals(EMPTY_CELL_IN_TOP_ROW, StateGenerator(arrayOf(UpMove())).generate(EMPTY_CELL_IN_CENTER).first())
    }

    @Test fun testDoNotMoveUpWhenEmptyCellInTopRow() {
        assertSame(0, StateGenerator(arrayOf(UpMove())).generate(EMPTY_CELL_IN_TOP_ROW).size)
    }

    @Test fun testMoveEmptyCellDown() {
         assertArrayEquals(EMPTY_CELL_IN_BOTTOM_ROW, StateGenerator(arrayOf(DownMove())).generate(EMPTY_CELL_IN_CENTER).first())
    }

    @Test fun testDoNotMoveDownWhenEmptyCellInBottomRow() {
        assertSame(0, StateGenerator(arrayOf(DownMove())).generate(EMPTY_CELL_IN_BOTTOM_ROW).size)
    }
}
