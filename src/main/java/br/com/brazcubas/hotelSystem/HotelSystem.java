package br.com.brazcubas.hotelSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.brazcubas.hotelSystem.controller.HotelController;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;
import br.com.brazcubas.hotelSystem.view.HotelView;

public class HotelSystem {
    private List<Hotel> hoteis;
    private Scanner scanner;
    public HotelController controller;
    public HotelView view;

    public HotelSystem(HotelController controller, HotelView view, Scanner scanner) {
        this.hoteis = new ArrayList<>();
        this.controller = controller;
        this.view = view;
        this.scanner = scanner;
    }

    public void adicionarHotel(Hotel hotel) {
        hoteis.add(hotel);
    }

    public void removerHotel(Hotel hotel) {
        hoteis.remove(hotel);
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void realizarReserva(Hotel hotel, Long cliente, String nomeCliente, String emailCliente, String dataInicio, String dataFim) {
        hotel.reservar(cliente, nomeCliente, emailCliente, dataInicio, dataFim);
    }

    public void cancelarReserva(Hotel hotel, Long cliente) {
        hotel.cancelarReserva(cliente);
    }

    // Métodos de Sistema
    public void iniciar() {
        Long opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextLong();
            switch (opcao.intValue()) {
                case 1 -> adicionarHotel();
                case 2 -> listarHoteis();
                case 3 -> atualizarHotel();
                case 4 -> {
                    System.out.println("Digite o nome do hotel a ser removido: ");
                    String nome = scanner.nextLine();
                    Hotel hotelARemover = buscarHotelPorNome(nome);
                    if (hotelARemover != null) {
                        removerHotel(hotelARemover);
                    } else {
                        System.out.println("Hotel não encontrado!");
                    }
                }
                case 5 -> {
                    System.out.println("Digite o nome do hotel a ser buscado: ");
                    String nome = scanner.nextLine();
                    Hotel hotelEncontrado = buscarHotelPorNome(nome);
                    if (hotelEncontrado != null) {
                        System.out.println("Hotel encontrado: " + hotelEncontrado.getNome());
                    } else {
                        System.out.println("Hotel não encontrado!");
                    }
                }
                case 6 -> {
                    System.out.println("Digite o nome do hotel a ser reservado: ");
                    String nome = scanner.nextLine();
                    Hotel hotelAReservar = buscarHotelPorNome(nome);
                    if (hotelAReservar != null) {
                        System.out.println("Digite o ID do cliente: ");
                        Long cliente = scanner.nextLong();
                        scanner.nextLine(); // Limpar buffer
                        System.out.println("Digite o nome do cliente: ");
                        String nomeCliente = scanner.nextLine();
                        System.out.println("Digite o email do cliente: ");
                        String emailCliente = scanner.nextLine();
                        System.out.println("Digite a data de início da reserva (formato YYYY-MM-DD): ");
                        String dataInicio = scanner.nextLine();
                        System.out.println("Digite a data de fim da reserva (formato YYYY-MM-DD): ");
                        String dataFim = scanner.nextLine();
                        realizarReserva(hotelAReservar, cliente, nomeCliente, emailCliente, dataInicio, dataFim);
                    } else {
                        System.out.println("Hotel não encontrado!");
                    }
                }
                case 7 -> {
                    System.out.println("Digite o nome do hotel a cancelar a reserva: ");
                    String nome = scanner.nextLine();
                    Hotel hotelACancelar = buscarHotelPorNome(nome);
                    if (hotelACancelar != null) {
                        System.out.println("Digite o ID do cliente: ");
                        Long cliente = scanner.nextLong();
                        cancelarReserva(hotelACancelar, cliente);
                    } else {
                        System.out.println("Hotel não encontrado!");
                    }
                }
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção invalida.");
            }
        } while (opcao != 0);
    }

    // Restante do código...
}
