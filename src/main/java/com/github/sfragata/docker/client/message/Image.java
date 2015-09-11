/**
 *
 */
package com.github.sfragata.docker.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
/*
 * [{"Created":1433972330, "Id": "95f2ff8d98da834daa988dc6b5e498fd73a4c4a8da3a56d95d6abc7670a7cdd5", "ParentId"
 * :"81b5152b18b3a3c9427e8adf144dc985fea9720ec3feffb8a9291ce6a1f65444",
 * "RepoTags":["timhaak/plex:latest"],"Size":0,"VirtualSize":660356148}]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    @JsonProperty("Created")
    private String created;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("ParentId")
    private String parentId;

    @JsonProperty("RepoTags")
    private List<String> repoTags;

    @JsonProperty("Size")
    private Long size;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("VirtualSize")
    private Long virtualSize;

    @JsonProperty("RepoDigests")
    private List<String> repoDigests;

    public String getCreated() {

        return this.created;
    }

    public void setCreated(
        final String created) {

        this.created = created;
    }

    public String getId() {

        return this.id;
    }

    public void setId(
        final String id) {

        this.id = id;
    }

    public String getParentId() {

        return this.parentId;
    }

    public void setParentId(
        final String parentId) {

        this.parentId = parentId;
    }

    public List<String> getRepoTags() {

        return this.repoTags;
    }

    public void setRepoTags(
        final List<String> repoTags) {

        this.repoTags = repoTags;
    }

    public Long getSize() {

        return this.size;
    }

    public void setSize(
        final Long size) {

        this.size = size;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Long getVirtualSize() {

        return this.virtualSize;
    }

    public void setVirtualSize(
        final Long virtualSize) {

        this.virtualSize = virtualSize;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (this.created == null ? 0 : this.created.hashCode());
        result = prime * result + (this.id == null ? 0 : this.id.hashCode());
        result = prime * result + (this.parentId == null ? 0 : this.parentId.hashCode());
        result = prime * result + (this.repoDigests == null ? 0 : this.repoDigests.hashCode());
        result = prime * result + (this.repoTags == null ? 0 : this.repoTags.hashCode());
        result = prime * result + (this.size == null ? 0 : this.size.hashCode());
        result = prime * result + (this.virtualSize == null ? 0 : this.virtualSize.hashCode());
        return result;
    }

    @Override
    public boolean equals(
        final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Image other = (Image) obj;
        if (this.created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!this.created.equals(other.created)) {
            return false;
        }
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.parentId == null) {
            if (other.parentId != null) {
                return false;
            }
        } else if (!this.parentId.equals(other.parentId)) {
            return false;
        }
        if (this.repoDigests == null) {
            if (other.repoDigests != null) {
                return false;
            }
        } else if (!this.repoDigests.equals(other.repoDigests)) {
            return false;
        }
        if (this.repoTags == null) {
            if (other.repoTags != null) {
                return false;
            }
        } else if (!this.repoTags.equals(other.repoTags)) {
            return false;
        }
        if (this.size == null) {
            if (other.size != null) {
                return false;
            }
        } else if (!this.size.equals(other.size)) {
            return false;
        }
        if (this.virtualSize == null) {
            if (other.virtualSize != null) {
                return false;
            }
        } else if (!this.virtualSize.equals(other.virtualSize)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return String.format(
            "Image [created=%s, id=%s, parentId=%s, repoTags=%s, size=%s, virtualSize=%s, repoDigests=%s]",
            this.created, this.id, this.parentId, this.repoTags, this.size, this.virtualSize, this.repoDigests);
    }

}
