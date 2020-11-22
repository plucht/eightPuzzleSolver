package puzzle.solvers

import puzzle.state.StateGenerator
import puzzle.heuristics.DistanceHeuristic
import puzzle.moves.MoveStrategy
import puzzle.state.Node
import java.util.*
import kotlin.collections.HashSet

class HeuristicSearchSolver(private val heuristic: DistanceHeuristic, private val moves: Array<MoveStrategy>) : Solver {
    override fun solve(initialState: Array<Int>, targetState: Array<Int>): Node {
        if (isTargetState(initialState, targetState)) {
            return Node(initialState, null, 0)
        }

        val stateGenerator = StateGenerator(moves)
        val closedList = HashSet<Node>()
        val openList = PriorityQueue<Node>()
        openList.add(Node(initialState, null, heuristic.estimateCosts(initialState, targetState)))

        while (openList.isNotEmpty()) {
            val currentNode = openList.poll()
            if (isTargetState(currentNode.state, targetState)) {
                return currentNode
            }

            closedList.add(currentNode)

            val generatedNodes = stateGenerator
                    .generate(currentNode.state)
                    .map { it -> Node(it, currentNode, heuristic.estimateCosts(it, targetState)) }
            val unexploredNodes = generatedNodes
                    .filter { it -> !openList.contains(it) && !closedList.contains(it) }

            openList.addAll(unexploredNodes)
            closedList.addAll(generatedNodes.minus(unexploredNodes))
        }

        throw Exception("No solution found.")
    }

    private fun isTargetState(currentState: Array<Int>, targetState: Array<Int>): Boolean {
        return targetState.contentEquals(currentState)
    }
}