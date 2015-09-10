package com.invivoo.ficheprojet.app.domain.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.invivoo.ficheprojet.ApplicationConstants;
import com.invivoo.ficheprojet.security.utils.SecurityUtils;

@Component
public class UserNameAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {

	// String userName =
	// SecurityContextHolder.getContext().getAuthentication().getName()

	String userName = SecurityUtils.getCurrentLogin();
	return (userName != null ? userName : ApplicationConstants.SYSTEM_ACCOUNT);
    }
}
