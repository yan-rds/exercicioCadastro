package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro realizarCadastro (CadastroDTO cadastroDTO){
       return cadastroRepository.save(instanciarModel(cadastroDTO));
    }

    public Cadastro instanciarModel (CadastroDTO cadastroDTO){
        Cadastro cadastro = new Cadastro();
        LocalDate dataAtual = LocalDate.now();
        cadastro.setBairro(cadastroDTO.getBairro());
        cadastro.setCidade(cadastroDTO.getCidade());
        cadastro.setCpf(cadastroDTO.getCpf());
        cadastro.setIdade(cadastroDTO.getIdade());
        cadastro.setNome(cadastroDTO.getNome());
        cadastro.setMoraSozinho(cadastroDTO.isMoraSozinho());
        cadastro.setTemPet(cadastroDTO.isTemPet());
        cadastro.setNomeDoParenteProximo(cadastroDTO.getNomeDoParenteProximo());
        cadastro.setSobrenome(cadastroDTO.getSobrenome());
        cadastro.setDataDoCadastro(dataAtual);

        return cadastro;
    }
}
