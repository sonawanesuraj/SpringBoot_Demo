package com.demo.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.ServiceImpl.ApiLoggerServiceImpl;
import com.demo.entity.ApiLoggerEntity;
import com.demo.entity.LoggerEntity;
import com.demo.exception.ErrorResponceDto;
import com.demo.service.LoggerServiceInterface;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiLogger implements HandlerInterceptor {

	public ApiLogger() {
		super();
	}

	@Autowired
	private ApiLoggerServiceImpl apiLoggerServiceImpl;

	@Autowired
	private LoggerServiceInterface loggerServiceInterface;

	Gson gson = new Gson();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		ArrayList<String> urlWithoutHeaders = new ArrayList<>(Arrays.asList("/Auth/login", "/Auth/register"));

		final String requestUrl = request.getRequestURI();
		System.out.println("url ---" + requestUrl);
		final String AuthenticationHeader = request.getHeader("Authorization");

		if (!urlWithoutHeaders.contains(requestUrl)) {

			final String requestTokenHeader = (null != AuthenticationHeader) ? AuthenticationHeader.split(" ")[1]
					: null;

			LoggerEntity logsDetail = loggerServiceInterface.getLoggerDetail(requestTokenHeader);

			if (logsDetail == null) {

				ErrorResponceDto error = new ErrorResponceDto("You are not login user", "not login user");
				String employeeJsonString = this.gson.toJson(error);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(employeeJsonString);
				return false;

			} else {

				ApiLoggerEntity apiDetail = new ApiLoggerEntity();
				apiDetail.setUserToken(AuthenticationHeader);
				apiDetail.setIpAddress(request.getRemoteAddr());
				apiDetail.setUrl(request.getRequestURI());
				apiDetail.setMethod(request.getMethod());
				apiDetail.setHost(request.getRemoteHost());
				apiDetail.setBody(request instanceof StandardMultipartHttpServletRequest ? null
						: request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
				apiLoggerServiceImpl.createApiLog(apiDetail);
				return true;

			}
		} else {
			ApiLoggerEntity apiDetail = new ApiLoggerEntity();
			apiDetail.setUserToken("");
			apiDetail.setIpAddress(request.getRemoteAddr());
			apiDetail.setUrl(request.getRequestURI());
			apiDetail.setMethod(request.getMethod());
			apiDetail.setHost(request.getRemoteHost());
			apiDetail.setBody(request instanceof StandardMultipartHttpServletRequest ? null
					: request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

			apiLoggerServiceImpl.createApiLog(apiDetail);

			return true;
		}

	}

}
