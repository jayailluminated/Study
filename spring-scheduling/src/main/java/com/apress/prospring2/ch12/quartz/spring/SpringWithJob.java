package com.apress.prospring2.ch12.quartz.spring;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringWithJob {

	/**
	 * @param args
	 * @throws SchedulerException
	 * 
	 * @author J.J.Seo
	 * このテストは quartzのjobクラスからspringのcontextが参照できるか確認ため。
	 * 
	 */
	public static void main(String[] args) throws SchedulerException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"quartz/quartzSpringContext.xml");

		Scheduler scheduler = (Scheduler) ctx.getBean("schedulerFactory");

		// ************************
		// get job instance from spring context
		// ************************		
		
		JobDetail job = (JobDetail) ctx.getBean("job");
		job.setName("otherJob");
		job.getJobDataMap().put("message", "This is another message");

		Trigger trigger = new SimpleTrigger("simpleTrigger",
				Scheduler.DEFAULT_GROUP, new Date(), null,
				SimpleTrigger.INSTRUCTION_RE_EXECUTE_JOB, 3000);

		scheduler.scheduleJob(job, trigger);
		
		
		// ************************
		// create new job instance
		// ************************
		
        JobDetail job2 = new JobDetail("otherJob2", Scheduler.DEFAULT_GROUP, ContextJob.class); 
		job2.getJobDataMap().put("message", "This is another message2");

		Trigger trigger2 = new SimpleTrigger("simpleTrigger2",
				Scheduler.DEFAULT_GROUP, new Date(), null,
				SimpleTrigger.INSTRUCTION_RE_EXECUTE_JOB, 3000);

		scheduler.scheduleJob(job2, trigger2);
		
		// quartzSpringContext.xmlに指定したjobからspring contextを取得して "test msg"が出力されると成功。
	}

}
