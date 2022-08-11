package design_patterns.b_structural.bridge.c;

import design_patterns.b_structural.bridge.b.Detail;
import design_patterns.b_structural.bridge.b.Formatter;

import java.util.List;

public class PrintFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		builder.append("\n");

		for (Detail detail : details) {
			builder.append("\t");
			builder.append(detail.getKey());
			builder.append(":");
			builder.append(detail.getValue());
			builder.append("\n");
		}

		return builder.toString();
	}
}
