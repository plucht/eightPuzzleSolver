package puzzle

import puzzle.heuristics.ManhattanDistance
import puzzle.solvers.HeuristicSearchSolver
import puzzle.state.Node
import java.util.*

fun main(args: Array<String>) {
    println("Please enter initial state")

    val initialState = mutableListOf<Int>()
    for (i in 1..3) {
        initialState.addAll(readLine()!!.split(" ")
                .map { it -> it.toInt() }
                .filter { it -> it in 0..8 }
        )
    }

    try {
        val targetNode = findTargetNode(initialState.toTypedArray())
        renderSolutionPath(targetNode)
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

fun buildSolutionPath(node: Node): Stack<Node> {
    val solutionPath = Stack<Node>()
    solutionPath.push(node)

    while (solutionPath.peek().parent != null) {
        solutionPath.push(solutionPath.peek().parent)
    }

    return solutionPath
}

fun renderSolutionPath(targetNode: Node) {
    val solutionPath = buildSolutionPath(targetNode)

    while (solutionPath.isNotEmpty()) {
        val currentNode = solutionPath.pop()
        renderState(currentNode.state, "Next state:")
    }
}