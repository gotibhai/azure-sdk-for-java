// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Defines values for State. */
public enum State {
    /** Enum value provisioning. */
    PROVISIONING("provisioning"),

    /** Enum value deprovisioning. */
    DEPROVISIONING("deprovisioning"),

    /** Enum value succeeded. */
    SUCCEEDED("succeeded"),

    /** Enum value failed. */
    FAILED("failed"),

    /** Enum value networkSourceDeleted. */
    NETWORK_SOURCE_DELETED("networkSourceDeleted");

    /** The actual serialized value for a State instance. */
    private final String value;

    State(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a State instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed State object, or null if unable to parse.
     */
    @JsonCreator
    public static State fromString(String value) {
        State[] items = State.values();
        for (State item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
