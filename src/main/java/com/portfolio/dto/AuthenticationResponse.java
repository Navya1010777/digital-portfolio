package com.portfolio.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    private AuthenticationResponse(Builder builder) {
        this.token = builder.token;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this);
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
