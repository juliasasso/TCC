package br.com.bidu.aulapi.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idpessoa;
	private String nomepessoa;
	private String email;
	private String cpf;
	private String rg;
	private String prontuario;
	private String telefone;
	private String senha;
	private String crm;
	
	@JsonIgnoreProperties("pessoa")
	@OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Agendamento> agendamentos;

	public int getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getNomepessoa() {
		return nomepessoa;
	}

	public void setNomepessoa(String nomepessoa) {
		this.nomepessoa = nomepessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.senha = crm;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpessoa;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (idpessoa != other.idpessoa)
			return false;
		return true;
	}

	
	
	
	
}