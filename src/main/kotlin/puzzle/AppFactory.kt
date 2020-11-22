package puzzle

import puzzle.heuristics.ManhattanDistance
import puzzle.moves.*
import puzzle.solvers.HeuristicSearchSolver

class AppFactory {
    fun createHeuristicSearchSolver() = HeuristicSearchSolver(ManhattanDistance(), arrayOf(UpMove(), DownMove(), LeftMove(), RightMove()))
    fun createSolutionPathRenderer() = SolutionPathRenderer()
}