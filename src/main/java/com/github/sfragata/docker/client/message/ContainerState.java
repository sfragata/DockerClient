/**
 * 
 */
package com.github.sfragata.docker.client.message;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
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
		return running;
	}

	public Boolean getPaused() {
		return paused;
	}

	public Boolean getRestarting() {
		return restarting;
	}

	public Integer getPid() {
		return pid;
	}

	public Integer getExitCode() {
		return exitCode;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public String getError() {
		return error;
	}

	public Boolean getOomKilled() {
		return oomKilled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result
				+ ((exitCode == null) ? 0 : exitCode.hashCode());
		result = prime * result
				+ ((finishedAt == null) ? 0 : finishedAt.hashCode());
		result = prime * result
				+ ((oomKilled == null) ? 0 : oomKilled.hashCode());
		result = prime * result + ((paused == null) ? 0 : paused.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result
				+ ((restarting == null) ? 0 : restarting.hashCode());
		result = prime * result + ((running == null) ? 0 : running.hashCode());
		result = prime * result
				+ ((startedAt == null) ? 0 : startedAt.hashCode());
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
		ContainerState other = (ContainerState) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (exitCode == null) {
			if (other.exitCode != null)
				return false;
		} else if (!exitCode.equals(other.exitCode))
			return false;
		if (finishedAt == null) {
			if (other.finishedAt != null)
				return false;
		} else if (!finishedAt.equals(other.finishedAt))
			return false;
		if (oomKilled == null) {
			if (other.oomKilled != null)
				return false;
		} else if (!oomKilled.equals(other.oomKilled))
			return false;
		if (paused == null) {
			if (other.paused != null)
				return false;
		} else if (!paused.equals(other.paused))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (restarting == null) {
			if (other.restarting != null)
				return false;
		} else if (!restarting.equals(other.restarting))
			return false;
		if (running == null) {
			if (other.running != null)
				return false;
		} else if (!running.equals(other.running))
			return false;
		if (startedAt == null) {
			if (other.startedAt != null)
				return false;
		} else if (!startedAt.equals(other.startedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("ContainerState [running=%s, paused=%s, restarting=%s, pid=%s, exitCode=%s, startedAt=%s, finishedAt=%s, error=%s, oomKilled=%s]",
						running, paused, restarting, pid, exitCode, startedAt,
						finishedAt, error, oomKilled);
	}

}
