/**
 * 
 */
package com.github.sfragata.docker.client.message;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
public class ContainerMetaData {

	@JsonProperty("Id")
	private String id;

	@JsonProperty("Created")
	private Date created;

	@JsonProperty("Path")
	private String path;

	@JsonProperty("Args")
	private List<String> args;

	@JsonProperty("AppArmorProfile")
	private String appArmorProfile;

	@JsonProperty("Config")
	private ContainerConfig config;

	@JsonProperty("HostConfig")
	private HostConfig hostConfig;

	@JsonProperty("State")
	private ContainerState state;

	@JsonProperty("Image")
	private String image;

	@JsonProperty("NetworkSettings")
	private NetworkSettings networkSettings;

	@JsonProperty("ResolvConfPath")
	private String resolvConfPath;

	@JsonProperty("HostnamePath")
	private String hostnamePath;

	@JsonProperty("HostsPath")
	private String hostsPath;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("ExecDriver")
	private String execDriver;

	@JsonProperty("ProcessLabel")
	private String processLabel;

	@JsonProperty("MountLabel")
	private String mountLabel;

	@JsonProperty("Volumes")
	private Map<String, String> volumes;

	@JsonProperty("VolumesRW")
	private Map<String, Boolean> volumesRW;

	@JsonProperty("RestartCount")
	private Integer restartCount;

	@JsonProperty("ExecIDs")
	private String execIds;

	@JsonProperty("LogPath")
	private String logPath;

	public String getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public String getPath() {
		return path;
	}

	public List<String> getArgs() {
		return args;
	}

	public String getAppArmorProfile() {
		return appArmorProfile;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public HostConfig getHostConfig() {
		return hostConfig;
	}

	public ContainerState getState() {
		return state;
	}

	public String getImage() {
		return image;
	}

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public String getResolvConfPath() {
		return resolvConfPath;
	}

	public String getHostnamePath() {
		return hostnamePath;
	}

	public String getHostsPath() {
		return hostsPath;
	}

	public String getName() {
		return name;
	}

	public String getDriver() {
		return driver;
	}

	public String getExecDriver() {
		return execDriver;
	}

	public String getProcessLabel() {
		return processLabel;
	}

	public String getMountLabel() {
		return mountLabel;
	}

	public Map<String, String> getVolumes() {
		return volumes;
	}

	public Map<String, Boolean> getVolumesRW() {
		return volumesRW;
	}

	public Integer getRestartCount() {
		return restartCount;
	}

	public String getExecIds() {
		return execIds;
	}

	public String getLogPath() {
		return logPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appArmorProfile == null) ? 0 : appArmorProfile.hashCode());
		result = prime * result + ((args == null) ? 0 : args.hashCode());
		result = prime * result + ((config == null) ? 0 : config.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
		result = prime * result
				+ ((execDriver == null) ? 0 : execDriver.hashCode());
		result = prime * result + ((execIds == null) ? 0 : execIds.hashCode());
		result = prime * result
				+ ((hostConfig == null) ? 0 : hostConfig.hashCode());
		result = prime * result
				+ ((hostnamePath == null) ? 0 : hostnamePath.hashCode());
		result = prime * result
				+ ((hostsPath == null) ? 0 : hostsPath.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((logPath == null) ? 0 : logPath.hashCode());
		result = prime * result
				+ ((mountLabel == null) ? 0 : mountLabel.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((networkSettings == null) ? 0 : networkSettings.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result
				+ ((processLabel == null) ? 0 : processLabel.hashCode());
		result = prime * result
				+ ((resolvConfPath == null) ? 0 : resolvConfPath.hashCode());
		result = prime * result
				+ ((restartCount == null) ? 0 : restartCount.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((volumes == null) ? 0 : volumes.hashCode());
		result = prime * result
				+ ((volumesRW == null) ? 0 : volumesRW.hashCode());
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
		ContainerMetaData other = (ContainerMetaData) obj;
		if (appArmorProfile == null) {
			if (other.appArmorProfile != null)
				return false;
		} else if (!appArmorProfile.equals(other.appArmorProfile))
			return false;
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
			return false;
		if (config == null) {
			if (other.config != null)
				return false;
		} else if (!config.equals(other.config))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
			return false;
		if (execDriver == null) {
			if (other.execDriver != null)
				return false;
		} else if (!execDriver.equals(other.execDriver))
			return false;
		if (execIds == null) {
			if (other.execIds != null)
				return false;
		} else if (!execIds.equals(other.execIds))
			return false;
		if (hostConfig == null) {
			if (other.hostConfig != null)
				return false;
		} else if (!hostConfig.equals(other.hostConfig))
			return false;
		if (hostnamePath == null) {
			if (other.hostnamePath != null)
				return false;
		} else if (!hostnamePath.equals(other.hostnamePath))
			return false;
		if (hostsPath == null) {
			if (other.hostsPath != null)
				return false;
		} else if (!hostsPath.equals(other.hostsPath))
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
		if (logPath == null) {
			if (other.logPath != null)
				return false;
		} else if (!logPath.equals(other.logPath))
			return false;
		if (mountLabel == null) {
			if (other.mountLabel != null)
				return false;
		} else if (!mountLabel.equals(other.mountLabel))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (networkSettings == null) {
			if (other.networkSettings != null)
				return false;
		} else if (!networkSettings.equals(other.networkSettings))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (processLabel == null) {
			if (other.processLabel != null)
				return false;
		} else if (!processLabel.equals(other.processLabel))
			return false;
		if (resolvConfPath == null) {
			if (other.resolvConfPath != null)
				return false;
		} else if (!resolvConfPath.equals(other.resolvConfPath))
			return false;
		if (restartCount == null) {
			if (other.restartCount != null)
				return false;
		} else if (!restartCount.equals(other.restartCount))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (volumes == null) {
			if (other.volumes != null)
				return false;
		} else if (!volumes.equals(other.volumes))
			return false;
		if (volumesRW == null) {
			if (other.volumesRW != null)
				return false;
		} else if (!volumesRW.equals(other.volumesRW))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("ContainerMetaData [id=%s, created=%s, path=%s, args=%s, appArmorProfile=%s, config=%s, hostConfig=%s, state=%s, image=%s, networkSettings=%s, resolvConfPath=%s, hostnamePath=%s, hostsPath=%s, name=%s, driver=%s, execDriver=%s, processLabel=%s, mountLabel=%s, volumes=%s, volumesRW=%s, restartCount=%s, execIds=%s, logPath=%s]",
						id, created, path, args, appArmorProfile, config,
						hostConfig, state, image, networkSettings,
						resolvConfPath, hostnamePath, hostsPath, name, driver,
						execDriver, processLabel, mountLabel, volumes,
						volumesRW, restartCount, execIds, logPath);
	}

}
