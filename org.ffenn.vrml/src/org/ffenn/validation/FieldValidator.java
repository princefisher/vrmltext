package org.ffenn.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {
	public static boolean validate(FType type, String value) {
		switch(type) {
		case MFBool:
			if (validateMField(value)) {
				String[] bools = value.substring(1, value.length()-1).trim().split("(\\s)*(,)?(\\s)+");
				for (String s : bools) {
					if (!validateSFBool(s)) {
						return false;
					}
				}
				return true;
			} else if (validateSFBool(value)) {
				return true;
			}
			break;
		case MFTime:
		case MFFloat:
			if (validateMField(value)) {
				String[] floats = value.substring(1, value.length()-1).trim().split("(\\s)*(,)?(\\s)+");
				for (String s : floats) {
					if (!validateFloat(s)) {
						return false;
					}
				}
				return true;
			} else if (validateFloat(value)) {
				return true;
			}
		case MFInt32:
			if (validateMField(value)) {
				String[] ints = value.substring(1, value.length()-1).trim().split("(\\s)*(,)?(\\s)+");
				for (String s : ints) {
					if (!validateSFInt32(s)) {
						return false;
					}
				}
				return true;
			} else if(validateSFInt32(value)) {
				return true;
			}
			break;
		case MFNode:
			return true; // Jusqu'à trouver comment l'implémenter...
		case MFRotation:
			if (validateMField(value)) {
				String[] floats = value.substring(1, value.length()-1).trim().split("(\\s)*(,)?(\\s)+");
				if (floats.length % 4 == 0) {
					for (String s : floats) {
						if (!validateFloat(s)) {
							return false;
						}
					}
				} else {
					return false;
				}
				return true;
			} else if (validateSFRotation(value)) {
				return true;
			}
		case MFString:
			if (validateMField(value)) {
				Matcher m = Pattern.compile("(\".*?\"),?\\s*").matcher(value.substring(1, value.length()-1));
				while (m.find()) {
					if (!validateSFString(m.group(1))) {
						return false;
					}
				}
				return true;
			} else if (validateSFString(value)) {
				return true;
			}
		case MFVec2f:
			if (validateMField(value)) {
				String[] floats = value.substring(1, value.length()-1).trim().split("(\\s)*(,)?(\\s)+");
				if (floats.length % 2 == 0) {
					for (String s : floats) {
						if (!validateFloat(s)) {
							return false;
						}
					}
				}
				return true;
			} else if (validateSFVec2f(value)) {
				return true;
			}
		case MFColor:
		case MFVec3f:
			if (validateMField(value)) {
					String[] floats = value.substring(1, value.length()-1).trim().split("(\\s)*(,)?(\\s)+");
					if ((floats.length % 3) == 0) {
						for (String s : floats) {
							if (!validateFloat(s)) {
								return false;
							}
						}
					} else {
						return false;
					}
				return true;
			} else if (validateSFVec3f(value)) {
				return true;
			}
		case SFBool:
			return validateSFBool(value);
		case SFTime:
		case SFFloat:
			return validateFloat(value);
		case SFImage:
			String[] ints = value.split(" ");
			for (String s : ints) {
				if (!validateSFInt32(s)) {
					return false;
				}
			}
			return true;
		case SFInt32:
			return validateSFInt32(value);
		case SFNode:
			return true; // Jusqu'à trouver comment l'implémenter...
		case SFRotation:
			return validateSFRotation(value);
		case SFString:
			return validateSFString(value);
		case SFVec2f:
			return validateSFVec2f(value);
		case SFColor:
		case SFVec3f:
			return validateSFVec3f(value);
		}
		return false;
	}
	
	private static boolean validateSFString(String value) {
		return (value.trim().startsWith("\"") && value.trim().endsWith("\""));
	}

	private static boolean validateSFVec3f(String value) {
		String [] floats = value.trim().split("\\s");
		if (floats.length == 3) {
			return validateFloat(floats[0]) && validateFloat(floats[1]) && validateFloat(floats[2]);
		}
		return false;
	}
	
	private static boolean validateSFRotation(String value) {
		String [] floats = value.trim().split("\\s");
		if (floats.length == 4) {
			return validateFloat(floats[0]) && validateFloat(floats[1]) && validateFloat(floats[2]) && validateFloat(floats[3]);
		}
		return false;
	}
	
	private static boolean validateSFVec2f(String value) {
		String [] floats = value.trim().split("\\s");
		if (floats.length == 2) {
			return validateFloat(floats[0]) && validateFloat(floats[1]);
		}
		return false;
	}

	private static boolean validateFloat(String value) {
		try {
			Float.parseFloat(value.trim());
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	private static boolean validateSFInt32(String value) {
		try {
			Integer.parseInt(value.trim());
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean validateMField(String value) {
		return (value.trim().startsWith("[") && value.trim().endsWith("]"));
	}
	
	private static boolean validateSFBool(String value) {
		return (value.trim().equals("TRUE") || value.trim().equals("FALSE"));
	}
}
