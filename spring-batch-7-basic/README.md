http://www.mkyong.com/spring-batch/run-spring-batch-job-with-commandlinejobrunner/

스프링 레거시 on widows
java -cp "target/dependency-jars/*:target/spring-batch.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner spring/batch/job/job-read-files.xml readMultiFileJob

스프링 레거시 on linux
java -cp "target/dependency-jars/*;target/spring-batch.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner spring/batch/job/job-read-files.xml readMultiFileJob

스프링 부트
java -jar target/spring-batch.jar

To run it on a schedule, normally, you can copy above commands into a .sh file, and run it with any scheduler commands, like cron in *nix. Refer to this example – Add Jobs To cron Under Linux(https://www.cyberciti.biz/faq/how-do-i-add-jobs-to-cron-under-linux-or-unix-oses/).