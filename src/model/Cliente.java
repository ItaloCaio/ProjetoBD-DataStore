package model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity //Para dizer que é uma entidade
@Table(name="cliente") //Criar uma tabela no bando de dados com nome professor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id // indica chave primaria
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long cpf;
	
	@Column(name="nome", length=50, nullable=false)
	private String nome;
	
	@Column(name="endereco", length=50, nullable=false)
	private String endereco;
	
	@Column(name="senha", length=50, nullable=false)
	private String senha;
	
	@Column(name="saldo", nullable=false)
	private double saldo = 0;
	
	@OneToMany(mappedBy ="cliente")
	private List<Produto> listaProdutos;
	
	@Column(name="nivel", length=50, nullable=false)
	private Integer nivel = 1;
	@Column(name="quant_indicacoes", length=50, nullable=false)
	private Integer quadadeIndicacoes =0;
	
	@ManyToOne
	@JoinColumn(name="idcliente_indicado", referencedColumnName="cpf")
	private Cliente clienteIndicado;
	
	
	
	@OneToMany(mappedBy="clienteIndicado")
	private List<Cliente> listaClientesIndicados;
	
	
//	@OneToOne(mappedBy = "cliente_log")
//	private Login login;
	
//	@JoinColumn(name="indicacao", referencedColumnName="cpf")
//	private Cliente indicacao;
	
	
	public Cliente(Long cpf, String nome, String endereco, double saldo, String senha){
		this.cpf=cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	public Cliente(){
		
	}
	
	
	
//	public Login getLogin() {
//		return login;
//	}
//
//	public void setLogin(Login login) {
//		this.login = login;
//	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getQuadadeIndicacoes() {
		return quadadeIndicacoes;
	}

	public void setQuadadeIndicacoes(Integer quadadeIndicacoes) {
		this.quadadeIndicacoes = quadadeIndicacoes;
	}

	public Cliente getClienteIndicado() {
		return clienteIndicado;
	}

	public void setClienteIndicado(Cliente clienteIndicado) {
		this.clienteIndicado = clienteIndicado;
	}
	
	@XmlTransient
	public List<Cliente> getListaClientesIndicados() {
		return listaClientesIndicados;
	}

	public void setListaClientesIndicados(List<Cliente> listaClientesIndicados) {
		this.listaClientesIndicados = listaClientesIndicados;
	}

	@XmlTransient
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
