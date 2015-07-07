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
public class HostConfig {

	@JsonProperty("Binds")
	private List<String> binds;

	@JsonProperty("ContainerIDFile")
	private String containerIDFile;

	@JsonProperty("LxcConf")
	private List<LxcConf> lxcConf;

	@JsonProperty("Privileged")
	private Boolean privileged;

	@JsonProperty("PortBindings")
	private Map<String, List<PortBinding>> portBindings;

	@JsonProperty("Links")
	private List<String> links;

	@JsonProperty("PublishAllPorts")
	private Boolean publishAllPorts;

	@JsonProperty("Dns")
	private List<String> dns;

	@JsonProperty("DnsSearch")
	private List<String> dnsSearch;

	@JsonProperty("VolumesFrom")
	private List<String> volumesFrom;

	@JsonProperty("NetworkMode")
	private String networkMode;

	@JsonProperty("SecurityOpt")
	private List<String> securityOpt;

	@JsonProperty("Memory")
	private Long memory;

	@JsonProperty("MemorySwap")
	private Long memorySwap;

	@JsonProperty("CpuShares")
	private Long cpuShares;

	@JsonProperty("CpusetCpus")
	private String cpusetCpus;

	@JsonProperty("CgroupParent")
	private String cgroupParent;

	public List<String> getBinds() {
		return binds;
	}

	public String getContainerIDFile() {
		return containerIDFile;
	}

	public List<LxcConf> getLxcConf() {
		return lxcConf;
	}

	public Boolean getPrivileged() {
		return privileged;
	}

	public Map<String, List<PortBinding>> getPortBindings() {
		return portBindings;
	}

	public List<String> getLinks() {
		return links;
	}

	public Boolean getPublishAllPorts() {
		return publishAllPorts;
	}

	public List<String> getDns() {
		return dns;
	}

	public List<String> getDnsSearch() {
		return dnsSearch;
	}

	public List<String> getVolumesFrom() {
		return volumesFrom;
	}

	public String getNetworkMode() {
		return networkMode;
	}

	public List<String> getSecurityOpt() {
		return securityOpt;
	}

	public Long getMemory() {
		return memory;
	}

	public Long getMemorySwap() {
		return memorySwap;
	}

	public Long getCpuShares() {
		return cpuShares;
	}

	public String getCpusetCpus() {
		return cpusetCpus;
	}

	public String getCgroupParent() {
		return cgroupParent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((binds == null) ? 0 : binds.hashCode());
		result = prime * result
				+ ((cgroupParent == null) ? 0 : cgroupParent.hashCode());
		result = prime * result
				+ ((containerIDFile == null) ? 0 : containerIDFile.hashCode());
		result = prime * result
				+ ((cpuShares == null) ? 0 : cpuShares.hashCode());
		result = prime * result
				+ ((cpusetCpus == null) ? 0 : cpusetCpus.hashCode());
		result = prime * result + ((dns == null) ? 0 : dns.hashCode());
		result = prime * result
				+ ((dnsSearch == null) ? 0 : dnsSearch.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + ((lxcConf == null) ? 0 : lxcConf.hashCode());
		result = prime * result + ((memory == null) ? 0 : memory.hashCode());
		result = prime * result
				+ ((memorySwap == null) ? 0 : memorySwap.hashCode());
		result = prime * result
				+ ((networkMode == null) ? 0 : networkMode.hashCode());
		result = prime * result
				+ ((portBindings == null) ? 0 : portBindings.hashCode());
		result = prime * result
				+ ((privileged == null) ? 0 : privileged.hashCode());
		result = prime * result
				+ ((publishAllPorts == null) ? 0 : publishAllPorts.hashCode());
		result = prime * result
				+ ((securityOpt == null) ? 0 : securityOpt.hashCode());
		result = prime * result
				+ ((volumesFrom == null) ? 0 : volumesFrom.hashCode());
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
		HostConfig other = (HostConfig) obj;
		if (binds == null) {
			if (other.binds != null)
				return false;
		} else if (!binds.equals(other.binds))
			return false;
		if (cgroupParent == null) {
			if (other.cgroupParent != null)
				return false;
		} else if (!cgroupParent.equals(other.cgroupParent))
			return false;
		if (containerIDFile == null) {
			if (other.containerIDFile != null)
				return false;
		} else if (!containerIDFile.equals(other.containerIDFile))
			return false;
		if (cpuShares == null) {
			if (other.cpuShares != null)
				return false;
		} else if (!cpuShares.equals(other.cpuShares))
			return false;
		if (cpusetCpus == null) {
			if (other.cpusetCpus != null)
				return false;
		} else if (!cpusetCpus.equals(other.cpusetCpus))
			return false;
		if (dns == null) {
			if (other.dns != null)
				return false;
		} else if (!dns.equals(other.dns))
			return false;
		if (dnsSearch == null) {
			if (other.dnsSearch != null)
				return false;
		} else if (!dnsSearch.equals(other.dnsSearch))
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (lxcConf == null) {
			if (other.lxcConf != null)
				return false;
		} else if (!lxcConf.equals(other.lxcConf))
			return false;
		if (memory == null) {
			if (other.memory != null)
				return false;
		} else if (!memory.equals(other.memory))
			return false;
		if (memorySwap == null) {
			if (other.memorySwap != null)
				return false;
		} else if (!memorySwap.equals(other.memorySwap))
			return false;
		if (networkMode == null) {
			if (other.networkMode != null)
				return false;
		} else if (!networkMode.equals(other.networkMode))
			return false;
		if (portBindings == null) {
			if (other.portBindings != null)
				return false;
		} else if (!portBindings.equals(other.portBindings))
			return false;
		if (privileged == null) {
			if (other.privileged != null)
				return false;
		} else if (!privileged.equals(other.privileged))
			return false;
		if (publishAllPorts == null) {
			if (other.publishAllPorts != null)
				return false;
		} else if (!publishAllPorts.equals(other.publishAllPorts))
			return false;
		if (securityOpt == null) {
			if (other.securityOpt != null)
				return false;
		} else if (!securityOpt.equals(other.securityOpt))
			return false;
		if (volumesFrom == null) {
			if (other.volumesFrom != null)
				return false;
		} else if (!volumesFrom.equals(other.volumesFrom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("HostConfig [binds=%s, containerIDFile=%s, lxcConf=%s, privileged=%s, portBindings=%s, links=%s, publishAllPorts=%s, dns=%s, dnsSearch=%s, volumesFrom=%s, networkMode=%s, securityOpt=%s, memory=%s, memorySwap=%s, cpuShares=%s, cpusetCpus=%s, cgroupParent=%s]",
						binds, containerIDFile, lxcConf, privileged,
						portBindings, links, publishAllPorts, dns, dnsSearch,
						volumesFrom, networkMode, securityOpt, memory,
						memorySwap, cpuShares, cpusetCpus, cgroupParent);
	}

}
