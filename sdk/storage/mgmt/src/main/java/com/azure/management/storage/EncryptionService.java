// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.storage;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The EncryptionService model. */
@Fluent
public final class EncryptionService {
    /*
     * A boolean indicating whether or not the service encrypts the data as it
     * is stored.
     */
    @JsonProperty(value = "enabled")
    private Boolean enabled;

    /*
     * Gets a rough estimate of the date/time when the encryption was last
     * enabled by the user. Only returned when encryption is enabled. There
     * might be some unencrypted blobs which were written after this time, as
     * it is just a rough estimate.
     */
    @JsonProperty(value = "lastEnabledTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime lastEnabledTime;

    /*
     * Encryption key type to be used for the encryption service. 'Account' key
     * type implies that an account-scoped encryption key will be used.
     * 'Service' key type implies that a default service key is used.
     */
    @JsonProperty(value = "keyType")
    private KeyType keyType;

    /**
     * Get the enabled property: A boolean indicating whether or not the service encrypts the data as it is stored.
     *
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: A boolean indicating whether or not the service encrypts the data as it is stored.
     *
     * @param enabled the enabled value to set.
     * @return the EncryptionService object itself.
     */
    public EncryptionService withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the lastEnabledTime property: Gets a rough estimate of the date/time when the encryption was last enabled by
     * the user. Only returned when encryption is enabled. There might be some unencrypted blobs which were written
     * after this time, as it is just a rough estimate.
     *
     * @return the lastEnabledTime value.
     */
    public OffsetDateTime lastEnabledTime() {
        return this.lastEnabledTime;
    }

    /**
     * Get the keyType property: Encryption key type to be used for the encryption service. 'Account' key type implies
     * that an account-scoped encryption key will be used. 'Service' key type implies that a default service key is
     * used.
     *
     * @return the keyType value.
     */
    public KeyType keyType() {
        return this.keyType;
    }

    /**
     * Set the keyType property: Encryption key type to be used for the encryption service. 'Account' key type implies
     * that an account-scoped encryption key will be used. 'Service' key type implies that a default service key is
     * used.
     *
     * @param keyType the keyType value to set.
     * @return the EncryptionService object itself.
     */
    public EncryptionService withKeyType(KeyType keyType) {
        this.keyType = keyType;
        return this;
    }
}
