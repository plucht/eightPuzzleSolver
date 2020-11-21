package puzzle.moves

interface MoveStrategy {
    val barrierCells: Array<Int>
    fun move(currentState: Array<Int>, indexOfEmptyCell: Int): Array<Int>
}