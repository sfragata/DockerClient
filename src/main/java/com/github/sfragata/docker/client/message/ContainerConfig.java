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
public class ContainerConfig {

	@JsonProperty("Hostname")
	private String hostname;

	@JsonProperty("Domainname")
	private String domainname;

	@JsonProperty("User")
	private String user;

	@JsonProperty("AttachStdin")
	private Boolean attachStdin;

	@JsonProperty("AttachStdout")
	private Boolean attachStdout;

	@JsonProperty("AttachStderr")
	private Boolean attachStderr;

	@JsonProperty("PortSpecs")
	private List<String> portSpecs;

	// @JsonProperty("ExposedPorts")
	// private Set<String> exposedPorts;

	@JsonProperty("Tty")
	private Boolean tty;

	@JsonProperty("OpenStdin")
	private Boolean openStdin;

	@JsonProperty("StdinOnce")
	private Boolean stdinOnce;

	@JsonProperty("Env")
	private List<String> env;

	@JsonProperty("Cmd")
	private List<String> cmd;

	@JsonProperty("Image")
	private String image;

	// @JsonProperty("Volumes")
	// private String volumes;

	@JsonProperty("WorkingDir")
	private String workingDir;

	@JsonProperty("Entrypoint")
	private List<String> entrypoint;

	@JsonProperty("NetworkDisabled")
	private Boolean networkDisabled;

	@JsonProperty("OnBuild")
	private List<String> onBuild;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("MacAddress")
	private String macAddress;

	public String getHostname() {
		return hostname;
	}

	public String getDomainname() {
		return domainname;
	}

	public String getUser() {
		return user;
	}

	public Boolean getAttachStdin() {
		return attachStdin;
	}

	public Boolean getAttachStdout() {
		return attachStdout;
	}

	public Boolean getAttachStderr() {
		return attachStderr;
	}

	public List<String> getPortSpecs() {
		return portSpecs;
	}

	public Boolean getTty() {
		return tty;
	}

	public Boolean getOpenStdin() {
		return openStdin;
	}

	public Boolean getStdinOnce() {
		return stdinOnce;
	}

	public List<String> getEnv() {
		return env;
	}

	public List<String> getCmd() {
		return cmd;
	}

	public String getImage() {
		return image;
	}

	public String getWorkingDir() {
		return workingDir;
	}

	public List<String> getEntrypoint() {
		return entrypoint;
	}

	public Boolean getNetworkDisabled() {
		return networkDisabled;
	}

	public List<String> getOnBuild() {
		return onBuild;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public String getMacAddress() {
		return macAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attachStderr == null) ? 0 : attachStderr.hashCode());
		result = prime * result
				+ ((attachStdin == null) ? 0 : attachStdin.hashCode());
		result = prime * result
				+ ((attachStdout == null) ? 0 : attachStdout.hashCode());
		result = prime * result + ((cmd == null) ? 0 : cmd.hashCode());
		result = prime * result
				+ ((domainname == null) ? 0 : domainname.hashCode());
		result = prime * result
				+ ((entrypoint == null) ? 0 : entrypoint.hashCode());
		result = prime * result + ((env == null) ? 0 : env.hashCode());
		result = prime * result
				+ ((hostname == null) ? 0 : hostname.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result
				+ ((macAddress == null) ? 0 : macAddress.hashCode());
		result = prime * result
				+ ((networkDisabled == null) ? 0 : networkDisabled.hashCode());
		result = prime * result + ((onBuild == null) ? 0 : onBuild.hashCode());
		result = prime * result
				+ ((openStdin == null) ? 0 : openStdin.hashCode());
		result = prime * result
				+ ((portSpecs == null) ? 0 : portSpecs.hashCode());
		result = prime * result
				+ ((stdinOnce == null) ? 0 : stdinOnce.hashCode());
		result = prime * result + ((tty == null) ? 0 : tty.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((workingDir == null) ? 0 : workingDir.hashCode());
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
		ContainerConfig other = (ContainerConfig) obj;
		if (attachStderr == null) {
			if (other.attachStderr != null)
				return false;
		} else if (!attachStderr.equals(other.attachStderr))
			return false;
		if (attachStdin == null) {
			if (other.attachStdin != null)
				return false;
		} else if (!attachStdin.equals(other.attachStdin))
			return false;
		if (attachStdout == null) {
			if (other.attachStdout != null)
				return false;
		} else if (!attachStdout.equals(other.attachStdout))
			return false;
		if (cmd == null) {
			if (other.cmd != null)
				return false;
		} else if (!cmd.equals(other.cmd))
			return false;
		if (domainname == null) {
			if (other.domainname != null)
				return false;
		} else if (!domainname.equals(other.domainname))
			return false;
		if (entrypoint == null) {
			if (other.entrypoint != null)
				return false;
		} else if (!entrypoint.equals(other.entrypoint))
			return false;
		if (env == null) {
			if (other.env != null)
				return false;
		} else if (!env.equals(other.env))
			return false;
		if (hostname == null) {
			if (other.hostname != null)
				return false;
		} else if (!hostname.equals(other.hostname))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (networkDisabled == null) {
			if (other.networkDisabled != null)
				return false;
		} else if (!networkDisabled.equals(other.networkDisabled))
			return false;
		if (onBuild == null) {
			if (other.onBuild != null)
				return false;
		} else if (!onBuild.equals(other.onBuild))
			return false;
		if (openStdin == null) {
			if (other.openStdin != null)
				return false;
		} else if (!openStdin.equals(other.openStdin))
			return false;
		if (portSpecs == null) {
			if (other.portSpecs != null)
				return false;
		} else if (!portSpecs.equals(other.portSpecs))
			return false;
		if (stdinOnce == null) {
			if (other.stdinOnce != null)
				return false;
		} else if (!stdinOnce.equals(other.stdinOnce))
			return false;
		if (tty == null) {
			if (other.tty != null)
				return false;
		} else if (!tty.equals(other.tty))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (workingDir == null) {
			if (other.workingDir != null)
				return false;
		} else if (!workingDir.equals(other.workingDir))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("ContainerConfig [hostname=%s, domainname=%s, user=%s, attachStdin=%s, attachStdout=%s, attachStderr=%s, portSpecs=%s, tty=%s, openStdin=%s, stdinOnce=%s, env=%s, cmd=%s, image=%s, workingDir=%s, entrypoint=%s, networkDisabled=%s, onBuild=%s, labels=%s, macAddress=%s]",
						hostname, domainname, user, attachStdin, attachStdout,
						attachStderr, portSpecs, tty, openStdin, stdinOnce,
						env, cmd, image, workingDir, entrypoint,
						networkDisabled, onBuild, labels, macAddress);
	}

}
