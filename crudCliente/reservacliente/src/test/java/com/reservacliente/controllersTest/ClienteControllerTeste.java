package com.reservacliente.controllersTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.reservacliente.controllers.ClienteController;
import com.reservacliente.models.Cliente;
import com.reservacliente.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ClienteControllerTeste {

    @Autowired
    ClienteRepository clienteRepository;


    @Test
    public void testCadastrarCliente() {
        ClienteRepository mockRepository = mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNome("Nome do Cliente");
        cliente.setEmail("cliente@email.com");
        cliente.setTelefone("123456789");

        when(mockRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteController controller = new ClienteController();
        controller.setClienteRepository(mockRepository);

        ResponseEntity<String> response = controller.cadastrarCliente(cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente Cadastrado: " + cliente.getNome(), response.getBody());
    }

}
