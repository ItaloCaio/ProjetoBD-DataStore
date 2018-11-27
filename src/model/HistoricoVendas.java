package model;

import java.io.Serializable;

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

@XmlRootElement
@Entity 
@Table(name="historico")
public class HistoricoVendas implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_produto", length=20, nullable = false)
	private String nomeProduto;
	@Column(name="quantidade", length=20, nullable = false)
	private int quantidade;
	@Column(name="valor", length=20, nullable = false)
	private double valor;
	@Column(name="cpf_cliente", length=20, nullable = false)
	private Long cpfCliente;
	
	@ManyToOne 
	@JoinColumn(name="id_loja", referencedColumnName="id")
	private Loja loja;

	
	
	
	
	public HistoricoVendas(String nomeProduto, int quantidade, double valor, Long cpfCliente, Loja loja) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.cpfCliente = cpfCliente;
		this.loja = loja;
	}
	public HistoricoVendas(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	
	


}
