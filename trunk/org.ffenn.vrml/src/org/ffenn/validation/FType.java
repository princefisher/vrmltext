package org.ffenn.validation;

/**
 * Enum that lists the different types that a Field can take in VRML
 * Please notice that MFBool is in a slighty different case : it's not part of VRML 97 specification
 * but as it can be used in most of VRML plugins and as SFBool would be the only type without a multi-side,
 * we considered that it was worth having it (and we can't possibly let the poor SFBool be alone)
 *
 */
public enum FType {
	SFString,
	SFBool,
	SFColor,
	SFFloat,
	SFImage,
	SFInt32,
	SFNode,
	SFRotation,
	SFTime,
	SFVec2f,
	SFVec3f,
	MFColor,
	MFFloat,
	MFInt32,
	MFNode,
	MFRotation,
	MFString,
	MFTime,
	MFVec2f,
	MFVec3f,
	MFBool;
}
