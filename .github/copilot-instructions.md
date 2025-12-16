# Copilot Instructions for Java Study Project

This project is a collection of solutions to coding problems from the "Programmers" platform, organized by difficulty levels (1-3). It focuses on mastering Java core concepts, algorithms, and SOLID principles.

## Architecture Overview

- **Standalone Solutions**: Each problem is solved in a separate Java file under `programmers/level_X/`, with no interdependencies.
- **No Frameworks**: Pure Java using standard libraries; no external dependencies.
- **Learning Focus**: Emphasizes Stream API, Lambda, Optional, DFS/BFS, Greedy algorithms, and SOLID refactoring.

## Code Structure & Conventions

- **Class Naming**: Class name matches file name and problem name (e.g., `Network.java` → `public class Network`).
- **Solution Method**: Primary logic in `public int solution(...)` or appropriate return type; parameters match problem inputs.
- **Documentation**: Add comments for core logic; include time complexity where relevant.
- **Submission Prep**: Rename class to `Solution` for platform submission.

## Common Solution Patterns

- **Graph Traversal**: Use DFS with boolean visited array and adjacency matrix (see [Network.java](programmers/level_3/Network.java)).
- **Priority Queues**: For scheduling problems, use `PriorityQueue` with custom comparators (see [DiskController.java](programmers/level_3/DiskController.java)).
- **Hash Collections**: `HashMap`/`HashSet` for counting/frequency (see [IncompleteParticipant.java](programmers/level_1/IncompleteParticipant.java)).
- **Stream Operations**: Prefer `IntStream` for primitives; use `Optional` for null-safe returns (see [docs/Stream-basic.md](docs/Stream-basic.md)).
- **SRP/OCP Refactoring**: Separate concerns like validation, encryption, storage (see [docs/SRP-OCP.md](docs/SRP-OCP.md)).

## Development Workflows

- **Compilation**: `javac programmers/level_X/Problem.java` (Java 17+).
- **Testing**: Add a `main` method to test `solution()` calls; use IDE for debugging.
- **Version Control**: Commit after each problem; document in READMEs.

## Key References

- [README.md](README.md): Project goals and schedule.
- [programmers/README.md](programmers/README.md): Problem list with keywords/difficulty.
- [docs/](docs/): Summaries on Java core, Stream, SOLID principles.

Prioritize readable, efficient code; avoid over-engineering for coding problems.