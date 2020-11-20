package puzzle

class MoveRight {
    private val EMPTY_CELL_VALUE = 0

    private val barrierCells: Array<Int>
        get() {
            return arrayOf(2, 5, 8)
        }

    fun move(currentState: Array<Int>): Array<Int> {
        val indexOfEmptyCell = currentState.indexOf(EMPTY_CELL_VALUE)

        return when (indexOfEmptyCell) {
            in barrierCells -> currentState
            else -> fun (): Array<Int> {
                val nextState = currentState.clone()
                nextState[indexOfEmptyCell + 1] = currentState[indexOfEmptyCell]
                nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell + 1]

                return nextState
            }()
        }
    }
}