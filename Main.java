import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class Main{
	public static void main (String[]args) {
		
		String dataNasc;
		boolean auxB = true;
		boolean auxB2 = true;
		int auxI;
		
		ArrayList <Bebe> bebes = new ArrayList<Bebe>();
		
		Scanner s = new Scanner(System.in);
		//Menu para a escolha da operação
		do {
			System.out.println("Escolha uma operação: ");
			System.out.println("1: Registrar bebê.");
			System.out.println("2: Selecionar bebê para aplicação de vacina.");
			System.out.println("3: Consultar dados vacinais do bebê.");
			System.out.println("4: Consultar bebês com doses ou reforços pendentes.");
			System.out.println("5: Consultar bebês com doses pendentes por vacina.");
			System.out.println("6: Encerrar o programa");
			auxI = s.nextInt();
			
				
			
			switch (auxI) {
			
			case 1:
				s.nextLine();
				
				System.out.println("Digite o nome do bebe: ");
				String nome = s.nextLine();
				System.out.print("Digite o cpf do bebe: ");
				int cpf = s.nextInt();
				//Estrutura de repetição para verificar se existe registro com o mesmo cpf
				for(int i = 0; i < bebes.size(); i++) {
						int aux = bebes.get(i).getCpf();
						if((cpf == aux) == true) {
							System.err.println("Não é possível adicionar um bebê com mesmo cpf. Operação cancelada.");
							auxB2 = false;
						}
					}
				if(auxB2 == false)
					break;
				s.nextLine();
				
				System.out.print("Digite a data de nascimento do bebe: ");
				dataNasc = s.nextLine();
				//Criação do objeto dentro da coleção genérica
				bebes.add(new Bebe(nome, cpf, dataNasc));
				break;
			
			case 6:
				System.out.println("Programa encerrado.");
				auxB = false;
				break;
			}
		}while(auxB == true);
	}
}