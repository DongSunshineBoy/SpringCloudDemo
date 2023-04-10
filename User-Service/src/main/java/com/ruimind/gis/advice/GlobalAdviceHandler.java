package com.ruimind.gis.advice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dongwentao
 * @version 1.0
 * @description: TODO
 * @company: TODO
 */

//此处只会扫面detachController包下边的controller, 怕影响到其他的业务
@Slf4j
@RestControllerAdvice
public class GlobalAdviceHandler {
    //全局异常处理方法, 默认是全部异常都会经过此方法处理拦截,
    //FIXME 后期可以进行修改


    @ExceptionHandler(NullPointerException.class)
    public GlobalResponseResult<Object> NullPointer(NullPointerException ex){
        log.error(ex.getMessage(),ex);
        return  GlobalResponseResult.fail(GlobalResponseResultEnum.NPE_EXCEPTION.getCode(),
                GlobalResponseResultEnum.NPE_EXCEPTION.getMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalResponseResult<Void> bindException(BindException ex, HttpServletRequest request) {
        log.warn("BindException:", ex);
        try {
            // 拿到@NotNull,@NotBlank和 @NotEmpty等注解上的message值
            String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
            if (StringUtils.isNotEmpty(message)) {
                // 自定义状态返回
                return  GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), message);
            }
        } catch (Exception ignored) {
        }

        // 参数类型不匹配检验
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        fieldErrors.forEach((oe) ->
                message.append("参数:[").append(oe.getObjectName())
                        .append(".").append(oe.getField())
                        .append("]的传入值:[").append(oe.getRejectedValue()).append("]与预期的字段类型不匹配.")
        );
        return GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), message.toString());
    }



    //全局异常处理方法, 默认是全部异常都会经过此方法处理拦截,
    //FIXME 后期可以进行修改
    @ExceptionHandler(ConstraintViolationException.class)
    public GlobalResponseResult<Object> constraintViolationException(ConstraintViolationException ex){
        log.warn("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return  GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), message);
    }

    @ExceptionHandler(ClassCastException.class)
    public GlobalResponseResult<Object> ClassCastException(ClassCastException ex){
        log.error(ex.getMessage(),ex);
        GlobalResponseResult<Object> fail = GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), ex.getMessage());
        return fail;
    }

    @ExceptionHandler(IOException.class)
    public GlobalResponseResult<Object> IOException(IOException ex){
        log.error(ex.getMessage(),ex);
        return  GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), ex.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public GlobalResponseResult<Object> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        log.error(ex.getMessage(),ex);
        return  GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public GlobalResponseResult<Object> runtimeException(RuntimeException ex){
        log.error(ex.getMessage(),ex);
        return  GlobalResponseResult.fail(GlobalResponseResultEnum.RC500.getCode(), ex.getMessage());
    }


    @ExceptionHandler(GlobalRunTimeException.class)
    public GlobalResponseResult<Object> globalRunTimeException(GlobalRunTimeException ex){
        log.error(ex.getMessage(),ex);
        return  GlobalResponseResult.fail(ex.getCode(), ex.getMessage());
    }
}
