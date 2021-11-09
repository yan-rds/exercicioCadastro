package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import br.com.zup.Cadastros.cadastro.dtos.CadastroResumidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void cadastrarPessoa (@RequestBody @Valid CadastroDTO cadastroDTO){
        cadastroService.realizarCadastro(cadastroDTO);
    }

    @GetMapping("/{cpf}")
    public CadastroDTO todosOsDadosCadastroEspecifico (@PathVariable String cpf){
        Cadastro cadastroEncontrado = cadastroService.encontrarUmCadastro(cpf);
        CadastroDTO cadastroDTOEncontrado = new CadastroDTO();
        cadastroDTOEncontrado.setBairro(cadastroEncontrado.getBairro());
        cadastroDTOEncontrado.setCidade(cadastroEncontrado.getCidade());
        cadastroDTOEncontrado.setCpf(cadastroEncontrado.getCpf());
        cadastroDTOEncontrado.setIdade(cadastroEncontrado.getIdade());
        cadastroDTOEncontrado.setNome(cadastroEncontrado.getNome());
        cadastroDTOEncontrado.setMoraSozinho(cadastroEncontrado.isMoraSozinho());
        cadastroDTOEncontrado.setTemPet(cadastroEncontrado.isTemPet());
        cadastroDTOEncontrado.setNomeDoParenteProximo(cadastroEncontrado.getNomeDoParenteProximo());
        cadastroDTOEncontrado.setSobrenome(cadastroEncontrado.getSobrenome());

        return cadastroDTOEncontrado;

    }

    @GetMapping
    public List<CadastroResumidoDTO> todosOsCadastros (@RequestParam Optional<Boolean> moraSozinho,
                                            @RequestParam Optional<Boolean> temPet,
                                            @RequestParam Optional<Integer> idade){
        List <CadastroResumidoDTO> cadastros = new ArrayList<>();
        if (moraSozinho.isPresent())
        for (Cadastro cadastro : cadastroService.filtrarMoraSozinho(moraSozinho.get())){
            cadastros.add(new CadastroResumidoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
        }
        else if (temPet.isPresent()){
            for (Cadastro cadastro : cadastroService.filtrarTemPet(temPet.get())){
                cadastros.add(new CadastroResumidoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
            }
        }
        else if (idade.isPresent()){
            for (Cadastro cadastro : cadastroService.filtrarIdade(idade.get())){
                cadastros.add(new CadastroResumidoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
            }
        }
        else {
            for (Cadastro cadastro : cadastroService.mostrarTodosCadastros()){
                cadastros.add(new CadastroResumidoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
            }
        }
        return cadastros;
    }


    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro (@PathVariable String cpf){
        cadastroService.removerCadastro(cpf);
    }

    /*
    todo  1 - crie um metodo para cadastrar uma pessoa.
      Para um cadastro todo os campos são obrigatórios EXCETO o campo dataDoCadastro que deve ser preenchido pelo proprio sistema e o client não deve saber da existencia desse campo
     todo 2 - Faça um metodo que retorna a lista inteira de cadastros ou filtrado por cadastros que moram sozinhos, que tem pet ou por idade.
     nessa lista deve ser retornado apenas os campos ID, NOME e SOBRENOME.
     todo 3 - faça um metodo para DELETAR um cadastro por id.
     todo 4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

}
