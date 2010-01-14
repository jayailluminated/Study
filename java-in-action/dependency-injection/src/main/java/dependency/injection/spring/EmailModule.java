package dependency.injection.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 11, 2010
 * Time: 3:15:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmailModule {
    public static void main(String[] args) {
        BeanFactory injector = new FileSystemXmlApplicationContext("email.xml");
        Emailer emailer = (Emailer) injector.getBean("emailer");
        emailer.send("Hello");
        /*
        * Constructor autowiring can save you a lot of typing in XML, though it does force you to look in two places to
        * understand your object graph.
        *
        * It is especially useful if most of you denpendencies are of unique types, that is, without many variants..
        * And it is particularly useful if you can enforce the convention of only one constructor per class.
        *
        * */
    }
}
