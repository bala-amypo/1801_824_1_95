package com.example.demo.security;

import jakarta.servlet.*;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(req, res);
    }
}
