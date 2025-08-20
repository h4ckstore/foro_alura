package com.one.foroApi.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.one.foroApi.modelo.acceso.AccesoRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class SecurityFilter extends OncePerRequestFilter{
	
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AccesoRepository accesoRepository;
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //Obtener el token del header
        var autHeader = request.getHeader("Authorization");
        if (autHeader!=null){
            var token=autHeader.replace("Bearer ","");
            var subject =tokenService.getSubject(token);
            if(subject !=null){
                //Token valido
                var acceso=accesoRepository.findByLogin(subject);
                var authentication= new UsernamePasswordAuthenticationToken(acceso,
                        null,acceso.getAuthorities());//forzamos inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }

        filterChain.doFilter(request,response);

    }


}
