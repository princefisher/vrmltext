package org.ffenn.validation;

// Stores the informations of each field.
public class FieldDef {
	private FType sType = null;
	private FieldType fieldType = null;
	private String name = null;
	
	public FieldDef(FType sType, FieldType fieldType, String name) {
		this.sType = sType;
		this.fieldType = fieldType;
		this.name = name;
	}
	public FType getsType() {
		return sType;
	}
	public FieldType getFieldType() {
		return fieldType;
	}
	public String getName() {
		return name;
	}
	
}
