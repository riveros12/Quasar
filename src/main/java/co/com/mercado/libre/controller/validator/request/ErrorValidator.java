package co.com.mercado.libre.controller.validator.request;

import co.com.mercado.libre.domain.exception.ErrorCode;
import co.com.mercado.libre.domain.exception.QuasarException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorValidator {

    public static void manejarErroresValidacion (BindingResult errors) throws QuasarException {
        if ( errors.hasErrors() ){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ErrorCode.STATUS_BAD.getDescripcion());
            for (ObjectError error :errors.getAllErrors()){
                stringBuilder.append("\n" + error.getDefaultMessage());
            }throw  new QuasarException(stringBuilder.toString(), new IllegalArgumentException("Argumentos incorrectos para iniciar servicio"), ErrorCode.STATUS_BAD );}}

}
