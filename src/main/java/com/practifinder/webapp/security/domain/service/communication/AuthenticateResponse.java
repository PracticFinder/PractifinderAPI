package com.practifinder.webapp.security.domain.service.communication;

import com.practifinder.webapp.security.resource.AuthenticateResource;
import com.practifinder.webapp.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}