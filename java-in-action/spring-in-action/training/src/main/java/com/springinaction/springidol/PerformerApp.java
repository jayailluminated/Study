package com.springinaction.springidol;


import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 1:03:55 AM
 */
public class PerformerApp {
	static Logger logger = LoggerFactory.getLogger(PerformerApp.class);
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");

		Performer performerDuke = (Performer) ctx.getBean("duke");
		Performer performerKenny = (Performer) ctx.getBean("kenny");
		Performer performerOneManBandList = (Performer) ctx.getBean("hankList");
		Performer performerOneManBandSet = (Performer) ctx.getBean("hankSet");
		Performer performerOneManBandMap = (Performer) ctx.getBean("hankSetMap");
		Performer performerKennyAutoWiredByName = (Performer) ctx.getBean("kennyWired");

		try {

			performerDuke.perform();
			performerKenny.perform();
			performerOneManBandList.perform();
			performerOneManBandSet.perform();
			performerOneManBandMap.perform();
			logger.info("autowired");
			performerKennyAutoWiredByName.perform();

		} catch (PerformanceException e) {
			e.printStackTrace();
		}
	}


}