package com.github.sfragata.docker.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
/*
 * [ { "Command": "/start.sh", "Created": 1433990139, "Id":
 * "1ac7b54617121c3bbbc6fb5b4563f6c24cf07782f9fc2dcbcced4a4f5b3674c3", "Image": "timhaak/plex:latest", "Names": [
 * "/plex" ], "Ports": [], "Status": "Up About an hour" } ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

        return this.command;
    }

    public void setCommand(
        final String command) {

        this.command = command;
    }

    public Long getCreated() {

        return this.created;
    }

    public void setCreated(
        final Long created) {

        this.created = created;
    }

    public String getId() {

        return this.id;
    }

    public void setId(
        final String id) {

        this.id = id;
    }

    public String getImage() {

        return this.image;
    }

    public void setImage(
        final String image) {

        this.image = image;
    }

    public List<String> getNames() {

        return this.names;
    }

    public void setNames(
        final List<String> names) {

        this.names = names;
    }

    public List<Port> getPorts() {

        return this.ports;
    }

    public void setPorts(
        final List<Port> ports) {

        this.ports = ports;
    }

    public String getStatus() {

        return this.status;
    }

    public void setStatus(
        final String status) {

        this.status = status;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (this.command == null ? 0 : this.command.hashCode());
        result = prime * result + (this.created == null ? 0 : this.created.hashCode());
        result = prime * result + (this.id == null ? 0 : this.id.hashCode());
        result = prime * result + (this.image == null ? 0 : this.image.hashCode());
        result = prime * result + (this.names == null ? 0 : this.names.hashCode());
        result = prime * result + (this.ports == null ? 0 : this.ports.hashCode());
        result = prime * result + (this.status == null ? 0 : this.status.hashCode());
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
        final Container other = (Container) obj;
        if (this.command == null) {
            if (other.command != null) {
                return false;
            }
        } else if (!this.command.equals(other.command)) {
            return false;
        }
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
        if (this.image == null) {
            if (other.image != null) {
                return false;
            }
        } else if (!this.image.equals(other.image)) {
            return false;
        }
        if (this.names == null) {
            if (other.names != null) {
                return false;
            }
        } else if (!this.names.equals(other.names)) {
            return false;
        }
        if (this.ports == null) {
            if (other.ports != null) {
                return false;
            }
        } else if (!this.ports.equals(other.ports)) {
            return false;
        }
        if (this.status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!this.status.equals(other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return String.format("Container [command=%s, created=%s, id=%s, image=%s, names=%s, ports=%s, status=%s]",
            this.command, this.created, this.id, this.image, this.names, this.ports, this.status);
    }

}
