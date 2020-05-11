package com.mballem.curso.security.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mballem.curso.security.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.email like :email")
	Usuario findByEmail(@Param("email") String email);

	@Query("select distinct u from Usuario u "
			+ "join u.perfis p "
			+ "where u.email like :desc% "
			+ "OR p.desc like :desc%")
	Page<Usuario> findByEmailOrPerfil(@Param("desc") String desc, Pageable pageable);

	@Query("select u from Usuario u "
			+ "join u.perfis p "
			+ "where u.id = :usuarioId "
			+ "AND p.id IN :perfisId")
	Optional<Usuario> findByIdAndPerfis(@Param("usuarioId") Long usuarioId, @Param("perfisId") Long[] perfisId);
}
