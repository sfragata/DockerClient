/**
 * 
 */
package com.github.sfragata.docker.client.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
public class Port {
	@JsonProperty("PrivatePort")
	private int privatePort;
	@JsonProperty("PublicPort")
	private int publicPort;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("IP")
	private String ip;

	public int getPrivatePort() {
		return privatePort;
	}

	public void setPrivatePort(int privatePort) {
		this.privatePort = privatePort;
	}

	public int getPublicPort() {
		return publicPort;
	}

	public void setPublicPort(int publicPort) {
		this.publicPort = publicPort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + privatePort;
		result = prime * result + publicPort;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Port other = (Port) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (privatePort != other.privatePort)
			return false;
		if (publicPort != other.publicPort)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Port [privatePort=%s, publicPort=%s, type=%s, ip=%s]",
				privatePort, publicPort, type, ip);
	}

}
