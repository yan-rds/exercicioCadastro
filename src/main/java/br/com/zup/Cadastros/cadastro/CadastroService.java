package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public void realizarCadastro (CadastroDTO cadastroDTO){
       cadastroRepository.save(instanciarModel(cadastroDTO));
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

    public List<Cadastro> mostrarTodosCadastros (){
        Iterable <Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }

    public List<Cadastro> filtrarMoraSozinho(boolean moraSozinho){
        Iterable <Cadastro> cadastros = cadastroRepository.findAllByMoraSozinho(moraSozinho);
        return (List<Cadastro>) cadastros;
    }

    public List<Cadastro> filtrarTemPet(boolean temPet){
        Iterable <Cadastro> cadastros = cadastroRepository.findAllByTemPet(temPet);
        return (List<Cadastro>) cadastros;
    }

    public List<Cadastro> filtrarIdade(int idade){
        Iterable <Cadastro> cadastros = cadastroRepository.findAllByIdade(idade);
        return (List<Cadastro>) cadastros;
    }

}
