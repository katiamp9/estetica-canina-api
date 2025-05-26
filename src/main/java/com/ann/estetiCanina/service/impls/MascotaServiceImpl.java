package com.ann.estetiCanina.service.impls;

import com.ann.estetiCanina.dtos.request.MascotaRequest;
import com.ann.estetiCanina.dtos.response.MascotaResponse;
import com.ann.estetiCanina.models.Cliente;
import com.ann.estetiCanina.models.Mascota;
import com.ann.estetiCanina.repository.ClienteRepository;
import com.ann.estetiCanina.repository.MascotaRepository;
import com.ann.estetiCanina.service.interfaces.IMascotaService;
import com.ann.estetiCanina.exceptions.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaServiceImpl implements IMascotaService {

    private final MascotaRepository mascotaRepository;
    private final ClienteRepository clienteRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository, ClienteRepository clienteRepository) {
        this.mascotaRepository = mascotaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public MascotaResponse registrarMascota(MascotaRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Mascota mascota = new Mascota();
        mascota.setNombre(request.getNombre());
        mascota.setRaza(request.getRaza());
        mascota.setSexo(request.getSexo());
        mascota.setFecha_nacimiento(request.getFecha_nacimiento());
        mascota.setCliente(cliente);

        Mascota mascotaGuardada = mascotaRepository.save(mascota);

        return mapToResponse(mascotaGuardada);
    }

    @Override
    public MascotaResponse obtenerMascotaPorId(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada"));
        return mapToResponse(mascota);
    }

    @Override
    public List<MascotaResponse> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MascotaResponse> obtenerMascotasPorCliente(Long clienteId) {
        return mascotaRepository.findByClienteId(clienteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MascotaResponse> buscarMascotasPorNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MascotaResponse actualizarMascota(Long id, MascotaRequest request) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada"));

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        mascota.setNombre(request.getNombre());
        mascota.setRaza(request.getRaza());
        mascota.setSexo(request.getSexo());
        mascota.setFecha_nacimiento(request.getFecha_nacimiento());
        mascota.setCliente(cliente);

        Mascota mascotaActualizada = mascotaRepository.save(mascota);

        return mapToResponse(mascotaActualizada);
    }

    @Override
    @Transactional
    public void eliminarMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada"));
        mascotaRepository.delete(mascota);
    }

    private MascotaResponse mapToResponse(Mascota mascota) {
        return new MascotaResponse(
                mascota.getId_mascota(),
                mascota.getNombre(),
                mascota.getRaza(),
                mascota.getSexo(),
                mascota.getFecha_nacimiento(),
                mascota.getCliente().getId()
        );
    }
}
