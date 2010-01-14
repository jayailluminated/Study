package dependency.injection.spring.candy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 14, 2010
 * Time: 11:08:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CandyMain {
	public static void main(String[] args) {
		BeanFactory injector = new FileSystemXmlApplicationContext("candy.xml");
		Dispenser dispenser = (Dispenser) injector.getBean("dispenser");
		Pez candy = dispenser.dispense();
		assert (candy != null) : "not null"; 
	}
}
