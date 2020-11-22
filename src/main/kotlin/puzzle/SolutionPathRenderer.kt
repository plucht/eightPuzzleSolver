package puzzle

import puzzle.state.Node
import java.util.*

class SolutionPathRenderer {
    fun renderSolutionPath(targetNode: Node) {
        val solutionPath = buildSolutionPath(targetNode)

        while (solutionPath.isNotEmpty()) {
            val currentNode = solutionPath.pop()
            renderState(currentNode.state)
        }
    }

    private fun renderState(state: Array<Int>) {
        println("Next state")
        println("" + state[0] + " " + state[1] + " " + state[2])
        println("" + state[3] + " " + state[4] + " " + state[5])
        println("" + state[6] + " " + state[7] + " " + state[8])
    }

    private fun buildSolutionPath(node: Node): Stack<Node> {
        val solutionPath = Stack<Node>()
        solutionPath.push(node)

        while (solutionPath.peek().parent != null) {
            solutionPath.push(solutionPath.peek().parent)
        }

        return solutionPath
    }
}