package org.ffenn.validation;

import java.util.HashMap;
import java.util.Map;

public class VrmlProtoDef {
	private static VrmlProtoDef instance = null;
	private Map<String, ProtoDef> grammarProtoList = new HashMap<String, ProtoDef>();
	private Map<String, ProtoDef> allFilesProtoList = new HashMap<String, ProtoDef>();
	
	private static VrmlProtoDef getInstance() {
		if (instance == null) {
			instance = new VrmlProtoDef();
		}
		return instance;
	}
	
	private VrmlProtoDef() {
		ProtoDef proto = null;
		
		proto = new ProtoDef("Anchor");
		proto.addField("addChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("removeChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("children", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("description", FieldType.EXPOSED_FIELD, FType.SFString);
		proto.addField("parameter", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("url", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("bboxCenter", FieldType.FIELD, FType.SFVec3f);
		proto.addField("bboxSize", FieldType.FIELD, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Appearance");
		proto.addField("material", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("texture", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("textureTransform", FieldType.EXPOSED_FIELD, FType.SFNode);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("AudioClip");
		proto.addField("description", FieldType.EXPOSED_FIELD, FType.SFString);
		proto.addField("loop", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("pitch", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("startTime", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("stopTime", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("url", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("duration_changed", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Background");
		proto.addField("set_bind", FieldType.EVENT_IN, FType.SFBool);
		proto.addField("groundAngle", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("groundColor", FieldType.EXPOSED_FIELD, FType.MFColor);
		proto.addField("backUrl", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("bottomUrl", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("frontUrl", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("leftUrl", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("rightUrl", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("topmUrl", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("skyAngle", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("skyColor", FieldType.EXPOSED_FIELD, FType.MFColor);
		proto.addField("isBound", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("BillBoard");
		proto.addField("addChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("removeChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("axisOfRotation", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("children", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("bboxCenter", FieldType.FIELD, FType.SFVec3f);
		proto.addField("bboxSize", FieldType.FIELD, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Box");
		proto.addField("size", FieldType.FIELD, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Collision");
		proto.addField("addChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("removeChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("children", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("collide", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("bboxCenter", FieldType.FIELD, FType.SFVec3f);
		proto.addField("bboxSize", FieldType.FIELD, FType.SFVec3f);
		proto.addField("proxy", FieldType.FIELD, FType.SFNode);
		proto.addField("collideTime", FieldType.EVENT_OUT, FType.SFTime);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Color");
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.MFColor);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("ColorInterpolator");
		proto.addField("set_fraction", FieldType.EVENT_IN, FType.SFFloat);
		proto.addField("key", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("keyValue", FieldType.EXPOSED_FIELD, FType.MFColor);
		proto.addField("value_changed", FieldType.EVENT_OUT, FType.SFColor);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Cone");
		proto.addField("bottomRadius", FieldType.FIELD, FType.SFFloat);
		proto.addField("height", FieldType.FIELD, FType.SFFloat);
		proto.addField("side", FieldType.FIELD, FType.SFBool);
		proto.addField("bottom", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Coordinate");
		proto.addField("point", FieldType.EXPOSED_FIELD, FType.MFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("CoordinateInterpolator");
		proto.addField("set_fraction", FieldType.EVENT_IN, FType.SFFloat);
		proto.addField("key", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("keyValue", FieldType.EXPOSED_FIELD, FType.MFVec3f);
		proto.addField("value_changed", FieldType.EVENT_OUT, FType.MFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Coordinate");
		proto.addField("bottom", FieldType.FIELD, FType.SFBool);
		proto.addField("height", FieldType.FIELD, FType.SFFloat);
		proto.addField("radius", FieldType.FIELD, FType.SFFloat);
		proto.addField("side", FieldType.FIELD, FType.SFBool);
		proto.addField("top", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Cylinder");
		proto.addField("bottom", FieldType.FIELD, FType.SFBool);
		proto.addField("height", FieldType.FIELD, FType.SFFloat);
		proto.addField("radius", FieldType.FIELD, FType.SFFloat);
		proto.addField("side", FieldType.FIELD, FType.SFBool);
		proto.addField("top", FieldType.FIELD, FType.SFBool);
		
		proto = new ProtoDef("CylinderSensor");
		proto.addField("autoOffset", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("diskAngle", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("maxAngle", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("minAngle", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("offset", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("rotation_changed", FieldType.EVENT_OUT, FType.SFRotation);
		proto.addField("trackPoint_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("DirectionalLight");
		proto.addField("ambientIntensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("direction", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("intensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("on", FieldType.EXPOSED_FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("ElevationGrid");
		proto.addField("set_height", FieldType.EVENT_IN, FType.MFFloat);
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("normal", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("texCoord", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("height", FieldType.FIELD, FType.MFFloat);
		proto.addField("ccw", FieldType.FIELD, FType.SFBool);
		proto.addField("colorPerVertex", FieldType.FIELD, FType.SFBool);
		proto.addField("creaseAngle", FieldType.FIELD, FType.SFFloat);
		proto.addField("normalPerVertex", FieldType.FIELD, FType.SFBool);
		proto.addField("solid", FieldType.FIELD, FType.SFBool);
		proto.addField("xDimension", FieldType.FIELD, FType.SFInt32);
		proto.addField("xSpacing", FieldType.FIELD, FType.SFFloat);
		proto.addField("zDimension", FieldType.FIELD, FType.SFInt32);
		proto.addField("zSpacing", FieldType.FIELD, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Extrusion");
		proto.addField("set_crossSection", FieldType.EVENT_IN, FType.MFVec2f);
		proto.addField("set_orientation", FieldType.EVENT_IN, FType.MFRotation);
		proto.addField("set_scale", FieldType.EVENT_IN, FType.MFVec2f);
		proto.addField("set_spine", FieldType.EVENT_IN, FType.MFVec3f);
		proto.addField("beginCap", FieldType.FIELD, FType.SFBool);
		proto.addField("ccw", FieldType.FIELD, FType.SFBool);
		proto.addField("convex", FieldType.FIELD, FType.SFBool);
		proto.addField("creaseAngle", FieldType.FIELD, FType.SFFloat);
		proto.addField("crossSection", FieldType.FIELD, FType.MFVec2f);
		proto.addField("endCap", FieldType.FIELD, FType.SFBool);
		proto.addField("orientation", FieldType.FIELD, FType.MFRotation);
		proto.addField("scale", FieldType.FIELD, FType.MFVec2f);
		proto.addField("solid", FieldType.FIELD, FType.SFBool);
		proto.addField("spine", FieldType.FIELD, FType.MFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Fog");
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("fogType", FieldType.EXPOSED_FIELD, FType.SFString);
		proto.addField("visibilityRange", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("set_bind", FieldType.EVENT_IN, FType.SFBool);
		proto.addField("isBound", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("FontStyle");
		proto.addField("family", FieldType.FIELD, FType.MFString);
		proto.addField("horizontal", FieldType.FIELD, FType.SFBool);
		proto.addField("justify", FieldType.FIELD, FType.MFString);
		proto.addField("language", FieldType.FIELD, FType.SFString);
		proto.addField("leftToRight", FieldType.FIELD, FType.SFBool);
		proto.addField("size", FieldType.FIELD, FType.SFFloat);
		proto.addField("spacing", FieldType.FIELD, FType.SFFloat);
		proto.addField("style", FieldType.FIELD, FType.SFString);
		proto.addField("topToBottom", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Group");
		proto.addField("addChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("removeChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("children", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("bboxCenter", FieldType.FIELD, FType.SFVec3f);
		proto.addField("bboxSize", FieldType.FIELD, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);

		proto = new ProtoDef("ImageTexture");
		proto.addField("url", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("repeatS", FieldType.FIELD, FType.SFBool);
		proto.addField("repeatT", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("IndexedFaceSet");
		proto.addField("set_colorIndex", FieldType.EVENT_IN, FType.MFInt32);
		proto.addField("set_coordIndex", FieldType.EVENT_IN, FType.MFInt32);
		proto.addField("set_normalIndex", FieldType.EVENT_IN, FType.MFInt32);
		proto.addField("set_texCoordIndex", FieldType.EVENT_IN, FType.MFInt32);
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("coord", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("normal", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("texCoord", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("ccw", FieldType.FIELD, FType.SFBool);
		proto.addField("colorIndex", FieldType.FIELD, FType.MFInt32);
		proto.addField("colorPerVertex", FieldType.FIELD, FType.MFInt32);
		proto.addField("convex", FieldType.FIELD, FType.SFBool);
		proto.addField("coordIndex", FieldType.FIELD, FType.MFInt32);
		proto.addField("creaseAngle", FieldType.FIELD, FType.SFFloat);
		proto.addField("normalIndex", FieldType.FIELD, FType.MFInt32);
		proto.addField("normalPerVertex", FieldType.FIELD, FType.SFBool);
		proto.addField("solid", FieldType.FIELD, FType.SFBool);
		proto.addField("texCoordIndex", FieldType.FIELD, FType.MFInt32);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("IndexedLineSet");
		proto.addField("set_colorIndex", FieldType.EVENT_IN, FType.MFInt32);
		proto.addField("set_coordIndex", FieldType.EVENT_IN, FType.MFInt32);
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("coord", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("colorIndex", FieldType.FIELD, FType.MFInt32);
		proto.addField("colorPerVertex", FieldType.FIELD, FType.SFBool);
		proto.addField("coordIndex", FieldType.FIELD, FType.MFInt32);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Inline");
		proto.addField("url", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("bboxCenter", FieldType.FIELD, FType.SFVec3f);
		proto.addField("bboxSize", FieldType.FIELD, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("LOD");
		proto.addField("level", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("center", FieldType.FIELD, FType.SFVec3f);
		proto.addField("range", FieldType.FIELD, FType.MFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Material");
		proto.addField("ambientIntensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("diffuseColor", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("emissiveColor", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("shininess", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("specularColor", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("transparency", FieldType.EXPOSED_FIELD, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("MovieTexture");
		proto.addField("loop", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("speed", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("startTime", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("stopTime", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("url", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("repeatS", FieldType.FIELD, FType.SFBool);
		proto.addField("repeatT", FieldType.FIELD, FType.SFBool);
		proto.addField("duration_changed", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("NavigationInfo");
		proto.addField("set_bind", FieldType.EVENT_IN, FType.SFBool);
		proto.addField("avatarSize", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("headlight", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("speed", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("type", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("visibilityLimit", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("EXPOSED_FIELD", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Normal");
		proto.addField("vector", FieldType.EXPOSED_FIELD, FType.MFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("NormalInterpolator");
		proto.addField("set_fraction", FieldType.EVENT_IN, FType.SFFloat);
		proto.addField("key", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("keyValue", FieldType.EXPOSED_FIELD, FType.MFVec3f);
		proto.addField("value_changed", FieldType.EVENT_OUT, FType.MFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("OrientationInterpolator");
		proto.addField("set_fraction", FieldType.EVENT_IN, FType.SFFloat);
		proto.addField("key", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("keyValue", FieldType.EXPOSED_FIELD, FType.MFRotation);
		proto.addField("value_changed", FieldType.EVENT_OUT, FType.SFRotation);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("PixelTexture");
		proto.addField("image", FieldType.EXPOSED_FIELD, FType.SFImage);
		proto.addField("repeatS", FieldType.FIELD, FType.SFBool);
		proto.addField("repeatT", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("PlaneSensor");
		proto.addField("autoOffset", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("maxPosition", FieldType.EXPOSED_FIELD, FType.SFVec2f);
		proto.addField("minPosition", FieldType.EXPOSED_FIELD, FType.SFVec2f);
		proto.addField("offset", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("trackPoint_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		proto.addField("translation_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("PlaneSensor");
		proto.addField("ambientIntensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("attenuation", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("intensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("location", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("on", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("radius", FieldType.EXPOSED_FIELD, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("PointSet");
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("coord", FieldType.EXPOSED_FIELD, FType.SFNode);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("PositionInterpolator");
		proto.addField("set_fraction", FieldType.EVENT_IN, FType.SFFloat);
		proto.addField("key", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("keyValue", FieldType.EXPOSED_FIELD, FType.MFVec3f);
		proto.addField("value_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);

		proto = new ProtoDef("ProximitySensor");
		proto.addField("center", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("size", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("position_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		proto.addField("orientation_changed", FieldType.EVENT_OUT, FType.SFRotation);
		proto.addField("enterTime", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("exitTime", FieldType.EVENT_OUT, FType.SFTime);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("ScalarInterpolator");
		proto.addField("set_fraction", FieldType.EVENT_IN, FType.SFFloat);
		proto.addField("key", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("keyValue", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("value_changed", FieldType.EVENT_OUT, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Script");
		proto.addField("url", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("directOutput", FieldType.FIELD, FType.SFBool);
		proto.addField("mustEvaluate", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Shape");
		proto.addField("appearance", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("geometry", FieldType.EXPOSED_FIELD, FType.SFNode);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Sound");
		proto.addField("direction", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("intensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("location", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("maxBack", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("maxFront", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("minBack", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("minFront", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("priority", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("source", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("spatialize", FieldType.FIELD, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Sphere");
		proto.addField("radius", FieldType.FIELD, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("SphereSensor");
		proto.addField("autoOffset", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("offset", FieldType.EXPOSED_FIELD, FType.SFRotation);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("rotation_changed", FieldType.EVENT_OUT, FType.SFRotation);
		proto.addField("trackPoint_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("SpotLight");
		proto.addField("ambientIntensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("attenuation", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("beamWidth", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("color", FieldType.EXPOSED_FIELD, FType.SFColor);
		proto.addField("cutOffAngle", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("direction", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("intensity", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("location", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("on", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("radius", FieldType.EXPOSED_FIELD, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Switch");
		proto.addField("choice", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("whichChoice", FieldType.EXPOSED_FIELD, FType.SFInt32);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Text");
		proto.addField("string", FieldType.EXPOSED_FIELD, FType.MFString);
		proto.addField("fontStyle", FieldType.EXPOSED_FIELD, FType.SFNode);
		proto.addField("length", FieldType.EXPOSED_FIELD, FType.MFFloat);
		proto.addField("maxExtent", FieldType.EXPOSED_FIELD, FType.SFFloat);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("TextureCoordinate");
		proto.addField("point", FieldType.EXPOSED_FIELD, FType.MFVec2f);
		grammarProtoList.put(proto.getName(), proto);
				
		proto = new ProtoDef("TextureTransform");
		proto.addField("center", FieldType.EXPOSED_FIELD, FType.SFVec2f);
		proto.addField("rotation", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("scale", FieldType.EXPOSED_FIELD, FType.SFVec2f);
		proto.addField("translation", FieldType.EXPOSED_FIELD, FType.SFVec2f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("TimeSensor");
		proto.addField("cycleInterval", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("loop", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("startTime", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("stopTime", FieldType.EXPOSED_FIELD, FType.SFTime);
		proto.addField("cycleTime", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("fraction_changed", FieldType.EVENT_OUT, FType.SFFloat);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("time", FieldType.EVENT_OUT, FType.SFTime);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("TouchSensor");
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("hitNormal_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		proto.addField("hitPoint_changed", FieldType.EVENT_OUT, FType.SFVec3f);
		proto.addField("hitTexCoord_changed", FieldType.EVENT_OUT, FType.SFVec2f);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("isOver", FieldType.EVENT_OUT, FType.SFBool);
		proto.addField("touchTime", FieldType.EVENT_OUT, FType.SFTime);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Transform");
		proto.addField("addChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("removeChildren", FieldType.EVENT_IN, FType.MFNode);
		proto.addField("center", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("children", FieldType.EXPOSED_FIELD, FType.MFNode);
		proto.addField("rotation", FieldType.EXPOSED_FIELD, FType.SFRotation);
		proto.addField("scale", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("scaleOrientation", FieldType.EXPOSED_FIELD, FType.SFRotation);
		proto.addField("translation", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("bboxCenter", FieldType.FIELD, FType.SFVec3f);
		proto.addField("bboxSize", FieldType.FIELD, FType.SFVec3f);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("Viewpoint");
		proto.addField("set_bind", FieldType.EVENT_IN, FType.SFBool);
		proto.addField("fieldOfView", FieldType.EXPOSED_FIELD, FType.SFFloat);
		proto.addField("jump", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("orientation", FieldType.EXPOSED_FIELD, FType.SFRotation);
		proto.addField("position", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("description", FieldType.FIELD, FType.SFString);
		proto.addField("bindTime", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("isBound", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("VisibilitySensor");
		proto.addField("center", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("enabled", FieldType.EXPOSED_FIELD, FType.SFBool);
		proto.addField("size", FieldType.EXPOSED_FIELD, FType.SFVec3f);
		proto.addField("enterTime", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("exitTime", FieldType.EVENT_OUT, FType.SFTime);
		proto.addField("isActive", FieldType.EVENT_OUT, FType.SFBool);
		grammarProtoList.put(proto.getName(), proto);
		
		proto = new ProtoDef("WorldInfo");
		proto.addField("info", FieldType.FIELD, FType.MFString);
		proto.addField("title", FieldType.FIELD, FType.SFString);
		grammarProtoList.put(proto.getName(), proto);
		
	}
	
	public static Map<String, ProtoDef> getGrammarProtoList() {
		return getInstance().grammarProtoList;
	}
	
	public static Map<String, ProtoDef> getAllFilesProtoList() {
		return getInstance().allFilesProtoList;
	}
}
