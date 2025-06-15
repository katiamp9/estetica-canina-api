package com.ann.estetiCanina.service.impls;

import com.ann.estetiCanina.dtos.request.EmpleoRequest;
import com.ann.estetiCanina.dtos.response.EmpleoResponse;
import com.ann.estetiCanina.models.Empleo;
import com.ann.estetiCanina.repository.EmpleoRepository;
import com.ann.estetiCanina.service.interfaces.IEmpleoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleoServiceImpl implements IEmpleoService {

    @Autowired
    private EmpleoRepository empleoRepository;

    @Override
    public EmpleoResponse registrarEmpleo(EmpleoRequest request) {
        Empleo empleo = new Empleo();
        empleo.setTitulo(request.getTitulo());
        empleo.setDescripcion(request.getDescripcion());
        empleoRepository.save(empleo);
        return toResponse(empleo);
    }

    @Override
    public EmpleoResponse getEmpleoById(Long id) {
        Empleo empleo = empleoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado con ID: " + id));
        return toResponse(empleo);
    }

    @Override
    public List<EmpleoResponse> getAllEmpleos() {
        return empleoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleoResponse updateEmpleo(Long id, EmpleoRequest request) {
        Empleo empleo = empleoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado con ID: " + id));
        empleo.setTitulo(request.getTitulo());
        empleo.setDescripcion(request.getDescripcion());
        empleoRepository.save(empleo);
        return toResponse(empleo);
    }

    @Override
    public void deleteEmpleo(Long id) {
        empleoRepository.deleteById(id);
    }

    private EmpleoResponse toResponse(Empleo empleo) {
        return new EmpleoResponse(
                empleo.getId_empleo(),
                empleo.getTitulo(),
                empleo.getDescripcion()
        );
    }
}
