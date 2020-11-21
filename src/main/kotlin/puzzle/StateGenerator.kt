package puzzle

class StateGenerator(private val strategies: Array<MoveStrategy>) {
    private val EMPTY_CELL_VALUE = 0

    fun generate(currentState: Array<Int>): Array<Int> {
        var nextState = currentState.clone()
        for (strategy in strategies.filter { it -> isMovePossible(it, currentState) }) {
            nextState = strategy.move(currentState, currentState.indexOf(EMPTY_CELL_VALUE))
        }

        return nextState
    }

    private fun isMovePossible(action: MoveStrategy, currentState: Array<Int>): Boolean {
        return currentState.indexOf(EMPTY_CELL_VALUE) !in action.barrierCells
    }
}