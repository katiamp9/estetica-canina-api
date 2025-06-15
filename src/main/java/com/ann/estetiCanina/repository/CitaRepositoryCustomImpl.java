package com.ann.estetiCanina.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ann.estetiCanina.dtos.response.CitaDetalladaResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CitaRepositoryCustomImpl implements CitaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CitaDetalladaResponse> obtenerDatosCitaDetallada(Integer idCita) {
        Query query = entityManager.createNativeQuery("SELECT * FROM obtener_datos_cita_detallada(:idCita)");
        query.setParameter("idCita", idCita);

        List<Object[]> resultados = query.getResultList();
        List<CitaDetalladaResponse> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            CitaDetalladaResponse dto = new CitaDetalladaResponse();
            dto.setIdCita((Integer) fila[0]);
            dto.setNombreCliente((String) fila[1]);
            dto.setTelefonoCliente((String) fila[2]);
            dto.setNombreMascota((String) fila[3]);
            dto.setFechaCita((Date) fila[4]);
            dto.setHoraInicio((Time) fila[5]);
            dto.setHoraFin((Time) fila[6]);
            dto.setNombreEmpleado((String) fila[7]);
            dto.setServicioNombre((String) fila[8]);
            dto.setPrecioUnitario((BigDecimal) fila[9]);
            dto.setCantidad((Integer) fila[10]);
            dto.setSubtotal((BigDecimal) fila[11]);
            dto.setObservaciones((String) fila[12]);

            lista.add(dto);
        }

        return lista;
    }
}
