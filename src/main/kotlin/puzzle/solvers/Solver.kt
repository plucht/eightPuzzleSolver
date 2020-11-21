package puzzle.solvers

import puzzle.state.Node

interface Solver {
    fun solve(initialState: Array<Int>, targetState: Array<Int>): Node
}