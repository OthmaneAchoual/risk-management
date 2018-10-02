package be.issep.riskmanagement.api.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class MySavedRequestAwareAuthenticationSuccessHandler 
	extends SimpleUrlAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest req,
			HttpServletResponse res,
			Authentication authentication)
			throws ServletException, IOException {
		
		SavedRequest savedRequest = requestCache.getRequest(req, res);
		
		if (savedRequest == null) {
			clearAuthenticationAttributes(req);
			return;
		}
		
		String targetUrlParam = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl() || targetUrlParam != null &&
			StringUtils.hasText(req.getParameter(targetUrlParam))) {
			requestCache.removeRequest(req, res);
			clearAuthenticationAttributes(req);
			return;
		}
		
		clearAuthenticationAttributes(req);
	}
	
	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}
