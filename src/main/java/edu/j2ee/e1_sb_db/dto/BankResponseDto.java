package edu.j2ee.e1_sb_db.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BankResponseDto<T> {
	private int status;
	private String message;
	private T data;
}
