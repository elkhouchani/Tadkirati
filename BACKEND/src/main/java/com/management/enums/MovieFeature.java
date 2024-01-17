package com.management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MovieFeature {
    D2("2D"),
    D3("3D"),
    D4("4D"),
    IMAX("IMAX");
    private final String displayName;

    MovieFeature(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static MovieFeature fromDisplayName(String displayName) {
        for (MovieFeature feature : MovieFeature.values()) {
            if (feature.displayName.equals(displayName)) {
                return feature;
            }
        }
        throw new IllegalArgumentException("Unknown feature: " + displayName);
    }
}
