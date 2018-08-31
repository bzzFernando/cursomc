package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String codID;
	private Integer tpCliente;
	
	
	private List<Endereco> enderecos = new ArrayList<>(); 
	
	private Set<String> telefones = new HashSet<>();
	
	
	//Constructor
	public Cliente() {
		
		
	}

	public Cliente(Integer id, String nome, String email, String codID, TipoCliente tpCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.codID = codID;
		this.tpCliente = tpCliente.getCod();
	}

	
	//Getter e Setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodID() {
		return codID;
	}

	public void setCodID(String codID) {
		this.codID = codID;
	}

	public TipoCliente getTpCliente() {
		return TipoCliente.toEnum(tpCliente);
	}

	public void setTpCliente(TipoCliente tpCliente) {
		this.tpCliente = tpCliente.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	//hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}