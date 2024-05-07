package br.com.tkzi.api.exceptionhandler;

import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {
	
	private Integer status;
	private String type;
	private String title;
	private String detail;
	private OffsetDateTime timestamp;

}
