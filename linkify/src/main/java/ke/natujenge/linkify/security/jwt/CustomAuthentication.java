package ke.natujenge.linkify.security.jwt;

import ke.natujenge.linkify.domain.enumarations.IdentityProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;

public class CustomAuthentication implements Authentication {
    private  Collection<GrantedAuthority> authorities;

    private  String details;

    private  Object principal;

    private  boolean authenticated;

    private  String name;

    @Enumerated(EnumType.STRING)
    private IdentityProvider identityProvider;

    private String bearerToken;

    public CustomAuthentication(Collection<GrantedAuthority> authorities, String details, Object principal, boolean authenticated, String name, IdentityProvider identityProvider) {
        this.authorities = authorities;
        this.details = details;
        this.principal = principal;
        this.authenticated = authenticated;
        this.name = name;
        this.identityProvider = identityProvider;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return this.details;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return this.name;
    }

    public IdentityProvider getIdentityProvider() {
        return identityProvider;
    }

    public String getBearerToken() {
        return bearerToken;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
