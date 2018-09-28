package be.issep.riskmanagement.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedUser extends RuntimeException {

	public UnauthorizedUser(String message) {
		super(message);
	}
}
