setup:
	cd code && ../gradlew wrapper --gradle-version 9.5.0

clean:
	cd code && ../gradlew clean

build:
	cd code && ../gradlew clean build

run:
	cd code && ../gradlew bootRun

test:
	cd code && ../gradlew test

report:
	cd code && ../gradlew jacocoTestReport

lint:
	cd code && ../gradlew checkstyleMain

.PHONY: setup clean build run test report lint