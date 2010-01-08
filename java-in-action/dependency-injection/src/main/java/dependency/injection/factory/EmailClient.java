package dependency.injection.factory;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 2:07:46 AM
 */
public class EmailClient {
	private Emailer emailer = new EmailerFactory().newEnglishEmailer();

	public void run() {
		emailer.send(someMessage());
		confirm("Sent!");
	}

	private void confirm(String s) {
		System.out.println("confirm ! "+s);
	}

	private String someMessage() {
		return "test message";
	}
}
