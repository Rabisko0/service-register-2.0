package br.com.rodrigocarvalho.service_register.service;

import br.com.rodrigocarvalho.service_register.entity.Cliente;
import br.com.rodrigocarvalho.service_register.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente atualizarCliente(Long id,Cliente clienteAtualizado){
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setInstagram(clienteAtualizado.getInstagram());

        return clienteRepository.save(clienteAtualizado);
    }

    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
