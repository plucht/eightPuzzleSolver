package puzzle

class MoveLeft: MoveStrategy {
    override val barrierCells = arrayOf(0, 3, 6)

    override fun move(currentState: Array<Int>, indexOfEmptyCell: Int): Array<Int> {
        val nextState = currentState.clone()
        nextState[indexOfEmptyCell - 1] = currentState[indexOfEmptyCell]
        nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell - 1]

        return nextState
    }
}