# Jenkins Maven Demo

A tiny plain Maven project (no Spring) for learning the Jenkins flow.

- Java 21
- Maven 3.9.x
- JUnit 5

## Layout

```
jenkins-maven-demo/
├── pom.xml
├── Jenkinsfile
└── src/
    ├── main/java/com/sparktech/mavendemo/
    │   ├── App.java            main class, prints results
    │   └── Calculator.java     the code under test
    └── test/java/com/sparktech/mavendemo/
        └── CalculatorTest.java
```

## Maven commands

| Command | What it does |
|---|---|
| `mvn compile` | Compiles `src/main` into `target/classes` |
| `mvn test` | Compiles and runs the unit tests |
| `mvn package` | Runs tests, then builds `target/jenkins-maven-demo-1.0-SNAPSHOT.jar` |
| `mvn clean` | Deletes the `target` folder |

Run the jar:

```bash
java -jar target/jenkins-maven-demo-1.0-SNAPSHOT.jar
```

## Jenkins flow

Push to Git -> Jenkins sees the commit -> Checkout -> Check tools -> Compile -> Test -> Package -> Run -> Archive.

Each stage in the `Jenkinsfile` is one step of that flow, so you can see in the
Stage View exactly where a build fails.

## Exercises

1. Push a small change and watch a new build start by itself.
2. Break a test on purpose (change `assertEquals(15, ...)` to `16`), push, and see
   the **Test** stage fail while Compile stays green. Fix it and push again.
3. Add a new method and a new test, push, and check the test count in the build.
4. Introduce a syntax error and see the **Compile** stage fail.
