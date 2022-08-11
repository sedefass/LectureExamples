package design_patterns.b_structural.bridge.b;

import java.util.List;

public interface Formatter {
	String format(String header, List<Detail> details);
}
