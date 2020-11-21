package puzzle

class MoveUp: MoveStrategy {
    override val barrierCells = arrayOf(0, 1, 2)

    override fun move(currentState: Array<Int>, indexOfEmptyCell: Int): Array<Int> {
        val nextState = currentState.clone()
        nextState[indexOfEmptyCell - 3] = currentState[indexOfEmptyCell]
        nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell - 3]

        return nextState
    }
}