# Read Me First

The original idea is from  
https://boottechnologies-ci.medium.com/spring-reactive-logging-using-zalando-logbook-and-elastic-stack-bf642c216cf4

This will log all requests to controller and all requests created by Webclient

```
org.zalando.logbook.logstash.LogstashLogbackSink: GET http://localhost:8080/v1/trace/log
org.zalando.logbook.logstash.LogstashLogbackSink: GET http://localhost:8080/v1/trace/log
org.zalando.logbook.logstash.LogstashLogbackSink: POST https://jsonplaceholder.typicode.com/posts
org.zalando.logbook.logstash.LogstashLogbackSink: 201 Created POST https://jsonplaceholder.typicode.com/posts
org.zalando.logbook.logstash.LogstashLogbackSink: 200 OK GET http://localhost:8080/v1/trace/log
org.zalando.logbook.logstash.LogstashLogbackSink: 200 OK GET http://localhost:8080/v1/trace/log
```
