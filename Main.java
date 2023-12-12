import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		boolean auxB = true;
		boolean auxB2 = true;
		int menu;

		ArrayList<Bebe> bebes = new ArrayList<Bebe>();

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Menu para a escolha da operação
		do {
			limparConsole();

			System.out.println("------------------------------------------------------");
			System.out.println("Escolha uma operação: ");
			System.out.println("1: Registrar bebê.");
			System.out.println("2: Registrar vacina.");
			System.out.println("3: Exibir registros");
			System.out.println("4: Consultar bebês com doses ou reforços pendentes.");
			System.out.println("5: Consultar bebês com doses pendentes por vacina.");
			System.out.println("6: Encerrar o programa");
			System.out.println("------------------------------------------------------");
			menu = scanner.nextInt();

			limparConsole();

			switch (menu) {

				case 1:
					scanner.nextLine();
					System.out.println("Digite o nome da criança: ");
					String nome = scanner.nextLine();
					System.out.print("Digite o cpf da criança: ");
					int cpf = scanner.nextInt();
					// Estrutura de repetição para verificar se existe registro com o mesmo cpf
					for (int i = 0; i < bebes.size(); i++) {
						int aux = bebes.get(i).getCpf();
						if ((cpf == aux) == true) {
							System.err.println("Não é possível adicionar um bebê com mesmo cpf. Operação cancelada.");
							auxB2 = false;
							pressioneEnter();
							limparConsole();
						}
					}
					if (auxB2 == false)
						break;
					scanner.nextLine();

					System.out.print("Digite a data de nascimento(formato dd/mm/aaaa): ");
					String dataNasc = scanner.nextLine();
					LocalDate dataNascFormatada = LocalDate.parse(dataNasc, formatarData);
					// Criação do objeto dentro da coleção genérica
					bebes.add(new Bebe(nome, cpf, dataNascFormatada));
					break;
				case 2:
					System.out.println("------------------------------------------------------");
					System.out.println("Digite o CPF da criança");
					String nomeVacina = scanner.nextLine();
					System.out.print("Digite a data da vacina(formato dd/mm/aaaa): ");
					String dataVacina = scanner.nextLine();
					LocalDate dataVacinaFormatada = LocalDate.parse(dataVacina, formatarData);

					System.out.println("------------------------------------------------------");
					System.out.println("Escolha a vacina");
					System.out.println("1: BCG");
					System.out.println("2: Hepatite B");
					System.out.println("3: Penta/DTP");
					System.out.println("4: VIP/VOP");
					System.out.println("5: Meningocócica");
					System.out.println("------------------------------------------------------");
					break;
				case 3:
					int menu2;
					System.out.println("------------------------------------------------------");
					System.err.println("1: exibir todas as crianças registradas");
					System.out.println("2: Exibir vacinas por criança");
					System.out.println("0: Voltar ao menu principal");
					System.out.println("------------------------------------------------------");
					menu2 = scanner.nextInt();
					limparConsole();

					switch (menu2) {
						case 1:

							break;
						case 2:
							System.out.println("Digite o CPF da criança: ");
							break;

						case 0:
							break;
					}

					break;
				case 4:
					break;
				case 5:
					break;

				case 6:
					System.out.println("Programa encerrado.");
					auxB = false;
					break;
			}
		} while (auxB == true);
	}

	public final static void limparConsole() {
		try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Unix/Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Trate as exceções, se houver
            System.out.println("Erro ao tentar limpar o console: " + e.getMessage());
        }
	}

	public final static void pressioneEnter() {
		// Função para "pausar a aplicação e retornar quando o usuário pressionar a
		// tecla Enter"

		Scanner scanner = new Scanner(System.in);
		System.out.println("\nPressione a tecla Enter para continuar...");
		scanner.nextLine();
	}
}