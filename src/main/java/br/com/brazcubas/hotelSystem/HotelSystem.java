package br.com.brazcubas.hotelSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelSystem {
    private List<Hotel> hoteis;
    private Scanner scanner = new Scanner(System.in);

    public HotelSystem() {
        this.hoteis = new ArrayList<>();
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

    public void realizarReserva(Hotel hotel, String cliente, String dataInicio, String dataFim) {
        hotel.setReservaCliente(cliente);
        hotel.setReservaDataInicio(dataInicio);
        hotel.setReservaDataFim(dataFim);
    }

    public void cancelarReserva(Hotel hotel) {
        hotel.setReservaCliente(null);
        hotel.setReservaDataInicio(null);
        hotel.setReservaDataFim(null);
    }

    // Métodos de Sistema
    public void iniciar() {
        Long opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextLong();
            switch(opcao.intValue()) {
                case 1 -> adicionarHotel();
                case 2 -> listarHoteis();
                case 3 -> atualizarHotel();
                case 4 -> removerHotel();
                case 5 -> buscarHotel();
                case 6 -> realizarReserva();
                case 7 -> cancelarReserva();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção invalida.");
            }
        } while(opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("======= MENU =======");
        System.out.println("|---- CADASTRO DE HOTEIS ----");
        System.out.println("|> 1. Adicionar Hotel");
        System.out.println("|> 2. Listar Hoteis");
        System.out.println("|> 3. Atualizar Hotel");
        System.out.println("|> 4. Remover Hotel");
        System.out.println("|> 5. Buscar Hotel");
        System.out.println("|---- RESERVAS ----");
        System.out.println("|> 6. Realizar Reserva");
        System.out.println("|> 7. Cancelar Reserva");
        System.out.println("|> 0. Sair");
        System.out.println("====================");
        System.out.println("Escolha uma opção: ");
    }

    private void adicionarHotel() {
        scanner.nextLine(); // Limpar buffer
        System.out.println("Digite o nome do Hotel:");
        String nome = scanner.nextLine();
        // Aqui você pode adicionar mais informações sobre o hotel, como endereço, número de quartos, etc.

        Hotel novoHotel = new Hotel(nome);
        adicionarHotel(novoHotel);
        System.out.println("Hotel adicionado com sucesso.");
    }

    private void listarHoteis() {
        System.out.println("=== Hoteis Cadastrados ===");
        List<Hotel> hoteis = getHoteis();
        for (Hotel hotel : hoteis) {
            System.out.println(hotel.getNome());
        }
        System.out.println("===========================");
    }

    private void atualizarHotel() {
        System.out.println("Digite o nome do hotel a ser atualizado: ");
        String nome = scanner.nextLine();
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                System.out.println("Digite o novo nome do hotel: ");
                String novoNome = scanner.nextLine();
                hotel.setNome(novoNome);
                System.out.println("Hotel atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Hotel não encontrado!");
    }

    private void removerHotel() {
        System.out.println("Digite o nome do hotel a ser removido: ");
        String nome = scanner.nextLine();
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                removerHotel(hotel);
                System.out.println("Hotel removido com sucesso.");
                return;
            }
        }
        System.out.println("Hotel não encontrado!");
    }

    private void buscarHotel() {
        System.out.println("Digite o nome do hotel a ser buscado: ");
        String nome = scanner.nextLine();
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                System.out.println("Hotel encontrado: " + hotel.getNome());
                return;
            }
        }
        System.out.println("Hotel não encontrado!");
    }

    private void realizarReserva() {
        System.out.println("Digite o nome do hotel para a reserva: ");
        String nome = scanner.nextLine();
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                System.out.println("Digite o nome do cliente: ");
                String cliente = scanner.nextLine();
                System.out.println("Digite a data de início da reserva (formato: dd/mm/aaaa): ");
                String dataInicio = scanner.nextLine();
                System.out.println("Digite a data de fim da reserva (formato: dd/mm/aaaa): ");
                String dataFim = scanner.nextLine();
                realizarReserva(hotel, cliente, dataInicio, dataFim);
                System.out.println("Reserva realizada com sucesso.");
                return;
            }
        }
        System.out.println("Hotel não encontrado!");
    }

    private void cancelarReserva() {
        System.out.println("Digite o nome do hotel para cancelar a reserva: ");
        String nome = scanner.nextLine();
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                cancelarReserva(hotel);
                System.out.println("Reserva cancelada com sucesso.");
                return;
            }
        }
        System.out.println("Hotel não encontrado!");
    }
}
