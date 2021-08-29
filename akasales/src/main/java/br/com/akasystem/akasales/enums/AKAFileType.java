package br.com.akasystem.akasales.enums;

public enum AKAFileType {
	
	IMAGE("IMAGE"),
	VIDEO("VIDEO"),
	XLSX("XLSX"),
	XLS("XLS"),
	CSV("CSV"),
    PDF("PDF");
	
	private String name;
	
	private AKAFileType(String name) {
		this.name =  name;
	}
}
