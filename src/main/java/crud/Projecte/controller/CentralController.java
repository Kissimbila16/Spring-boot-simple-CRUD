package crud.Projecte.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crud.Projecte.model.TabelaModel;
import crud.Projecte.repository.userReposity;

@RestController
public class CentralController {
    @Autowired
    userReposity user;
    public TabelaModel guardar(TabelaModel data){
        return user.save(data);
    }
    public void apagar(Long id){
         user.deleteById(id);
    }
   @GetMapping("/")
    public String start(){
        return "Voltei no sprin";
    }
    //pode me user como filtro
 @GetMapping("userForm/{nome}")
    public String pegarValor(@PathVariable String nome ){
        return "meiu nome é "+nome;
    }
    //eu sou muito passivo
       @PostMapping("userForm")
    public TabelaModel user(@RequestBody TabelaModel users){
        return guardar(users);
    }

    @DeleteMapping("userForm/{id}")
    public String deletar(@PathVariable Long id){
         apagar(id);
         return "sucesso!";
    }
    @PutMapping("userForm/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody TabelaModel data){
      if(user.existsById(id)==true){
        data.setId(id);
        user.save(data);
      }else{
        System.out.println("deu mal mano!");
      }
    }

    @GetMapping("userForm/listarTodos")
    public List < TabelaModel > listar() {
        return user.findAll();
    }
}
