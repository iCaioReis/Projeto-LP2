import java.io.FileInputStream;
import java.io.FileReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		boolean auxB = true;
		boolean auxB2 = true;
		int menu;

		Main programa = new Main();
		ArrayList<Bebe> bebes = programa.carregarDados();

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
			System.out.println("0: Encerrar o programa e salvar dados.");
			System.out.println("------------------------------------------------------");
			menu = scanner.nextInt();

			limparConsole();

			switch (menu) {

				case 1:
					System.out.println("Digite o nome da criança: ");
					String nome = scanner.next();
					System.out.print("Digite o cpf da criança: ");
					String cpf = scanner.next();
					// Estrutura de repetição para verificar se existe registro com o mesmo cpf
					for (int i = 0; i < bebes.size(); i++) {
						String aux = bebes.get(i).getCpf();
						if (cpf.equals(aux)) {
							System.err.println("Não é possível adicionar um bebê com mesmo cpf. Operação cancelada.");
							auxB2 = false;
							pressioneEnter();
							limparConsole();
							break;
						}
					}
					if (auxB2 == false){
						break;
					}

					System.out.print("Digite a data de nascimento(formato dd/mm/aaaa): ");
					String dataNasc = scanner.next();
					LocalDate dataNascFormatada = LocalDate.parse(dataNasc, formatarData);
					// Criação do objeto dentro da coleção genérica
					bebes.add(new Bebe(nome, cpf, dataNascFormatada));
					break;
				case 2:
					System.out.println("------------------------------------------------------");
					System.out.println("Digite o CPF da criança");
					String cpfAux = scanner.next();

					int intAux = -1;

					for (int i = 0; i < bebes.size(); i++) {
						if (cpfAux.equals(bebes.get(i).getCpf()))
							intAux = intAux + 1 + i;
					}

					if (intAux == -1) {
						System.err.println("Cpf não encontrado. Operação cancelada.");
						pressioneEnter();
						limparConsole();
						break;

					}
					limparConsole();
					System.out.println("------------------------------------------------------");
					System.out.println("Escolha a vacina");
					System.out.println("1: BCG");
					System.out.println("2: Hepatite B");
					System.out.println("3: Penta/DTP");
					System.out.println("4: VIP/VOP");
					System.out.println("5: Meningocócica");
					System.out.println("------------------------------------------------------");
					int escolha = scanner.nextInt();

					switch (escolha) {
						case 1:

							if (bebes.get(intAux).getBCG() != 1) {
								System.out.println("Dose resgistrada com sucesso.");
								bebes.get(intAux).setBCG(1);
							} else {
								System.err.println("Dose única já registrada, operação cancelada.");
								break;
							}
							pressioneEnter();
							break;

						case 2:
							if (bebes.get(intAux).getHepatite_B() != 1) {
								System.out.println("Dose resgistrada com sucesso.");
								bebes.get(intAux).setHepatite_B(1);
							} else {
								System.err.println("Dose única já registrada, operação cancelada.");
								break;
							}
							pressioneEnter();
							break;

						case 3:
							int dose = bebes.get(intAux).getPentaDTP();
							int mesNasc = bebes.get(intAux).getdataNasc().getMonthValue();
							int anoNasc = bebes.get(intAux).getdataNasc().getYear();
							if (((12 - mesNasc) >= 2||(2023-anoNasc)>= 1) && dose == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setPentaDTP(1);
								break;
							} else if (((12 - mesNasc) >= 4||(2023-anoNasc)>= 1) && dose == 1) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setPentaDTP(2);
								break;
							} else if (((12 - mesNasc) >= 6||(2023-anoNasc)>= 1) && dose == 2) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setPentaDTP(3);
								break;
							} else {
								System.err.println(
										"Condições para a aplicação da dose não satisfeitas. Operação cancelada.");
							}
							pressioneEnter();
							break;
						case 4:
							int anoNasc1 = bebes.get(intAux).getdataNasc().getYear();
							int dose1 = bebes.get(intAux).getVIP_VOP();
							int mesNasc1 = bebes.get(intAux).getdataNasc().getMonthValue();
							
							if (((12 - mesNasc1) >= 2||(2023-anoNasc1)>= 1) && dose1 == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setVIP_VOP(1);
								break;
							} else if (((12 - mesNasc1) >= 4||(2023-anoNasc1)>= 1) && dose1 == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setVIP_VOP(2);
								break;
							} else if (((12 - mesNasc1) >= 6||(2023-anoNasc1)>= 1) && dose1 == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setVIP_VOP(3);
								break;
							} else if ((anoNasc1 - 2023) >= 1 && dose1 == 3) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setVIP_VOP(4);
								break;
							} else {
								System.err.println(
										"Condições para a aplicação da dose não satisfeitas. Operação cancelada.");
							}
							pressioneEnter();
							break;

						case 5:
							int anoNasc2 = bebes.get(intAux).getdataNasc().getYear();
							int dose2 = bebes.get(intAux).getMeningococica();
							int mesNasc2 = bebes.get(intAux).getdataNasc().getMonthValue();
							
							if (((12 - mesNasc2) >= 2||(2023-anoNasc2)>= 1) && dose2 == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setMeningococica(1);
								break;
							} else if (((12 - mesNasc2) >= 3||(2023-anoNasc2)>= 1) && dose2 == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setMeningococica(2);
								break;
							} else if (((12 - mesNasc2) >= 5||(2023-anoNasc2)>= 1) && dose2 == 0) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setMeningococica(3);
								break;
							} else if ((anoNasc2 - 2023) >= 1 && dose2 == 3) {
								System.out.println("Dose registrada com sucesso.");
								bebes.get(intAux).setMeningococica(4);
								break;
							} else {
								System.err.println(
										"Condições para a aplicação da dose não satisfeitas. Operação cancelada.");
							}
							pressioneEnter();
						break;
					}
					break;
				case 3:
					listarBebes(bebes);
					pressioneEnter();
					break;
				case 4:
					consultarBebesPendentes(bebes);
					break;
				case 5:
					consultarBebesPendentesPorVacina(bebes);
					break;

				case 0:
					System.out.println("Programa encerrado.");
					scanner.close();
					try {
						PrintWriter fluxoArquivo = new PrintWriter("crianca.txt");
						for (Bebe bebe: bebes){
							fluxoArquivo.print(bebe.getNome() + "|");
							fluxoArquivo.print(bebe.getCpf() + "|");
							fluxoArquivo.print(bebe.getdataNasc() + "|");
							fluxoArquivo.print(bebe.getBCG() + "|");
							fluxoArquivo.print(bebe.getHepatite_B() + "|");
							fluxoArquivo.print(bebe.getPentaDTP() + "|");
							fluxoArquivo.print(bebe.getVIP_VOP() + "|");
							fluxoArquivo.print(bebe.getMeningococica() + System.lineSeparator());
						}
						fluxoArquivo.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					auxB = false;
					break;
			}
		} while (auxB == true);
	}
	
	private static void consultarBebesPendentes(ArrayList<Bebe> bebes) {
		for (Bebe bebe : bebes) {
			System.out.println("------------------------------------");
			System.out.println("Bebe: " + bebe.getNome());
			System.out.println("CPF: " + bebe.getCpf());
			bebe.dosesPendentes();
		}
		pressioneEnter();
		limparConsole();
	}
	// Método para consultar bebês com doses pendentes por vacina
	private static void consultarBebesPendentesPorVacina(ArrayList<Bebe> bebes) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha a vacina para consulta:");
		System.out.println("1: BCG\n2: Hepatite B\n3: Penta/DTP\n4: VIP/VOP\n5: Meningocócica");
		int escolhaVacina = scanner.nextInt();
		String nomeVacina = "";
		
		if (escolhaVacina == 1) {
			nomeVacina = "BCG";
		}else if (escolhaVacina == 2) {
			nomeVacina = "Hepatite B";
		}else if (escolhaVacina == 3) {
			nomeVacina = "Penta/DTP";
		}else if (escolhaVacina == 4) {
			nomeVacina = "VIP/VOP";
		}else if (escolhaVacina == 5) {
			nomeVacina = "Meningocócica";
		}

		System.out.println("------------------------------------------------------");
		System.out.println("Bebes com a vacina '" + nomeVacina + "' Pendentes");
        
		for (Bebe bebe : bebes) {
			if (bebe.temDosePendentePorVacina(escolhaVacina)) {
				System.out.println("Nome: " + bebe.getNome() + "\nCPF: " + bebe.getCpf());
				System.out.println("------------------------------------------------------");
			}
		}
		pressioneEnter();
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

	private static void listarBebes(ArrayList<Bebe> bebes) {
        System.out.println("Lista de Bebês:");

        for (Bebe bebe : bebes) {
			int totalDeVacinas = bebe.getBCG() + bebe.getHepatite_B() + bebe.getPentaDTP() + bebe.getVIP_VOP() + bebe.getMeningococica();
			float percentualImunizacao = ((float) totalDeVacinas / 12) * 100;

			System.out.println(totalDeVacinas);

			String numeroFormatado = String.format("%.2f", percentualImunizacao);

            System.out.println("CPF: " + bebe.getCpf());
            System.out.println("Nome: " + bebe.getNome());
            System.out.println("Data de Nascimento: " + bebe.getdataNasc());
			System.out.println("Bebe " + numeroFormatado + "% imunizado!");
            System.out.println("-----------------------");
        }
    }

	private ArrayList<Bebe> carregarDados() {
    ArrayList<Bebe> bebes = new ArrayList<Bebe>();
    try {
        FileReader fluxoArquivo = new FileReader("crianca.txt");
        Scanner fluxo = new Scanner(fluxoArquivo);
        while (fluxo.hasNext()) {
            String linha = fluxo.nextLine();

            String[] partes = linha.split("\\|");
            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataNascFormatada = LocalDate.parse(partes[2], formatarData);
            bebes.add(new Bebe(partes[0], partes[1], dataNascFormatada, Integer.parseInt(partes[3]),
                    Integer.parseInt(partes[4]), Integer.parseInt(partes[5]), Integer.parseInt(partes[6]),
                    Integer.parseInt(partes[7])));
            System.out.println(linha);
        }
        fluxo.close();
        fluxoArquivo.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return bebes;
	}
}