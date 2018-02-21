package com.ims.response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Response<T>{

	
	String status;
	int code;
	List<String> messages = new ArrayList<>();
	Map<String, List<?>> result;
	
	public Response(){
		
	}

	public Response(String status, int code, List<String> messages, Map<String, List<?>> result) {
		super();
		this.status = status;
		this.code = code;
		this.messages = messages;
		this.result = result;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", code=" + code + ", messages=" + messages + ", result=" + result + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Map<String, List<?>> getResult() {
		return result;
	}

	public void setResult(Map<String, List<?>> result) {
		this.result = result;
	}
	
	
}
