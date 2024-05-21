package br.com.brazcubas.hotelSystem.model.entity;

public class Hotel extends AbstractEntity {
    private String nome;
    private String descricao;
    private double preco;
    
    private String reservaCliente;
    private String reservaDataInicio;
    private String reservaDataFim;

    // Construtor sem id
    // Usado para lançar dados no banco de dados caso este ainda não foi persistido. Por isso não temos ID
    public Hotel(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    // Construtor com id
    // Usado para caso o dado já persiste em BD, o ID, então, será usado para buscá-lo
    public Hotel(int id, String nome, String descricao, double preco) {
        super.setId(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    public String getReservaCliente() { return reservaCliente;}
    public void setReservaCliente(String reservaCliente) { this.reservaCliente = reservaCliente;}

    public String getReservaDataInicio() { return reservaDataInicio;}
    public void setReservaDataInicio(String reservaDataInicio) { this.reservaDataInicio = reservaDataInicio;}

    public String getReservaDataFim() { return reservaDataFim;}
    public void setReservaDataFim(String reservaDataFim) { this.reservaDataFim = reservaDataFim;}
}
