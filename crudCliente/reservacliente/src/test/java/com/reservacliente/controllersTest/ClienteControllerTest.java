package com.reservacliente.controllersTest;



import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestBody;

import com.reservacliente.controllers.ClienteController;
import com.reservacliente.models.Cliente;

public class ClienteControllerTest {

    private ClienteController clienteController;

    
    
    @Test
    public void testCadastrarCliente() {
    	Cliente cliente = new Cliente();
		cliente.setId(5L);
    	cliente.setNome("Matheus");
    	cliente.setEmail("sim@gmail.com");
    	cliente.setTelefone("111222233");
    	
    	clienteController.cadastrarCliente(cliente);
    	
    	
    	
     }
}
