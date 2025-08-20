package com.one.foroApi.modelo.acceso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccesoRepository extends JpaRepository<Acceso, Long>{

	UserDetails findByLogin(String username);

}
