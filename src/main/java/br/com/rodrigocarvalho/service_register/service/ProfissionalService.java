package br.com.rodrigocarvalho.service_register.service;

import br.com.rodrigocarvalho.service_register.entity.Profissional;
import br.com.rodrigocarvalho.service_register.repository.ProfissionalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    private ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository){
        this.profissionalRepository = profissionalRepository;
    }

    public List<Profissional> listarProfissionais(){
        return profissionalRepository.findAll();
    }

    public Profissional buscarProfissionalPorId(Long id){
        return profissionalRepository.findById(id).orElse(null);
    }

    public Profissional criarProfissional(Profissional profissional){
        return profissionalRepository.save(profissional);
    }

    @Transactional
    public Profissional atualizarProfissional(Long id, Profissional profissionalAtualizado){
        Profissional profissionalExistente = profissionalRepository.findById(id).orElseThrow(() -> new RuntimeException("Profissional não encontrado."));

        profissionalExistente.setNome(profissionalAtualizado.getNome());
        profissionalExistente.setTelefone(profissionalAtualizado.getTelefone());
        profissionalExistente.setInstagram(profissionalAtualizado.getInstagram());

        return profissionalRepository.save(profissionalAtualizado);
    }

    public void excluirProfissional(Long id){
        profissionalRepository.deleteById(id);
    }
}