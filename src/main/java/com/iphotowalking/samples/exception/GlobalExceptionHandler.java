package com.iphotowalking.samples.exception;

import com.iphotowalking.samples.common.WError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 异常通用处理类
 * @author jianglz
 * @since 2018/3/5.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WError defaultErrorHandler(Exception ex) throws Exception {

        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
            throw ex;

        WError result = new WError();

        String exceptionName = ex.getClass().getSimpleName();
        result.setMsg(ex.getMessage());

        try {

            switch (exceptionName) {
                case "AuthException":
                    result.setCode("401");
                    result.setMsg(ex.getMessage());
                    break;
                case "BusinessException":
                    result.setCode(((BusinessException) ex).getMsgid());
                    break;
                case "BaseException":
                    result.setCode("400");
                    break;
                case "DataAccessException":
                    result.setCode("400");
                    result.setMsg("数据库访问异常");
                    break;
                case "SQLException":
                    result.setCode("400");
                    break;
                case "MissingServletRequestParameterException":
                case "ServletRequestBindingException":
                case "ConversionNotSupportedException":
                case "TypeMismatchException":
                case "HttpMessageNotReadableException":
                case "HttpMessageNotWritableException":
                case "MethodArgumentNotValidException":
                case "MissingServletRequestPartException":
                case "BindException":
                    result.setCode("400");
                    break;
                case "PageNotFoundException":
                case "NoHandlerFoundException":
                case "NoSuchRequestHandlingMethodException":
                    result.setCode("404");
                    break;
                case "HttpRequestMethodNotSupportedException":
                    result.setCode("405");
                    break;
                case "HttpMediaTypeNotAcceptableException":
                    result.setCode("405");
                    break;
                case "HttpMediaTypeNotSupportedException":
                    result.setCode("415");
                    break;
                case "MissingPathVariableException":
                    result.setCode("500");
                    break;
                default:
                    result.setCode("500");
                    result.setMsg("服务器繁忙");
                    break;
            }

            throw ex;

        } catch (Exception e) {
            if (log.isWarnEnabled()) {
                log.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", e);
            }
        }

        return result;
    }

}
