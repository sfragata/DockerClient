/**
 * 
 */
package com.github.sfragata.docker.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
/*
 * 
 * [{"Created":1433972330, "Id":
 * "95f2ff8d98da834daa988dc6b5e498fd73a4c4a8da3a56d95d6abc7670a7cdd5",
 * "ParentId"
 * :"81b5152b18b3a3c9427e8adf144dc985fea9720ec3feffb8a9291ce6a1f65444",
 * "RepoTags":["timhaak/plex:latest"],"Size":0,"VirtualSize":660356148}]
 */
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
	@JsonProperty("VirtualSize")
	private Long virtualSize;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<String> getRepoTags() {
		return repoTags;
	}

	public void setRepoTags(List<String> repoTags) {
		this.repoTags = repoTags;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getVirtualSize() {
		return virtualSize;
	}

	public void setVirtualSize(Long virtualSize) {
		this.virtualSize = virtualSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result
				+ ((repoTags == null) ? 0 : repoTags.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result
				+ ((virtualSize == null) ? 0 : virtualSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (repoTags == null) {
			if (other.repoTags != null)
				return false;
		} else if (!repoTags.equals(other.repoTags))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (virtualSize == null) {
			if (other.virtualSize != null)
				return false;
		} else if (!virtualSize.equals(other.virtualSize))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Image [created=%s, id=%s, parentId=%s, repoTags=%s, size=%s, virtualSize=%s]",
						created, id, parentId, repoTags, size, virtualSize);
	}

}
