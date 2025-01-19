package ma.xproce.servicesecurity.config;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.xproce.servicesecurity.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String Username;
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        jwt= authHeader.substring(7);
        System.out.println(jwt);
        Username = jwtUtil.extractUsername(jwt);
        if(Username!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(Username);
            if (jwtUtil.validateToken(jwt, Username)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }


    //    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwt = null;
//
//        // Check if the authorization header is present and starts with "Bearer "
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7); // Extract the JWT token from the header
//            try {
//                username = jwtUtil.extractUsername(jwt); // Extract username from the JWT token
//            } catch (Exception e) {
//                // Log invalid JWT token error
//                logger.error("Invalid JWT token: " + e.getMessage());
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
//                return; // Don't proceed further if the token is invalid
//            }
//        } else {
//            // Log that no authorization header was found
//
//            logger.warn("Authorization header is missing or malformed");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization header is missing or malformed");
//            return; // Don't proceed if the token is missing
//        }
//
//        // If username is found and the context doesn't have an authentication
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//            // Validate the token
//            if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            } else {
//                // Log invalid token validation failure
//                logger.error("JWT validation failed for token: " + jwt);
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT validation failed");
//                return; // Don't proceed if token validation fails
//            }
//        }
//
//        // Proceed with the filter chain if authentication is successful or token is valid
//        chain.doFilter(request, response);
//    }
}
