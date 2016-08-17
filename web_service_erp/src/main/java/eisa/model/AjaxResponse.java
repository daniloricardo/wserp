package eisa.model;


public class AjaxResponse {
	public AjaxResponse() {
	}
	
	public AjaxResponse(Object id, String nome) {
		this.id = id;
		this.value = nome;
		this.tokens = this.value.split(" ");
	}
	
	private Object id;
	private String value;
	private String[] tokens;
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String[] getTokens() {
		return tokens;
	}
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
}
