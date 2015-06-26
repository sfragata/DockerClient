package com.github.sfragata.docker.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
/*
 * [ { "Command": "/start.sh", "Created": 1433990139, "Id":
 * "1ac7b54617121c3bbbc6fb5b4563f6c24cf07782f9fc2dcbcced4a4f5b3674c3", "Image":
 * "timhaak/plex:latest", "Names": [ "/plex" ], "Ports": [], "Status":
 * "Up About an hour" } ]
 */

public class Container {

	@JsonProperty("Command")
	private String command;
	@JsonProperty("Created")
	private Long created;
	@JsonProperty("Id")
	private String id;
	@JsonProperty("Image")
	private String image;
	@JsonProperty("Names")
	private List<String> names;
	@JsonProperty("Ports")
	private List<Port> ports;
	@JsonProperty("Status")
	private String status;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result + ((ports == null) ? 0 : ports.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Container other = (Container) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (ports == null) {
			if (other.ports != null)
				return false;
		} else if (!ports.equals(other.ports))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Container [command=%s, created=%s, id=%s, image=%s, names=%s, ports=%s, status=%s]",
						command, created, id, image, names, ports, status);
	}

}
