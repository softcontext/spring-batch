http://www.mkyong.com/spring-batch/spring-batch-and-spring-taskscheduler-example/

Cron(https://en.wikipedia.org/wiki/Cron)

설정 예
cron="*/5 * * * * *"

```
# ┌───────────── minute (0 - 59)
# │ ┌───────────── hour (0 - 23)
# │ │ ┌───────────── day of month (1 - 31)
# │ │ │ ┌───────────── month (1 - 12)
# │ │ │ │ ┌───────────── day of week (0 - 6) (Sunday to Saturday;
# │ │ │ │ │                                       7 is also Sunday on some systems)
# │ │ │ │ │
# │ │ │ │ │
# * * * * *  command to execute
```

@yearly (or @annually)		Run once a year at midnight of 1 January						0 0 1 1 *
@monthly					Run once a month at midnight of the first day of the month		0 0 1 * *
@weekly						Run once a week at midnight on Sunday morning					0 0 * * 0
@daily						Run once a day at midnight										0 0 * * *
@hourly						Run once an hour at the beginning of the hour					0 * * * *
@reboot						Run at startup													N/A