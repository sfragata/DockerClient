/**
 *
 */
package com.github.sfragata.docker.client.message;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerState {
    @JsonProperty("Running")
    private Boolean running;

    @JsonProperty("Paused")
    private Boolean paused;

    @JsonProperty("Restarting")
    private Boolean restarting;

    @JsonProperty("Pid")
    private Integer pid;

    @JsonProperty("ExitCode")
    private Integer exitCode;

    @JsonProperty("StartedAt")
    private Date startedAt;

    @JsonProperty("FinishedAt")
    private Date finishedAt;

    @JsonProperty("Error")
    private String error;

    @JsonProperty("OOMKilled")
    private Boolean oomKilled;

    public Boolean getRunning() {

        return this.running;
    }

    public Boolean getPaused() {

        return this.paused;
    }

    public Boolean getRestarting() {

        return this.restarting;
    }

    public Integer getPid() {

        return this.pid;
    }

    public Integer getExitCode() {

        return this.exitCode;
    }

    public Date getStartedAt() {

        return this.startedAt;
    }

    public Date getFinishedAt() {

        return this.finishedAt;
    }

    public String getError() {

        return this.error;
    }

    public Boolean getOomKilled() {

        return this.oomKilled;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (this.error == null ? 0 : this.error.hashCode());
        result = prime * result + (this.exitCode == null ? 0 : this.exitCode.hashCode());
        result = prime * result + (this.finishedAt == null ? 0 : this.finishedAt.hashCode());
        result = prime * result + (this.oomKilled == null ? 0 : this.oomKilled.hashCode());
        result = prime * result + (this.paused == null ? 0 : this.paused.hashCode());
        result = prime * result + (this.pid == null ? 0 : this.pid.hashCode());
        result = prime * result + (this.restarting == null ? 0 : this.restarting.hashCode());
        result = prime * result + (this.running == null ? 0 : this.running.hashCode());
        result = prime * result + (this.startedAt == null ? 0 : this.startedAt.hashCode());
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
        final ContainerState other = (ContainerState) obj;
        if (this.error == null) {
            if (other.error != null) {
                return false;
            }
        } else if (!this.error.equals(other.error)) {
            return false;
        }
        if (this.exitCode == null) {
            if (other.exitCode != null) {
                return false;
            }
        } else if (!this.exitCode.equals(other.exitCode)) {
            return false;
        }
        if (this.finishedAt == null) {
            if (other.finishedAt != null) {
                return false;
            }
        } else if (!this.finishedAt.equals(other.finishedAt)) {
            return false;
        }
        if (this.oomKilled == null) {
            if (other.oomKilled != null) {
                return false;
            }
        } else if (!this.oomKilled.equals(other.oomKilled)) {
            return false;
        }
        if (this.paused == null) {
            if (other.paused != null) {
                return false;
            }
        } else if (!this.paused.equals(other.paused)) {
            return false;
        }
        if (this.pid == null) {
            if (other.pid != null) {
                return false;
            }
        } else if (!this.pid.equals(other.pid)) {
            return false;
        }
        if (this.restarting == null) {
            if (other.restarting != null) {
                return false;
            }
        } else if (!this.restarting.equals(other.restarting)) {
            return false;
        }
        if (this.running == null) {
            if (other.running != null) {
                return false;
            }
        } else if (!this.running.equals(other.running)) {
            return false;
        }
        if (this.startedAt == null) {
            if (other.startedAt != null) {
                return false;
            }
        } else if (!this.startedAt.equals(other.startedAt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return String
            .format(
                "ContainerState [running=%s, paused=%s, restarting=%s, pid=%s, exitCode=%s, startedAt=%s, finishedAt=%s, error=%s, oomKilled=%s]",
                this.running, this.paused, this.restarting, this.pid, this.exitCode, this.startedAt, this.finishedAt,
                this.error, this.oomKilled);
    }

}
