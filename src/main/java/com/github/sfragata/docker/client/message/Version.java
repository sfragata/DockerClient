/**
 * 
 */
package com.github.sfragata.docker.client.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */

// {"ApiVersion":"1.17","Arch":"amd64","GitCommit":"a8a31ef","GoVersion":"go1.3.3",
// "KernelVersion":"3.19.0-21-generic","Os":"linux","Version":"1.5.0"}
public class Version {
	@JsonProperty("ApiVersion")
	private String apiVersion;
	@JsonProperty("Arch")
	private String arch;
	@JsonProperty("GitCommit")
	private String gitCommit;
	@JsonProperty("GoVersion")
	private String goVersion;
	@JsonProperty("KernelVersion")
	private String kernelVersion;
	@JsonProperty("Os")
	private String os;
	@JsonProperty("Version")
	private String version;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getArch() {
		return arch;
	}

	public void setArch(String arch) {
		this.arch = arch;
	}

	public String getGitCommit() {
		return gitCommit;
	}

	public void setGitCommit(String gitCommit) {
		this.gitCommit = gitCommit;
	}

	public String getGoVersion() {
		return goVersion;
	}

	public void setGoVersion(String goVersion) {
		this.goVersion = goVersion;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}

	public void setKernelVersion(String kernelVersion) {
		this.kernelVersion = kernelVersion;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apiVersion == null) ? 0 : apiVersion.hashCode());
		result = prime * result + ((arch == null) ? 0 : arch.hashCode());
		result = prime * result
				+ ((gitCommit == null) ? 0 : gitCommit.hashCode());
		result = prime * result
				+ ((goVersion == null) ? 0 : goVersion.hashCode());
		result = prime * result
				+ ((kernelVersion == null) ? 0 : kernelVersion.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Version other = (Version) obj;
		if (apiVersion == null) {
			if (other.apiVersion != null)
				return false;
		} else if (!apiVersion.equals(other.apiVersion))
			return false;
		if (arch == null) {
			if (other.arch != null)
				return false;
		} else if (!arch.equals(other.arch))
			return false;
		if (gitCommit == null) {
			if (other.gitCommit != null)
				return false;
		} else if (!gitCommit.equals(other.gitCommit))
			return false;
		if (goVersion == null) {
			if (other.goVersion != null)
				return false;
		} else if (!goVersion.equals(other.goVersion))
			return false;
		if (kernelVersion == null) {
			if (other.kernelVersion != null)
				return false;
		} else if (!kernelVersion.equals(other.kernelVersion))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Version [apiVersion=%s, arch=%s, gitCommit=%s, goVersion=%s, kernelVersion=%s, os=%s, version=%s]",
						apiVersion, arch, gitCommit, goVersion, kernelVersion,
						os, version);
	}

}
