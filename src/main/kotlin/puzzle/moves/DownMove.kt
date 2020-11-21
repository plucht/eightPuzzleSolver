package puzzle.moves

class DownMove: MoveStrategy {
    override val barrierCells = arrayOf(6, 7, 8)

    override fun move(currentState: Array<Int>, indexOfEmptyCell: Int): Array<Int> {
        val nextState = currentState.clone()
        nextState[indexOfEmptyCell + 3] = currentState[indexOfEmptyCell]
        nextState[indexOfEmptyCell] = currentState[indexOfEmptyCell + 3]

        return nextState
    }
}