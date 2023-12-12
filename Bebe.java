import java.time.LocalDate;

public class Bebe{
	private String nome;
	private int cpf;
	private LocalDate dataNasc;
	
	public Bebe (String nome, int cpf,LocalDate dataNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public LocalDate getdataNasc() {
		return dataNasc;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
}