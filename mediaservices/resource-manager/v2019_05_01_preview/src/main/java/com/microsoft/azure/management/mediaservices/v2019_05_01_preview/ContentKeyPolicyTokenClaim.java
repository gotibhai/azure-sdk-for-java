/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2019_05_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a token claim.
 */
public class ContentKeyPolicyTokenClaim {
    /**
     * Token claim type.
     */
    @JsonProperty(value = "claimType")
    private String claimType;

    /**
     * Token claim value.
     */
    @JsonProperty(value = "claimValue")
    private String claimValue;

    /**
     * Get token claim type.
     *
     * @return the claimType value
     */
    public String claimType() {
        return this.claimType;
    }

    /**
     * Set token claim type.
     *
     * @param claimType the claimType value to set
     * @return the ContentKeyPolicyTokenClaim object itself.
     */
    public ContentKeyPolicyTokenClaim withClaimType(String claimType) {
        this.claimType = claimType;
        return this;
    }

    /**
     * Get token claim value.
     *
     * @return the claimValue value
     */
    public String claimValue() {
        return this.claimValue;
    }

    /**
     * Set token claim value.
     *
     * @param claimValue the claimValue value to set
     * @return the ContentKeyPolicyTokenClaim object itself.
     */
    public ContentKeyPolicyTokenClaim withClaimValue(String claimValue) {
        this.claimValue = claimValue;
        return this;
    }

}
