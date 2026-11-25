# INF234 Algorithm Implementations

Java implementations and self-tests for algorithms from the INF234 course, organized by chapter under `src/`.

Run the test harness with:

```sh
./run-tests.sh
```

The harness compiles all sources and runs each algorithm's `main` method. Some algorithms are still marked `TODO`; their test cases are included and will run once the implementations are completed.

Start the interactive CLI with:

```sh
./run
```

The CLI can run all self-tests, run a selected algorithm's self-test, repeat the last selected test (the last algorithm is the initial default), or call an algorithm's `solve` method with custom input. For custom input, select an algorithm and enter one JSON array containing its arguments in order. Records use JSON objects with their field names; graphs use `{"vertices":[0,1],"edges":[[0,1]],"directed":false}` and weighted graph edges include a weight, for example `[0,1,5]`.
