package br.com.zup.Cadastros.cadastro.dtos;

import javax.validation.constraints.NotBlank;

public class CadastroResumidoDTO {
    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
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
