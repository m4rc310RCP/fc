package br.com.m4rc310.fc.registry.models;

import lombok.Getter;

@Getter
public enum ETypeRegistration {
	EMPLOYEE(1), USER(2);
	private int code;

	private ETypeRegistration(int code) {
		this.code = code;
	}
}
