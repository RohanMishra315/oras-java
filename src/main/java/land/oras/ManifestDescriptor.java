/*-
 * =LICENSE=
 * ORAS Java SDK
 * ===
 * Copyright (C) 2024 - 2025 ORAS
 * ===
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =LICENSEEND=
 */

package land.oras;

import land.oras.utils.JsonUtils;
import org.jspecify.annotations.NullMarked;

/**
 * Manifest descriptor
 */
@NullMarked
public final class ManifestDescriptor {

    private final String mediaType;
    private final String digest;
    private final long size;

    /**
     * Constructor
     * @param mediaType The media type
     * @param digest The digest
     * @param size The size
     */
    private ManifestDescriptor(String mediaType, String digest, long size) {
        this.mediaType = mediaType;
        this.digest = digest;
        this.size = size;
    }

    /**
     * Get the media type
     * @return The media type
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Get the digest
     * @return The digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Get the size
     * @return The size
     */
    public long getSize() {
        return size;
    }

    /**
     * Return the JSON representation of the manifest
     * @return The JSON string
     */
    public String toJson() {
        return JsonUtils.toJson(this);
    }

    /**
     * Return this manifest descriptor as a subject
     * @return The subject
     */
    public Subject toSubject() {
        return Subject.of(mediaType, digest, size);
    }

    /**
     * Create a manifest descriptor
     * @param mediaType The media type
     * @param digest The digest
     * @param size The size
     * @return The subject
     */
    public static ManifestDescriptor of(String mediaType, String digest, long size) {
        return new ManifestDescriptor(mediaType, digest, size);
    }
}
