package br.com.acsiu.dominio.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultPasswordDTO {

	private String score;
	private String status;
	private List<String> errors = new ArrayList<>();

	public String getScore() {
		return score;
	}

	public String getStatus() {
		return status;
	}

	public List<String> getErrors() {
		return errors;
	}

	public ResultPasswordDTO() {
	}

	public ResultPasswordDTO(String score, String status) {
		this.score = score;
		this.status = status;
	}

	public ResultPasswordDTO(String score, String status, List<String> errors) {
		this.score = score;
		this.status = status;
		this.errors = errors;
	}
}