package br.com.hospitalja.resource;

import br.com.hospitalja.model.Hospital;
import br.com.hospitalja.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("hospital")
public class HospitalResource {

    @Autowired
    private HospitalRepository repository;

    @GetMapping("/listar")
    public List<Hospital> listar(){
        return repository.findAll();
    }

    @GetMapping("/{codigo}")
    public Hospital buscar(@PathVariable int codigo){
        return repository.findById(codigo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    public Hospital cadastrar(@RequestBody Hospital hospital){
        return repository.save(hospital);
    }

    @PutMapping("/atualizar/{id}")
    public Hospital atualizar(@RequestBody Hospital hospital,
                              @PathVariable int id){
        buscar(id);
        hospital.setCodigo(id);
        return repository.save(hospital);
    }

    @DeleteMapping("/remover/{codigo}")
    public void remover(@PathVariable int codigo){
        buscar(codigo);
        repository.deleteById(codigo);
    }
}
