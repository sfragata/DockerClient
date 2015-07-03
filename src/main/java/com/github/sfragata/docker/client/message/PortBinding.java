/**
 * 
 */
package com.github.sfragata.docker.client.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
public class PortBinding {
	@JsonProperty("HostIp")
	private String hostIp;
	@JsonProperty("HostPort")
	private String hostPort;

	public String getHostIp() {
		return hostIp;
	}

	public String getHostPort() {
		return hostPort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hostIp == null) ? 0 : hostIp.hashCode());
		result = prime * result
				+ ((hostPort == null) ? 0 : hostPort.hashCode());
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
		PortBinding other = (PortBinding) obj;
		if (hostIp == null) {
			if (other.hostIp != null)
				return false;
		} else if (!hostIp.equals(other.hostIp))
			return false;
		if (hostPort == null) {
			if (other.hostPort != null)
				return false;
		} else if (!hostPort.equals(other.hostPort))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("PortBinding [hostIp=%s, hostPort=%s]", hostIp,
				hostPort);
	}

}
