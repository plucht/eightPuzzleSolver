# Clean Code Diskussion
Bei der Benennung von Variablen und Klassen habe ich darauf geachtet, denselben Konzepten auch durchgängig denselben Namen zu geben, wobei der richtige Name sich bei häufigeren betrachten und nachdenken auch immer wieder ändern kann.

Die möglichen Spielzüge (z.B. DownMove) im Package [moves](https://github.com/plucht/eightPuzzleSolver/tree/master/src/main/kotlin/puzzle/moves) implementieren alle das Interface [MoveStrategy](https://github.com/plucht/eightPuzzleSolver/blob/master/src/main/kotlin/puzzle/moves/MoveStrategy.kt).

In meinem Clean Code Cheat Sheet weise ich darauf hin, dass die Idiome einer Sprache genutzt werden sollen. Im Code kommt immer wieder die Verwendung von 'Array<Int>' vor, wobei in Kotlin auch 'IntArray' möglich wäre. Ich habe nicht genug Erfahrung mit Kotlin um eine der Optionen als idiomatischer als die andere zu empfinden, daher wird erstmal 'Array<Int>' verwendet. Clean ist dies deshalb, da es sich konsistent durch die Codebasis zieht.

Einige Operationen könnten als Schleife implementiert werden, letztlich empfand ich einen funktionalen Ansatz als idiomatischer in Kotlin als einen prozeduralen (vergleiche [hier](https://github.com/plucht/eightPuzzleSolver/commit/d60a4c26e94e9722bb569c95d10b0b185f94d15e) u. [hier](https://github.com/plucht/eightPuzzleSolver/commit/b4e6815508b7ecdac4ed2c258c266b60842a9585)). Die Verkettung von solcher Operationen macht es bei späteren Erweiterungen einfacher zu erfassen und zu verstehen, was mit den Daten passiert, als wenn dies alles in einer Schleife abgearbeitet wird.

Die [AppFactory](https://github.com/plucht/eightPuzzleSolver/blob/master/src/main/kotlin/puzzle/AppFactory.kt) ermöglicht eine einfache Form der DependencyInjection und ermöglicht wichtige Objekte für Tests und den produktiven Code zur Verfügung zu stellen.

Die Objekte verlassen sich untereinander auf Abstraktionen in Form von Interfaces wie z.B. [DistanceHeuristic](https://github.com/plucht/eightPuzzleSolver/blob/master/src/main/kotlin/puzzle/heuristics/DistanceHeuristic.kt) und erfüllen somit das Prinzip der Dependency Inversion.

Einzelne Klassen und Funktionen sind möglichst kurz gehalten um das Verständnis zu fördern und dem Single Responsibility Principle zu genügen. Aus diesem Grund ist z.B. auch das Generieren neuer Lösungszustände in eine [eigene Klasse ausgelagert](https://github.com/plucht/eightPuzzleSolver/blob/master/src/main/kotlin/puzzle/state/StateGenerator.kt), da dies sonst ebenfalls vom eigentlichen [Suchalgorithmus](https://github.com/plucht/eightPuzzleSolver/blob/master/src/main/kotlin/puzzle/solvers/HeuristicSearchSolver.kt) hätte übernommen werden müssen.
