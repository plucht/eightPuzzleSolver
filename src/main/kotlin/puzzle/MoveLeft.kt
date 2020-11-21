package puzzle

class MoveLeft: MoveStrategy {
    private val EMPTY_CELL_VALUE = 0

    override val barrierCells: Array<Int>
        get() {
            return arrayOf(0, 3, 6)
        }

    override fun move(currentState: Array<Int>): Array<Int> {
        val indexOfEmptyCell = currentState.indexOf(EMPTY_CELL_VALUE)
        val nextState = currentState.clone()
        nextState[indexOfEmptyCell - 1] = currentState[indexOfEmptyCell]
        nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell - 1]

        return nextState
    }
}