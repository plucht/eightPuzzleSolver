package puzzle

interface MoveStrategy {
    val barrierCells: Array<Int>
    fun move(currentState: Array<Int>): Array<Int>
}