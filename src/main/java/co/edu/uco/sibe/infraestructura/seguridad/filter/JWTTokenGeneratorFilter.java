package co.edu.uco.sibe.infraestructura.seguridad.filter;

import co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante;
import co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * JWTTokenGeneratorFilter creates a JWT token and attaches it to the HTTP response after a successful authentication.
 *
 * <p>
 * This filter extracts user information and authorities from the Spring Security context,
 * builds a signed JWT, and adds it as a response header. The token is later used by the client for
 * subsequent authenticated requests.
 * </p>
 *
 * <p>
 * This filter is stateless and does not depend on any injected beans.
 * </p>
 */
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    /**
     * After successful authentication, generates a JWT token containing user info and authorities,
     * signs it, and attaches it to the HTTP response header for the client to use.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @param chain the filter chain
     * @throws IOException if an I/O error occurs
     * @throws ServletException if a servlet error occurs
     */
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        // Only proceed if there is an authenticated user
        authentication.getPrincipal();
        var key = Keys.hmacShaKeyFor(SeguridadConstante.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        var jwt = Jwts.builder().setIssuer(SeguridadConstante.APP_NAME).setSubject(SeguridadConstante.JWT_TOKEN)
                .claim(SeguridadConstante.EMAIL_PARAMETER, authentication.getName())
                .claim(SeguridadConstante.ID_PARAMETER, authentication.getDetails())
                .claim(SeguridadConstante.AUTHORITIES_PARAMETER, populateAuthorities(authentication.getAuthorities()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + NumeroConstante.TREINTA_MILLONES))
                .signWith(key).compact();

        // Add the JWT as a response header
        response.setHeader(SeguridadConstante.JWT_HEADER, jwt);

        chain.doFilter(request, response);
    }

    /**
     * Only generates the JWT token on login requests.
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // Only apply this filter on the login API endpoint
        return !request.getServletPath().equals(TextoConstante.LOGIN_API);
    }

    /**
     * Helper method to serialize the user's authorities into a comma-separated string.
     *
     * @param collection the granted authorities of the authenticated user
     * @return a comma-separated string of authorities
     */
    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        var authoritiesSet = new HashSet<String>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(TextoConstante.COMMA, authoritiesSet);
    }
}