package puzzle.solvers

import org.junit.Assert
import puzzle.heuristics.ManhattanDistance
import kotlin.test.Test

internal class HeuristicSearchSolverTest {
    private val targetState = arrayOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
    )

    @Test
    fun itTerminatesIfTheInitialNodeIsTheTarget() {
        val solution = HeuristicSearchSolver(ManhattanDistance()).solve(targetState, targetState)
        Assert.assertArrayEquals(targetState, solution.state)
    }

    @Test
    fun itFindsTheTargetOneMoveAway() {
        val initial = arrayOf(
                1, 2, 3,
                4, 5, 6,
                7, 0, 8
        )

        val solution = HeuristicSearchSolver(ManhattanDistance()).solve(initial, targetState)
        Assert.assertArrayEquals(targetState, solution.state)
    }

    @Test
    fun itFindsTheTargetTwoMovesAway() {
        val initial = arrayOf(
                1, 2, 3,
                4, 5, 6,
                0, 7, 8
        )

        val solution = HeuristicSearchSolver(ManhattanDistance()).solve(initial, targetState)
        Assert.assertArrayEquals(targetState, solution.state)
    }
}