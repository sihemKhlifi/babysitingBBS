package com.getwireless.bbs.model;

import lombok.Data;

@Data
public class PasswordDto {
	private Integer id;
	private String oldPassword;
	private String newPassword;
}
