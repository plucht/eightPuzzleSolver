package puzzle.moves

class RightMove: MoveStrategy {
    override val barrierCells = arrayOf(2, 5, 8)

    override fun move(currentState: Array<Int>, indexOfEmptyCell: Int): Array<Int> {
        val nextState = currentState.clone()
        nextState[indexOfEmptyCell + 1] = currentState[indexOfEmptyCell]
        nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell + 1]

        return nextState
    }
}