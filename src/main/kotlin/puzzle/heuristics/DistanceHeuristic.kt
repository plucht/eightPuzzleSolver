package puzzle.heuristics

interface DistanceHeuristic {
    fun estimateCosts(currentState: Array<Int>, targetState: Array<Int>): Int
}