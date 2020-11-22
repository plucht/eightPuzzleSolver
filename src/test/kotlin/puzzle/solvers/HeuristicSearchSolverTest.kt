package puzzle.solvers

import org.junit.Assert
import puzzle.AppFactory
import kotlin.test.Test

internal class HeuristicSearchSolverTest {
    private val targetState = arrayOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
    )

    @Test
    fun itTerminatesIfTheInitialNodeIsTheTarget() {
        val solution = AppFactory().createHeuristicSearchSolver().solve(targetState, targetState)
        Assert.assertArrayEquals(targetState, solution.state)
    }

    @Test
    fun itFindsTheTargetOneMoveAway() {
        val initialState = arrayOf(
                1, 2, 3,
                4, 5, 6,
                7, 0, 8
        )

        val solution = AppFactory().createHeuristicSearchSolver().solve(initialState, targetState)
        Assert.assertArrayEquals(targetState, solution.state)
    }

    @Test
    fun itFindsTheTargetTwoMovesAway() {
        val initialState = arrayOf(
                1, 2, 3,
                4, 5, 6,
                0, 7, 8
        )

        val solution = AppFactory().createHeuristicSearchSolver().solve(initialState, targetState)
        Assert.assertArrayEquals(targetState, solution.state)
    }
}