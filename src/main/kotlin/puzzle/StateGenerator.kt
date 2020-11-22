package puzzle

import puzzle.moves.MoveStrategy

class StateGenerator(private val strategies: Array<MoveStrategy>) {
    private val EMPTY_CELL_VALUE = 0

    fun generate(currentState: Array<Int>): List<Array<Int>> {
        val states = mutableListOf<Array<Int>>()
        for (strategy in strategies.filter { it -> isMovePossible(it, currentState) }) {
            states.add(strategy.move(currentState.clone(), currentState.indexOf(EMPTY_CELL_VALUE)))
        }

        return states
    }

    private fun isMovePossible(action: MoveStrategy, currentState: Array<Int>): Boolean {
        return currentState.indexOf(EMPTY_CELL_VALUE) !in action.barrierCells
    }
}