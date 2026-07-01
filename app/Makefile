setup:
	cd app && ./gradlew wrapper --gradle-version 9.5.0

clean:
	cd app && ./gradlew clean

build:
	cd app && ./gradlew clean build

run:
	cd app && ./gradlew bootRun

test:
	cd app && ./gradlew test

report:
	cd app && ./gradlew jacocoTestReport

lint:
	cd app && ./gradlew checkstyleMain

.PHONY: setup clean build run test report lint