package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity 
@Table(name="loja")
public class Loja implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name="nome", length=20, nullable = false)
	private String nome;
	
	@OneToOne
	@JoinColumn(name="loja_idrendimentos", referencedColumnName="id")
	private Rendimentos rendimentos;
	
	@OneToMany(mappedBy = "loja")
	private List<HistoricoVendas> historico;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rendimentos getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(Rendimentos rendimentos) {
		this.rendimentos = rendimentos;
	}
	@XmlTransient
	public List<HistoricoVendas> getHistorico() {
		return historico;
	}

	public void setHistorico(List<HistoricoVendas> historico) {
		this.historico = historico;
	}
	
	
	
}

