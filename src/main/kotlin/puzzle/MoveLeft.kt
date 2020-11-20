package puzzle

class MoveLeft {
    val disabledCells: Array<Int>
        get() {
            return arrayOf(0, 3, 6)
        }

    fun move(currentState: Array<Int>): Array<Int> {
        val emptyCellIndex = currentState.indexOf(0)

        if (disabledCells.contains(emptyCellIndex)) return currentState

        val nextState = currentState.clone()

        nextState.set(emptyCellIndex - 1, currentState.get(emptyCellIndex))
        nextState.set(emptyCellIndex, currentState.get(emptyCellIndex - 1))

        return nextState
    }
}