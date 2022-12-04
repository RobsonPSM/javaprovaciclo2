package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import actions.*;
import model.Aluno;

public class Menu {
	public static void main(String[] args) {
		int menu = 0;
		Scanner s = new Scanner(System.in); 
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		do {
			List<Aluno> alunol = null;
			Aluno aluno = new Aluno();
			System.out.println("\n****MENU****\n1- Inserir Aluno\n2- Deletar Aluno\n3- Pesquisar Aluno\n4- Pesquisar Aluno pela primeira letra\n5- Listar Alunos\n6- Atualizar Aluno\n7- Sair" );
			System.out.println("Informe a opção: ");
			menu = s.nextInt();
			clearBuffer(s);
			switch(menu) {
				case 1:
					System.out.println("Informe o nome: ");
					aluno.setNome(s.nextLine());
					System.out.println("Informe o email: ");
					aluno.setEmail(s.nextLine());
					System.out.println("Informe o endereco: ");
					aluno.setEndereco(s.nextLine());
					System.out.println("Informe o CPF: ");
					aluno.setCpf(s.nextLine());
					System.out.println("Informe a data de nascimento: ");
					try {
					aluno.setDatanascimento(f.parse(s.nextLine()));
					 } catch (ParseException e) {
						 e.printStackTrace();
				       }
					clearBuffer(s);
					System.out.println("Informe a naturalidade: ");
					aluno.setNaturalidade(s.nextLine());
					InserirAluno.insere(aluno);
					break;
				case 2:
					System.out.println("Informe o Id do registro que deseja deleta: ");
					aluno.setId(s.nextLong());
					clearBuffer(s);
					RemoverAluno.remover(aluno);
					break;
				case 3:
					System.out.println("Informe o Id do registro que deseja pesquisar: ");
					aluno.setId(s.nextLong());
					clearBuffer(s);
					aluno = BuscarAluno.buscarAluno(aluno);
					System.out.println("Nome: "+ aluno.getNome());
					System.out.println("Email: " + aluno.getEmail() );
					System.out.println("Endereço: " + aluno.getEndereco());
					System.out.println("Naturalidade: " + aluno.getNaturalidade());
					System.out.println("Data de Nascimento: " + aluno.getDatanascimento());
					System.out.println("CPF: " + aluno.getCpf());
					break;
				case 4:
					System.out.println("Informe a primeira leitra do nome que busca: ");
					String letra = s.nextLine();
					alunol = BuscarPrimeiraLetra.buscarPrimeiraLetra(letra);
					for(Aluno al : alunol) {
						System.out.println("Nome: " + al.getNome());
						System.out.println("Email: " + al.getEmail());
						System.out.println("Endereco: " + al.getEndereco());
						System.out.println("Data de Nascimento: " + al.getDatanascimento());
						System.out.println("CPF: " + al.getCpf());
						System.out.println("Naturalidade: " + al.getNaturalidade());
						System.out.println("\n\n");
					}
					break;
				case 5:
					alunol = ListarAlunos.listarAlunos();
					for (Aluno al : alunol){
						System.out.println("Nome: " + al.getNome());
						System.out.println("Email: " + al.getEmail());
						System.out.println("Endereco: " + al.getEndereco());
						System.out.println("Data de Nascimento: " + al.getDatanascimento());
						System.out.println("CPF: " + al.getCpf());
						System.out.println("Naturalidade: " + al.getNaturalidade());
						System.out.println("\n\n");
					}
					alunol = null;
					break;
				case 6:
					int yorn = 0;
					System.out.println("Informe o Id que deseja atualizar: ");
					aluno.setId(s.nextLong());
					clearBuffer(s);
					aluno = BuscarAluno.buscarAluno(aluno);
					
					System.out.println("Deseja altera o nome?\n1-Sim\n2-Não\nInforme a opção: ");
					yorn = Integer.parseInt(s.nextLine());
					if(yorn==1) {
						System.out.println("Informe o nome: ");
						aluno.setNome(s.nextLine());
					}
					
					System.out.println("Deseja altera o email?\n1-Sim\n2-Não\nInforme a opção: ");
					yorn = Integer.parseInt(s.nextLine());
					if(yorn==1) {
						System.out.println("Informe o email: ");
						aluno.setEmail(s.nextLine());
					}
					
					System.out.println("Deseja altera o endereço?\n1-Sim\n2-Não\nInforme a opção: ");
					yorn = Integer.parseInt(s.nextLine());
					if(yorn==1) {
						System.out.println("Informe o endereco: ");
						aluno.setEndereco(s.nextLine());
					}
					
					System.out.println("Deseja altera o naturalidade?\n1-Sim\n2-Não\nInforme a opção: ");
					yorn = Integer.parseInt(s.nextLine());
					if(yorn==1) {
						System.out.println("Informe a naturalidade: ");
						aluno.setEndereco(s.nextLine());
					}
					
					System.out.println("Deseja altera o CPF?\n1-Sim\n2-Não\nInforme a opção: ");
					yorn = Integer.parseInt(s.nextLine());
					if(yorn==1) {
						System.out.println("Informe o CPF: ");
						aluno.setEndereco(s.nextLine());
					}
					
					System.out.println("Deseja altera o Data de nascimento?\n1-Sim\n2-Não\nInforme a opção: ");
					yorn = Integer.parseInt(s.nextLine());
					if(yorn==1) {
						System.out.println("Informe a Data de nascimento: ");
						aluno.setEndereco(s.nextLine());
					}
					AlterarAluno.altera(aluno);
					aluno = null;
					break;
				case 7:
					System.out.println("Obrigado por utilizar meu programa!");
					break;
			}
		}while(menu!=7);	
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
	}
}
