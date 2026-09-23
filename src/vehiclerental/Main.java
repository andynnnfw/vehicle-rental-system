package vehiclerental;

import vehiclerental.exception.AnoInvalidoException;
import vehiclerental.exception.ItemNaoEncontradoException;
import vehiclerental.exception.ModeloInvalidoException;
import vehiclerental.model.Alugavel;
import vehiclerental.model.Carro;
import vehiclerental.model.Moto;
import vehiclerental.model.Veiculo;
import vehiclerental.service.Estoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        int option = 0;
        while (option!= 6){
            System.out.println("\n=== Locadora de Veículos ===");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Listar veículos");
            System.out.println("3. Alugar veículo");
            System.out.println("4. Devolver veículo");
            System.out.println("5. Remover veículo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1:
                        System.out.println("-- Cadastrar Veículo --");

                            System.out.println("\n-- Cadastrar Veículo --");
                            System.out.println("Selecione o tipo de veículo:");
                            System.out.println("1. Carro");
                            System.out.println("2. Moto");
                            System.out.print("Opção: ");

                            int tipoVeiculo = scanner.nextInt();
                            scanner.nextLine();

                            if (tipoVeiculo == 1){
                                System.out.print("coloque o MODELO do carro: ");
                                String modelo = scanner.nextLine();

                                System.out.print("coloque a PLACA do carro : ");
                                String placa = scanner.nextLine();

                                System.out.print("coloque o ANO do carro: ");
                                int ano = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("coloque a quantidade do NUMERO DE PORTAS (ex: 2, 4): ");
                                int numeroPortas = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    Alugavel veiculo = new Carro(modelo, placa, ano, numeroPortas);
                                    estoque.adicionar(placa, veiculo);
                                    System.out.println("Veículo cadastrado com sucesso!");
                                } catch (AnoInvalidoException | ModeloInvalidoException e) {
                                    System.out.println("Erro ao cadastrar: " + e.getMessage());
                                }
                            } else if (tipoVeiculo == 2) {
                                System.out.print("coloque o MODELO da moto: ");
                                String modelo = scanner.nextLine();

                                System.out.print("coloque a PLACA da moto : ");
                                String placa = scanner.nextLine();

                                System.out.print("coloque o ANO da moto: ");
                                int ano = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("coloque a quantidade de CILINDRADAS (ex: 120, 200): ");
                                int cilindradas = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    Alugavel veiculo = new Moto(modelo, placa, ano, cilindradas);
                                    estoque.adicionar(placa, veiculo);
                                    System.out.println("Veículo cadastrado com sucesso!");
                                } catch (AnoInvalidoException | ModeloInvalidoException e) {
                                    System.out.println("Erro ao cadastrar: " + e.getMessage());
                                }
                            }else {
                                System.out.println("ERRROOOOOOOO");
                            }

                        break;
                    case 2:
                        System.out.println("-- Listar Veículos --");
                        estoque.listarTodos();
                        break;
                    case 3:
                        System.out.print("Introduza a placa do veículo a alugar: ");
                        String placaAlugar = scanner.nextLine();
                        try {
                            Alugavel veiculoAlugar = estoque.buscarPorPlaca(placaAlugar);
                            veiculoAlugar.alugar();
                        }catch (ItemNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Introduza a placa do veículo a devolver: ");
                        String placaDevolver = scanner.nextLine();
                        try {
                            Alugavel veiculoDevolver = estoque.buscarPorPlaca(placaDevolver);
                            veiculoDevolver.devolver();
                        } catch (ItemNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.print("Introduza a placa do veículo a remover: ");
                        String placaRemover = scanner.nextLine();
                        estoque.remover(placaRemover);
                        break;
                    case 6:
                        System.out.println("A encerrar o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            }catch (RuntimeException e){
                System.out.println("opcao invalida!");
                scanner.nextLine();
            }
        }
    }
}
