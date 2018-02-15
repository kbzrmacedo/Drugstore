package br.com.drogaria.domain;

public class Fabricante {
	private Long codigo; //int e long possuem valores 0 como padr�o, enquanto Long possui null como padr�o.
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String saida = codigo +  "-" + descricao;
		return saida;
	}
}
