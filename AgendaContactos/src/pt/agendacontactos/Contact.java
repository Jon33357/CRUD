package pt.agendacontactos;

import java.sql.Date;

public class Contact {
	private int id;
	private String nome;
	private String email;
	private Date data_aniv;
	private long tele;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getData_aniv() {
		return data_aniv;
	}
	public void setData_aniv(Date data_aniv) {
		this.data_aniv = data_aniv;
	}
	public long getTele() {
		return tele;
	}
	public void setTele(long tele) {
		this.tele = tele;
	}
}
