package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public void cadastrarPessoa (@RequestBody CadastroDTO cadastroDTO){
        cadastroService.realizarCadastro(cadastroDTO);
    }

    @GetMapping
    public List<Cadastro> todosOsCadastros (@RequestParam Optional<Boolean> moraSozinho,
                                            @RequestParam Optional<Boolean> temPet,
                                            @RequestParam Optional<Integer> idade){
        List <Cadastro> cadastros = new ArrayList<>();
        if (moraSozinho.isPresent())
        for (Cadastro cadastro : cadastroService.filtrarMoraSozinho(moraSozinho.get())){
            cadastros.add(cadastro);
        }
        else if (temPet.isPresent()){
            for (Cadastro cadastro : cadastroService.filtrarTemPet(temPet.get())){
                cadastros.add(cadastro);
            }
        }
        else if (idade.isPresent()){
            for (Cadastro cadastro : cadastroService.filtrarIdade(idade.get())){
                cadastros.add(cadastro);
            }
        }
        else {
            return cadastroService.mostrarTodosCadastros();
        }
        return cadastros;
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
