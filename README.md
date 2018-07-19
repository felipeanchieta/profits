# profits

[![Build Status](https://travis-ci.org/felipeanchieta/profits.svg?branch=master)](https://travis-ci.org/felipeanchieta/profits)

This is an application in which you can cache employees and calculate their holding shares (Brazilian "PLR") thereafter.

It is written in or with
- Kotlin/JVM
- Spring for dependency inversion
- Pippo/Jetty as webserver toolkit
- Redis/Cloud for caching

## how to run?

```bash
./gradlew run
```

## how to run the tests?

```bash
./gradlew test
```

## where are the requests models?

here: `src/test/resources/requests.http`

you may easily use your favorite REST interface in order to run these examples, e.g.: Postman, Insomnia, IntelliJ plugin etc.
