package com.reservacliente.controllers;

import com.reservacliente.models.Cliente;
import com.reservacliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public ResponseEntity<List<Cliente>>  listarClientes(){

        return ResponseEntity.ok().body(clienteRepository.findAll());
    }


    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.ok("Cliente Cadastrado: " + clienteSalvo.getNome());
    }


    @PutMapping("{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        Cliente clienteAlterado = clienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado ID:" + id));

        clienteAlterado.setNome(cliente.getNome());
        clienteAlterado.setEmail(cliente.getEmail());
        clienteAlterado.setTelefone(cliente.getTelefone());

        clienteRepository.save(clienteAlterado);
        return ResponseEntity.ok(clienteAlterado);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> excluirClientePorId(@PathVariable long id){

        clienteRepository.deleteById(id);
        return ResponseEntity.ok("Cliente excluído ");
    }

    @Autowired
    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

}
