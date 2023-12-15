import java.time.LocalDate;

public class Bebe{
	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private int BCG;
	private int Hepatite_B;
	private int PentaDTP;
	private int VIP_VOP;
	private int Meningococica;
	
	
	public Bebe (String nome, String cpf,LocalDate dataNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public LocalDate getdataNasc() {
		return dataNasc;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public int getBCG() {
		return BCG;
	}
	
	public int getHepatite_B() {
		return Hepatite_B;
	}
	
	public int getPentaDTP() {
		return PentaDTP;
	}
	
	public int getVIP_VOP() {
		return VIP_VOP;
	}
	
	public int getMeningococica() {
		return Meningococica;
	}
	
	
	public void setBCG(int BCG) {
		this.BCG = BCG;
	}
	
	public void setHepatite_B(int Hepatite_B) {
		this.Hepatite_B = Hepatite_B;
	}
	
	public void setPentaDTP(int PentaDTP) {
		this.PentaDTP = PentaDTP;
	}
	
	public void setVIP_VOP(int VIP_VOP) {
		this.VIP_VOP = VIP_VOP;
	}
	
	public void setMeningococica(int Meningococica) {
		this.Meningococica = Meningococica;
	}

    public boolean temDosesPendentes() {
        return getBCG() != 1 || getHepatite_B() != 1 || getPentaDTP() < 3 || getVIP_VOP() < 4 || getMeningococica() < 4;
    }

    
    public void dosesPendentes() {
		System.out.println("Vacinas pendentes: ");
		if (this.getBCG() < 1) {
			 System.out.println("BCG - Dose única pendente");
		}
		if (this.getHepatite_B() < 1) {
			System.out.println("Hepatite_B  - Dose única pendente");
		}
		if (this.getPentaDTP() < 3) {
			System.out.println("Penta/DTP - " + (3 - this.getPentaDTP()) + " dose(s) pendente(s)");
		}
		if (this.getVIP_VOP() < 4) {
			int pendente = 4 - this.getVIP_VOP();
			if (pendente == 1) {
				System.out.println("VIP/VOP - dose de reforço pendente");
			}else {
				System.out.println("VIP/VOP - " + (pendente - 1) + " dose(s) pendente(s) + 1 dose de reforço");
			}
			System.out.println("BCG");
		}
		if (this.getMeningococica() < 3 ){
			int pendente = 3 - this.getVIP_VOP();
			if (pendente == 1) {
				System.out.println("Meningocócica - dose de reforço pendente");
			}else {
				System.out.println("Meningocócica - " + (pendente - 1) + " dose(s) pendente(s) + 1 dose de reforço");
			}
		}
    }

    
}

   
