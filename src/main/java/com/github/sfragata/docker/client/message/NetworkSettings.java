/**
 * 
 */
package com.github.sfragata.docker.client.message;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkSettings {
	@JsonProperty("IPAddress")
	private String ipAddress;
	@JsonProperty("IPPrefixLen")
	private Integer ipPrefixLen;
	@JsonProperty("Gateway")
	private String gateway;
	@JsonProperty("Bridge")
	private String bridge;
	@JsonProperty("PortMapping")
	private Map<String, Map<String, String>> portMapping;
	@JsonProperty("Ports")
	private Map<String, List<PortBinding>> ports;
	@JsonProperty("MacAddress")
	private String macAddress;
	@JsonProperty("GlobalIPv6Address")
	private String globalIPV6Address;
	@JsonProperty("GlobalIPv6PrefixLen")
	private Long globalIPv6PrefixLen;

	public String getIpAddress() {
		return ipAddress;
	}

	public Integer getIpPrefixLen() {
		return ipPrefixLen;
	}

	public String getGateway() {
		return gateway;
	}

	public String getBridge() {
		return bridge;
	}

	public Map<String, Map<String, String>> getPortMapping() {
		return portMapping;
	}

	public Map<String, List<PortBinding>> getPorts() {
		return ports;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public String getGlobalIPV6Address() {
		return globalIPV6Address;
	}

	public Long getGlobalIPv6PrefixLen() {
		return globalIPv6PrefixLen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridge == null) ? 0 : bridge.hashCode());
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		result = prime
				* result
				+ ((globalIPV6Address == null) ? 0 : globalIPV6Address
						.hashCode());
		result = prime
				* result
				+ ((globalIPv6PrefixLen == null) ? 0 : globalIPv6PrefixLen
						.hashCode());
		result = prime * result
				+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result
				+ ((ipPrefixLen == null) ? 0 : ipPrefixLen.hashCode());
		result = prime * result
				+ ((macAddress == null) ? 0 : macAddress.hashCode());
		result = prime * result
				+ ((portMapping == null) ? 0 : portMapping.hashCode());
		result = prime * result + ((ports == null) ? 0 : ports.hashCode());
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
		NetworkSettings other = (NetworkSettings) obj;
		if (bridge == null) {
			if (other.bridge != null)
				return false;
		} else if (!bridge.equals(other.bridge))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		if (globalIPV6Address == null) {
			if (other.globalIPV6Address != null)
				return false;
		} else if (!globalIPV6Address.equals(other.globalIPV6Address))
			return false;
		if (globalIPv6PrefixLen == null) {
			if (other.globalIPv6PrefixLen != null)
				return false;
		} else if (!globalIPv6PrefixLen.equals(other.globalIPv6PrefixLen))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (ipPrefixLen == null) {
			if (other.ipPrefixLen != null)
				return false;
		} else if (!ipPrefixLen.equals(other.ipPrefixLen))
			return false;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (portMapping == null) {
			if (other.portMapping != null)
				return false;
		} else if (!portMapping.equals(other.portMapping))
			return false;
		if (ports == null) {
			if (other.ports != null)
				return false;
		} else if (!ports.equals(other.ports))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("NetworkSettings [ipAddress=%s, ipPrefixLen=%s, gateway=%s, bridge=%s, portMapping=%s, ports=%s, macAddress=%s, globalIPV6Address=%s, globalIPv6PrefixLen=%s]",
						ipAddress, ipPrefixLen, gateway, bridge, portMapping,
						ports, macAddress, globalIPV6Address,
						globalIPv6PrefixLen);
	}

}
