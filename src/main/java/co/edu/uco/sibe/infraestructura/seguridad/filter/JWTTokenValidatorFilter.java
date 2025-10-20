package co.edu.uco.sibe.infraestructura.seguridad.filter;

import co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * JWTTokenValidatorFilter validates JWT tokens on incoming HTTP requests for protected resources.
 *
 * <p>
 * It parses the JWT from the request header, validates its signature and expiration,
 * extracts user details and authorities, and sets the authentication in the security context.
 * If the token is invalid, it throws a BadCredentialsException.
 * </p>
 *
 * <p>
 * This filter is stateless and does not depend on injected beans.
 * </p>
 */
@Component
public class JWTTokenValidatorFilter extends OncePerRequestFilter {
    /**
     * Validates the JWT from the request header. If valid, sets the authentication in the security context.
     * If not valid, throws a BadCredentialsException.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @param chain the filter chain
     * @throws IOException if an I/O error occurs
     * @throws ServletException if a servlet error occurs
     */
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        var jwt = request.getHeader(SeguridadConstante.JWT_HEADER);

        if (jwt != null) {
            try {
                var key = Keys.hmacShaKeyFor(SeguridadConstante.JWT_KEY.getBytes(StandardCharsets.UTF_8));

                // Parse claims from the JWT
                var claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();
                var username = String.valueOf(claims.get(TextoConstante.USERNAME));
                var authorities = (String) claims.get(TextoConstante.AUTHORITIES);
                // Set the authentication in the security context
                var auth = new UsernamePasswordAuthenticationToken(username, null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e) {
                throw new BadCredentialsException(UtilMensaje.TOKEN_RECIBIDO_INVALIDO);
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * Skips validation for the login endpoint (where no token is expected).
     *
     * @param request the HTTP servlet request
     * @return true if the filter should be skipped for this request
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // Do not validate JWT on the login API endpoint
        return request.getServletPath().equals(TextoConstante.LOGIN_API);
    }
}
