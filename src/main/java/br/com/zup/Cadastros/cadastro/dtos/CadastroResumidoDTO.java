package br.com.zup.Cadastros.cadastro.dtos;

public class CadastroResumidoDTO {
    private String cpf;
    private String nome;
    private String sobrenome;

    public CadastroResumidoDTO(String id, String nome, String sobrenome) {
        this.cpf = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public CadastroResumidoDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
