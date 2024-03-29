package br.com.bidu.aulapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bidu.aulapi.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	public Page<Pessoa> findByNomepessoaContaining(String nomepessoa, Pageable pageable);
}

