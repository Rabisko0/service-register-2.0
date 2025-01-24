package br.com.rodrigocarvalho.service_register.service;

import br.com.rodrigocarvalho.service_register.entity.Atendimento;
import br.com.rodrigocarvalho.service_register.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    private AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository){
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<Atendimento> listarAtendimentos(){
        return atendimentoRepository.findAll();
    }

    public Atendimento buscarAtendimentoPorId(Long id){
        return atendimentoRepository.findById(id).orElse(null);
    }

    public Atendimento salvarAtendimento(Atendimento atendimento){
        return atendimentoRepository.save(atendimento);
    }

    public void excluirAtendimentoPorId(Long id){
        atendimentoRepository.deleteById(id);
    }
}
