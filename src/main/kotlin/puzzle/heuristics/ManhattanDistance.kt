package puzzle.heuristics

import kotlin.math.abs

class ManhattanDistance : DistanceHeuristic {
    private val EMPTY_CELL_VALUE = 0

    override fun estimateCosts(currentState: Array<Int>, targetState: Array<Int>): Int {
        return currentState
                .map { field -> distanceToTargetFieldPosition(currentState, targetState, field) }
                .sum()
    }

    private fun distanceToTargetFieldPosition(currentState: Array<Int>, targetState: Array<Int>, fieldIndex: Int): Int {
        if (currentState[fieldIndex] == EMPTY_CELL_VALUE) return 0

        val fieldPosition = arrayOf(
                fieldIndex % 3,
                fieldIndex / 3
        )

        val fieldValue = currentState[fieldIndex]
        val targetPosition = findValuePosition(targetState, fieldValue)

        return abs(fieldPosition[0] - targetPosition[0]) + abs(fieldPosition[1] - targetPosition[1])
    }

    private fun findValuePosition(space: Array<Int>, needle: Int): Array<Int> {
        return arrayOf(
                space.indexOf(needle) % 3,
                space.indexOf(needle) / 3
        )
    }
}