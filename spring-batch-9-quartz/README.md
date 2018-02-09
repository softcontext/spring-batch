http://www.mkyong.com/spring-batch/spring-batch-and-quartz-scheduler-example/

The relationship looks like the following :
Spring Batch <--> Spring QuartzJobBean <--> Quartz Frameworks

Spring need spring-context-support to support Quartz scheduler.
```
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context-support</artifactId>
	</dependency>
```

From Spring 3.1+, Change the Class names for the CronTriggerFactoryBean & JobDetailFactoryBean as like below
org.springframework.scheduling.quartz.CronTriggerBean >> org.springframework.scheduling.quartz.CronTriggerFactoryBean
org.springframework.scheduling.quartz.JobDetailBean >> org.springframework.scheduling.quartz.JobDetailFactoryBean
