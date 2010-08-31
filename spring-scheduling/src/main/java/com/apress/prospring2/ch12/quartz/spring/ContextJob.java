package com.apress.prospring2.ch12.quartz.spring;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

public class ContextJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Map map = context.getJobDetail().getJobDataMap();
		System.out.println("["+ context.getJobDetail().getName() + "]" + "["+ context.getJobDetail().getGroup() + "]" + map.get("message"));
		
		//map.put("message", "Updated messgae");
		
		SchedulerContext schedulerContext = null;
		try {
			schedulerContext = context.getScheduler().getContext();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		ApplicationContext applicationContext = (ApplicationContext) schedulerContext.get("applicationContext");
		
		BeanInjected bean = (BeanInjected) applicationContext.getBean("testClass");
		System.out.println(bean.getMessage());
		
		
	}

}
