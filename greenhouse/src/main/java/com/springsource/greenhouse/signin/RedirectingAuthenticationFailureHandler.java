/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.springsource.greenhouse.signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.flash.FlashMap;

/**
 * Custom Spring Security AuthenticationFailureHandler that redirects to back to the signin page on signin failure.
 * Sets a signinError flag in flash scope to support rendering an error message after the redirect.
 * Useful for "redirect after post" semantics and keeping sign-in URLs clean.
 * @author Keith Donald
 */
public class RedirectingAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		FlashMap.getCurrent(request).put("signinError", true);
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/signin"));
	}
	
}
