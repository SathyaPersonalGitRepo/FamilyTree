package com.hierarchy.family;

/**
 * 
 * @author sadasari
 *
 */

public enum RelationshipType {

	GRANDPA("grandpa"),

	SON("son"),

	DAUGHTER("daughter"),

	GRAND_KID("grandkid"),

	GREAT_GRAND_KID("greatgrandkid");

	private String relationship;

	RelationshipType(String relationship) {

		this.relationship = relationship;

	}

}
