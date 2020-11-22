package puzzle

import puzzle.heuristics.ManhattanDistance
import puzzle.solvers.HeuristicSearchSolver
import puzzle.state.Node

fun main(args: Array<String>) {
    println("Hello there")

    val initialState = mutableListOf<Int>()
    for (i in 1..3) {
        initialState.addAll(readLine()!!.split(" ")
                .map { it -> it.toInt() }
                .filter { it -> it in 0..8 }
        )
    }

    try {
        renderState(initialState.toTypedArray(), "Initial state:")
        val targetNode = findTargetNode(initialState.toTypedArray())
        renderState(targetNode.state, "Target state:")
    } catch (e: Exception) {
        println("No solution found. :see_no_evil:")
    }
}

private fun findTargetNode(initialState: Array<Int>): Node {
    val solver = HeuristicSearchSolver(ManhattanDistance())
    val targetState = arrayOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
    )

    return solver.solve(initialState, targetState)
}

fun renderState(state: Array<Int>, description: String) {
    println(description)
    println("" + state[0] + " " + state[1] + " " + state[2])
    println("" + state[3] + " " + state[4] + " " + state[5])
    println("" + state[6] + " " + state[7] + " " + state[8])
}