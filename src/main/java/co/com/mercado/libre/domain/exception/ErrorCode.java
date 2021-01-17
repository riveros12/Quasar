package co.com.mercado.libre.domain.exception;

public enum ErrorCode {

    STATUS_Ok("200","Succes"),
    STATUS_BAD("500","Bad");

    private String description;
    private String code;

    ErrorCode(String descripcion, String code) {
        this.description = description;this.code = code;}

    public String getDescripcion() {return description;}

    public String getCode() {return code;}

}
