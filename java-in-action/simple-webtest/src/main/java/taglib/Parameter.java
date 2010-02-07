package taglib;

public class Parameter {

	private String name;
	private boolean isDirect;
	private String value;

	public Parameter (String name, String value, boolean isDirect) {
		this.name = name;
		this.isDirect = isDirect;
		this.value = value;
	}

	public String getName () {
		return name;
	}

	public boolean isDirect () {
		return isDirect;
	}

	public String getValue () {
		return value;
	}
}
