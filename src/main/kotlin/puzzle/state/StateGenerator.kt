package puzzle.state

import puzzle.moves.MoveStrategy

class StateGenerator(private val strategies: Array<MoveStrategy>) {
    private val EMPTY_CELL_VALUE = 0

    fun generate(currentState: Array<Int>): List<Array<Int>> {
        return strategies
                .filter { it -> isMovePossible(it, currentState) }
                .map { it -> it.move(currentState.clone(), currentState.indexOf(EMPTY_CELL_VALUE)) }
    }

    private fun isMovePossible(action: MoveStrategy, currentState: Array<Int>): Boolean {
        return currentState.indexOf(EMPTY_CELL_VALUE) !in action.barrierCells
    }
}