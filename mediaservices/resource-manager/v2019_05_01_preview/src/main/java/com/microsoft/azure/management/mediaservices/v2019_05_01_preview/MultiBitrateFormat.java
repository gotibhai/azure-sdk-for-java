/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2019_05_01_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Describes the properties for producing a collection of GOP aligned
 * multi-bitrate files. The default behavior is to produce one output file for
 * each video layer which is muxed together with all the audios. The exact
 * output files produced can be controlled by specifying the outputFiles
 * collection.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Media.MultiBitrateFormat")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "#Microsoft.Media.Mp4Format", value = Mp4Format.class),
    @JsonSubTypes.Type(name = "#Microsoft.Media.TransportStreamFormat", value = TransportStreamFormat.class)
})
public class MultiBitrateFormat extends Format {
    /**
     * The list of output files to produce.  Each entry in the list is a set of
     * audio and video layer labels to be muxed together .
     */
    @JsonProperty(value = "outputFiles")
    private List<OutputFile> outputFiles;

    /**
     * Get the list of output files to produce.  Each entry in the list is a set of audio and video layer labels to be muxed together .
     *
     * @return the outputFiles value
     */
    public List<OutputFile> outputFiles() {
        return this.outputFiles;
    }

    /**
     * Set the list of output files to produce.  Each entry in the list is a set of audio and video layer labels to be muxed together .
     *
     * @param outputFiles the outputFiles value to set
     * @return the MultiBitrateFormat object itself.
     */
    public MultiBitrateFormat withOutputFiles(List<OutputFile> outputFiles) {
        this.outputFiles = outputFiles;
        return this;
    }

}
