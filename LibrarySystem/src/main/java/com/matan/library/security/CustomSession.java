package com.matan.library.security;

import com.matan.library.service.ClientService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomSession {

	private ClientService clientService;
	private long date;
}
