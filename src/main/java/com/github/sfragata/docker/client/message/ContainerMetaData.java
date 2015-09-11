/**
 *
 */
package com.github.sfragata.docker.client.message;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

        return this.id;
    }

    public Date getCreated() {

        return this.created;
    }

    public String getPath() {

        return this.path;
    }

    public List<String> getArgs() {

        return this.args;
    }

    public String getAppArmorProfile() {

        return this.appArmorProfile;
    }

    public ContainerConfig getConfig() {

        return this.config;
    }

    public HostConfig getHostConfig() {

        return this.hostConfig;
    }

    public ContainerState getState() {

        return this.state;
    }

    public String getImage() {

        return this.image;
    }

    public NetworkSettings getNetworkSettings() {

        return this.networkSettings;
    }

    public String getResolvConfPath() {

        return this.resolvConfPath;
    }

    public String getHostnamePath() {

        return this.hostnamePath;
    }

    public String getHostsPath() {

        return this.hostsPath;
    }

    public String getName() {

        return this.name;
    }

    public String getDriver() {

        return this.driver;
    }

    public String getExecDriver() {

        return this.execDriver;
    }

    public String getProcessLabel() {

        return this.processLabel;
    }

    public String getMountLabel() {

        return this.mountLabel;
    }

    public Map<String, String> getVolumes() {

        return this.volumes;
    }

    public Map<String, Boolean> getVolumesRW() {

        return this.volumesRW;
    }

    public Integer getRestartCount() {

        return this.restartCount;
    }

    public String getExecIds() {

        return this.execIds;
    }

    public String getLogPath() {

        return this.logPath;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (this.appArmorProfile == null ? 0 : this.appArmorProfile.hashCode());
        result = prime * result + (this.args == null ? 0 : this.args.hashCode());
        result = prime * result + (this.config == null ? 0 : this.config.hashCode());
        result = prime * result + (this.created == null ? 0 : this.created.hashCode());
        result = prime * result + (this.driver == null ? 0 : this.driver.hashCode());
        result = prime * result + (this.execDriver == null ? 0 : this.execDriver.hashCode());
        result = prime * result + (this.execIds == null ? 0 : this.execIds.hashCode());
        result = prime * result + (this.hostConfig == null ? 0 : this.hostConfig.hashCode());
        result = prime * result + (this.hostnamePath == null ? 0 : this.hostnamePath.hashCode());
        result = prime * result + (this.hostsPath == null ? 0 : this.hostsPath.hashCode());
        result = prime * result + (this.id == null ? 0 : this.id.hashCode());
        result = prime * result + (this.image == null ? 0 : this.image.hashCode());
        result = prime * result + (this.logPath == null ? 0 : this.logPath.hashCode());
        result = prime * result + (this.mountLabel == null ? 0 : this.mountLabel.hashCode());
        result = prime * result + (this.name == null ? 0 : this.name.hashCode());
        result = prime * result + (this.networkSettings == null ? 0 : this.networkSettings.hashCode());
        result = prime * result + (this.path == null ? 0 : this.path.hashCode());
        result = prime * result + (this.processLabel == null ? 0 : this.processLabel.hashCode());
        result = prime * result + (this.resolvConfPath == null ? 0 : this.resolvConfPath.hashCode());
        result = prime * result + (this.restartCount == null ? 0 : this.restartCount.hashCode());
        result = prime * result + (this.state == null ? 0 : this.state.hashCode());
        result = prime * result + (this.volumes == null ? 0 : this.volumes.hashCode());
        result = prime * result + (this.volumesRW == null ? 0 : this.volumesRW.hashCode());
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
        final ContainerMetaData other = (ContainerMetaData) obj;
        if (this.appArmorProfile == null) {
            if (other.appArmorProfile != null) {
                return false;
            }
        } else if (!this.appArmorProfile.equals(other.appArmorProfile)) {
            return false;
        }
        if (this.args == null) {
            if (other.args != null) {
                return false;
            }
        } else if (!this.args.equals(other.args)) {
            return false;
        }
        if (this.config == null) {
            if (other.config != null) {
                return false;
            }
        } else if (!this.config.equals(other.config)) {
            return false;
        }
        if (this.created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!this.created.equals(other.created)) {
            return false;
        }
        if (this.driver == null) {
            if (other.driver != null) {
                return false;
            }
        } else if (!this.driver.equals(other.driver)) {
            return false;
        }
        if (this.execDriver == null) {
            if (other.execDriver != null) {
                return false;
            }
        } else if (!this.execDriver.equals(other.execDriver)) {
            return false;
        }
        if (this.execIds == null) {
            if (other.execIds != null) {
                return false;
            }
        } else if (!this.execIds.equals(other.execIds)) {
            return false;
        }
        if (this.hostConfig == null) {
            if (other.hostConfig != null) {
                return false;
            }
        } else if (!this.hostConfig.equals(other.hostConfig)) {
            return false;
        }
        if (this.hostnamePath == null) {
            if (other.hostnamePath != null) {
                return false;
            }
        } else if (!this.hostnamePath.equals(other.hostnamePath)) {
            return false;
        }
        if (this.hostsPath == null) {
            if (other.hostsPath != null) {
                return false;
            }
        } else if (!this.hostsPath.equals(other.hostsPath)) {
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
        if (this.logPath == null) {
            if (other.logPath != null) {
                return false;
            }
        } else if (!this.logPath.equals(other.logPath)) {
            return false;
        }
        if (this.mountLabel == null) {
            if (other.mountLabel != null) {
                return false;
            }
        } else if (!this.mountLabel.equals(other.mountLabel)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.networkSettings == null) {
            if (other.networkSettings != null) {
                return false;
            }
        } else if (!this.networkSettings.equals(other.networkSettings)) {
            return false;
        }
        if (this.path == null) {
            if (other.path != null) {
                return false;
            }
        } else if (!this.path.equals(other.path)) {
            return false;
        }
        if (this.processLabel == null) {
            if (other.processLabel != null) {
                return false;
            }
        } else if (!this.processLabel.equals(other.processLabel)) {
            return false;
        }
        if (this.resolvConfPath == null) {
            if (other.resolvConfPath != null) {
                return false;
            }
        } else if (!this.resolvConfPath.equals(other.resolvConfPath)) {
            return false;
        }
        if (this.restartCount == null) {
            if (other.restartCount != null) {
                return false;
            }
        } else if (!this.restartCount.equals(other.restartCount)) {
            return false;
        }
        if (this.state == null) {
            if (other.state != null) {
                return false;
            }
        } else if (!this.state.equals(other.state)) {
            return false;
        }
        if (this.volumes == null) {
            if (other.volumes != null) {
                return false;
            }
        } else if (!this.volumes.equals(other.volumes)) {
            return false;
        }
        if (this.volumesRW == null) {
            if (other.volumesRW != null) {
                return false;
            }
        } else if (!this.volumesRW.equals(other.volumesRW)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return String
            .format(
                "ContainerMetaData [id=%s, created=%s, path=%s, args=%s, appArmorProfile=%s, config=%s, hostConfig=%s, state=%s, image=%s, networkSettings=%s, resolvConfPath=%s, hostnamePath=%s, hostsPath=%s, name=%s, driver=%s, execDriver=%s, processLabel=%s, mountLabel=%s, volumes=%s, volumesRW=%s, restartCount=%s, execIds=%s, logPath=%s]",
                this.id, this.created, this.path, this.args, this.appArmorProfile, this.config, this.hostConfig,
                this.state, this.image, this.networkSettings, this.resolvConfPath, this.hostnamePath, this.hostsPath,
                this.name, this.driver, this.execDriver, this.processLabel, this.mountLabel, this.volumes,
                this.volumesRW, this.restartCount, this.execIds, this.logPath);
    }

}
