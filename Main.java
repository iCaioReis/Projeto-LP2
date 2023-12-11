import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		String dataNasc;
		boolean auxB = true;
		boolean auxB2 = true;
		int menu;

		ArrayList<Bebe> bebes = new ArrayList<Bebe>();

		Scanner scanner = new Scanner(System.in);
		// Menu para a escolha da operação
		do {
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
					System.out.println("Digite o nome do bebe: ");
					String nome = scanner.nextLine();
					System.out.print("Digite o cpf do bebe: ");
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

					System.out.print("Digite a data de nascimento do bebe: ");
					dataNasc = scanner.nextLine();
					// Criação do objeto dentro da coleção genérica
					bebes.add(new Bebe(nome, cpf, dataNasc));
					break;
				case 2:
					System.out.println("------------------------------------------------------");
					System.out.println("Digite o CPF da criança");
					String nomeVacina = scanner.nextLine();
					System.out.println("Digite o dia em que a criança está se vacinando");
					String diaVacina = scanner.nextLine();
					System.out.println("Digite o mês em que a criança está se vacinando");
					String mesVacina = scanner.nextLine();
					System.out.println("Digite o ano em que a criança está se vacinando");
					String anoVacina = scanner.nextLine();
					System.out.println("------------------------------------------------------");
					break;
				case 3:
					int menu2;
					System.err.println("1: exibir todas as crianças registradas");
					System.out.println("2: Exibir vacinas por criança");
					System.out.println("0: Voltar ao menu principal");
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
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
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