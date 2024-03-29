package br.com.bidu.aulapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bidu.aulapi.domain.Pessoa;
import br.com.bidu.aulapi.repositories.PessoaRepository;
import br.com.bidu.aulapi.services.exceptions.ObjectNotFoundException;



@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Page<Pessoa> pesquisar(String nomepessoa, Pageable pageable) {
		return pessoaRepository.findByNomepessoaContaining(nomepessoa, pageable);
	}
		
	public List<Pessoa> listarTodas() {
		return pessoaRepository.findAll();
	}

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Pessoa.class.getName()));
	}

	public Pessoa insert(Pessoa obj) {
		obj.getAgendamentos().forEach(c -> c.setPessoa(obj));
		return pessoaRepository.save(obj);
	}

	public Pessoa update(Pessoa obj, Integer id) {
		Pessoa pessoaSalva = find(id);
		
		pessoaSalva.getAgendamentos().clear();
		pessoaSalva.getAgendamentos().addAll(obj.getAgendamentos());
		pessoaSalva.getAgendamentos().forEach(c -> c.setPessoa(pessoaSalva));
		
		BeanUtils.copyProperties(obj, pessoaSalva, "codigo", "agendamentos");
		return pessoaRepository.save(pessoaSalva);
	}

	public void delete(Integer id) {
		find(id);
		pessoaRepository.deleteById(id);
	}

}
