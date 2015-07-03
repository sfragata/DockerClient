/**
 * 
 */
package com.github.sfragata.docker.client.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sfragata
 *
 */
public class ProcessResult {

	@JsonProperty("Processes")
	List<List<String>> processes;

	@JsonProperty("Titles")
	List<String> titles;

	public List<List<String>> getProcesses() {
		return processes;
	}

	public List<String> getTitles() {
		return titles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((processes == null) ? 0 : processes.hashCode());
		result = prime * result + ((titles == null) ? 0 : titles.hashCode());
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
		ProcessResult other = (ProcessResult) obj;
		if (processes == null) {
			if (other.processes != null)
				return false;
		} else if (!processes.equals(other.processes))
			return false;
		if (titles == null) {
			if (other.titles != null)
				return false;
		} else if (!titles.equals(other.titles))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("ProcessResult [processes=%s, titles=%s]",
				processes, titles);
	}

}
