package puzzle.state

import kotlin.Comparable

class Node(val state: Array<Int>, val parent: Node?, val costs: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return costs.compareTo(other.costs)
    }

    override fun hashCode(): Int {
        return state.contentHashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (!state.contentEquals(other.state)) return false

        return true
    }
}