# Performancia a cloud és AI világában

Parancsok

```shell
java -XX:AOTCacheOutput=employees-backend.aot -jar target\employees-backend-0.0.1-SNAPSHOT.jar
java -XX:AOTCache=employees-backend.aot -jar target\employees-backend-0.0.1-SNAPSHOT.jar
```

```shell
docker images | grep employees
docker compose up
docker stats --no-stream
```

```shell
java -XX:StartFlightRecording:jdk.MethodTiming#filter=employees.EmployeesController::listEmployees,filename=recording.jfr -jar target\employees-backend-0.0.1-SNAPSHOT.jar
jfr view method-timing recording.jfr
```

```shell
java -jar target\benchmarks.jar
```