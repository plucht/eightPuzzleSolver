package puzzle

import puzzle.solvers.Solver
import puzzle.state.Node

fun main(args: Array<String>) {
    println("Please enter initial state")
    val initialState = readInitialState()

    val solutionPathRenderer = AppFactory().createSolutionPathRenderer()
    val solver = AppFactory().createHeuristicSearchSolver()
    try {
        val targetNode = findTargetNode(initialState, solver)
        solutionPathRenderer.renderSolutionPath(targetNode)
    } catch (e: Exception) {
        println("No solution found. :see_no_evil:")
    }
}

private fun readInitialState(): Array<Int> {
    val initialState = mutableListOf<Int>()
    for (i in 1..3) {
        initialState.addAll(readLine()!!.split(" ")
                .map { it -> it.toInt() }
                .filter { it -> it in 0..8 }
        )
    }

    return initialState.toTypedArray()
}

private fun findTargetNode(initialState: Array<Int>, solver: Solver): Node {
    val targetState = arrayOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
    )

    return solver.solve(initialState, targetState)
}