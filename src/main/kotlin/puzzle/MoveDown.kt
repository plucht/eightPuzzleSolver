package puzzle

class MoveDown: MoveStrategy {
    private val EMPTY_CELL_VALUE = 0

    override val barrierCells = arrayOf(6, 7, 8)

    override fun move(currentState: Array<Int>): Array<Int> {
        val indexOfEmptyCell = currentState.indexOf(EMPTY_CELL_VALUE)
        val nextState = currentState.clone()
        nextState[indexOfEmptyCell + 3] = currentState[indexOfEmptyCell]
        nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell + 3]

        return nextState
    }
}