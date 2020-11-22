package puzzle

import puzzle.heuristics.ManhattanDistance
import puzzle.solvers.HeuristicSearchSolver

class AppFactory {
    fun createHeuristicSearchSolver() = HeuristicSearchSolver(ManhattanDistance())
    fun createSolutionPathRenderer() = SolutionPathRenderer()
}