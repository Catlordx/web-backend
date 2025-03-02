package org.jianwen.webbackend.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jianwen.webbackend.util.JwtUtil;

import java.io.IOException;
import java.net.http.HttpResponse;

public class JwtFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO just for test and it needs to be deleted when all the api are ready!
        if (request.getRequestURI().startsWith("/api/users/")){
            chain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            String username = JwtUtil.getUsernameFromToken(token);
            if (username != null) {
                request.setAttribute("username", username);
                chain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid token");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token is missing");
        }

    }
}
