# _Random Number Generator_

## Environment

- Scala version `2.12.8` // (`2.13.1`)
- Sbt version `1.3.2`
- ScalaTest `3.0.8`
- Scalafmt `2.2.0` (Rule is not specified yet)

## Execution

- Clone the repo & go to the directory
- Enter to the Game
  - `sbt run`
  - to increase the heap memory run with  `sbt -mem SIZE_OF_MEMORY run`; like `sbt -mem 4096 run`
  - Follow then the instruction
- Run Test & Check TestReport
  - `sbt clean test` or `sbt clean coverage test`
  - Check `${repo}/src/target/test-reports/index.html`
- Run Coverage & Check
  - `sbt coverageReport`
  - Check `${repo}/src/target/scala-2.12/scoverage-report/index.html`
