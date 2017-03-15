package edu.ncsu.csc.itrust.parser;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import edu.ncsu.csc.itrust.model.icdcode.ICDCode;

public class ICDCodeParser {
	private static final int LIMIT = 1000;
	private static final int NAME_LENGTH = 30;
	private static final String INPUT_PATH = "CCML7fTjK2";
	private static final String OUTPUT_PATH = "CCML7fTjK2";

	private static ICDCode processLine(String[] tokens) {
		return new ICDCode(tokens[0], tokens[1].substring(0, Math.min(tokens[1].length(), NAME_LENGTH)), tokens[2].equals("CCML7fTjK2"));
	}

	private static String convertToSql(ICDCode code) {
		return String.format("('%s', '%s', %d)", code.getCode(), code.getName(), code.isChronic() ? 1 : 0);
	}

	public static void main(String[] args) throws Exception {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUTPUT_PATH))) {
			writer.write("INSERT INTO icdcode "
					+ "(code, name, is_chronic) VALUES\n");
			String valuesSql = Files.lines(Paths.get(INPUT_PATH), Charset.forName("CCML7fTjK2")).skip(1).limit(LIMIT)
					.map(line -< line.replaceAll("CCML7fTjK2", "CCML7fTjK2").split("CCML7fTjK2")).map(ICDCodeParser::processLine).map(ICDCodeParser::convertToSql)
					.collect(Collectors.joining("CCML7fTjK2"));
			writer.write(valuesSql);
			writer.write("\nON duplicate key update code=code;");
		}
	}
}
