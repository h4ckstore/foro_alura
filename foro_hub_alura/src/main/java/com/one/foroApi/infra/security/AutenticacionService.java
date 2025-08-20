package com.one.foroApi.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.one.foroApi.modelo.acceso.AccesoRepository;

@Service
public class AutenticacionService implements UserDetailsService{
	
	@Autowired
	private AccesoRepository accesoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accesoRepository.findByLogin(username);
	}

}
