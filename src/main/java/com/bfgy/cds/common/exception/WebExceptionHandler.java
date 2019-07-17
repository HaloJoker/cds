package com.bfgy.cds.common.exception;

import com.bfgy.cds.common.utils.ResultDataDto;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.NestedServletException;
import org.xml.sax.SAXParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;


@ControllerAdvice
public class WebExceptionHandler {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler({ Error.class, Exception.class, Throwable.class, ServletException.class, SAXParseException.class,
			NestedServletException.class, FileNotFoundException.class, IOException.class})
	public void exception(HttpServletRequest request, HttpServletResponse response, Throwable e) throws IOException {
		
		logger.error("Unknown error occurs during :{}", request.getRequestURI());
		logger.error("Unknown system error stack :{}", e.getCause().getLocalizedMessage());
		e.printStackTrace();
		outputMessage(response, e);
	}

	private void outputMessage(HttpServletResponse response, Throwable o) throws IOException {
		o.printStackTrace();
		ResultDataDto resultDataDto = new ResultDataDto(o);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(new Gson().toJson(resultDataDto));
	}
}