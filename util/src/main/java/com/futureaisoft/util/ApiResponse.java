package com.futureaisoft.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.futureaisoft.util.MyConstant;

@Component
public class ApiResponse {

	String status = MyConstant.FAILED;
	String message = "empty";
	Object data;

	public ApiResponse() {
	}

	public ApiResponse(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
