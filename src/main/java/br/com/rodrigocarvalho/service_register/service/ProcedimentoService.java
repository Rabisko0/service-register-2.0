package br.com.rodrigocarvalho.service_register.service;

import br.com.rodrigocarvalho.service_register.entity.Procedimento;
import br.com.rodrigocarvalho.service_register.repository.ProcedimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

    private ProcedimentoRepository procedimentoRepository;

    public ProcedimentoService(ProcedimentoRepository procedimentoRepository){
        this.procedimentoRepository = procedimentoRepository;
    }

    public List<Procedimento> listarProcedimentos(){
        return procedimentoRepository.findAll();
    }

    public Procedimento buscarProcedimentoPorId(Long id){
        return procedimentoRepository.findById(id).orElse(null);
    }

    public Procedimento criarProcedimento(Procedimento procedimento){
        return procedimentoRepository.save(procedimento);
    }

    @Transactional
    public Procedimento atualizarProcedimento(Long id, Procedimento procedimentoAtualizado){
        Procedimento procedimentoExistente = procedimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Procedimento não encontrado."));

        procedimentoExistente.setNome(procedimentoAtualizado.getNome());
        procedimentoExistente.setValor(procedimentoAtualizado.getValor());
        procedimentoExistente.setDescricao(procedimentoAtualizado.getDescricao());

        return procedimentoRepository.save(procedimentoAtualizado);
    }

    public void excluirProcedimento(Long id){
        procedimentoRepository.deleteById(id);
    }
}
