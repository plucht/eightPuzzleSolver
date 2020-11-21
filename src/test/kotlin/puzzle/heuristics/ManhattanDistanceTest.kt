package puzzle.heuristics

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ManhattanDistanceTest {
    @Test fun testEstimateCosts() {
        val initialState = arrayOf(
                1, 2, 3,
                4, 5, 6,
                7, 0, 8
        )
        val targetState = arrayOf(
                1, 2, 3,
                4, 5, 6,
                7, 8, 0
        )
        assertEquals(1, ManhattanDistance().estimateCosts(initialState, targetState))
    }

    @Test fun testEstimateHigherCosts() {
        val initialState = arrayOf(
                1, 2, 3,
                4, 5, 6,
                0, 7, 8
        )
        val targetState = arrayOf(
                1, 2, 3,
                4, 5, 6,
                7, 8, 0
        )

        assertEquals(2, ManhattanDistance().estimateCosts(initialState, targetState))
    }
}