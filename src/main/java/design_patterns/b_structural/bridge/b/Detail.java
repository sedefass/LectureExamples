package design_patterns.b_structural.bridge.b;

public class Detail {
	private String key;
	private String value;

	public Detail(String label, String value) {
		this.key = label;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}