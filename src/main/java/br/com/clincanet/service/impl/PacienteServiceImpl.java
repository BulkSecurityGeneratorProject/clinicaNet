package br.com.clincanet.service.impl;

import br.com.clincanet.service.PacienteService;
import br.com.clincanet.domain.Paciente;
import br.com.clincanet.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Paciente.
 */
@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final Logger log = LoggerFactory.getLogger(PacienteServiceImpl.class);

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    /**
     * Save a paciente.
     *
     * @param paciente the entity to save
     * @return the persisted entity
     */
    @Override
    public Paciente save(Paciente paciente) {
        log.debug("Request to save Paciente : {}", paciente);        return pacienteRepository.save(paciente);
    }

    /**
     * Get all the pacientes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Paciente> findAll(Pageable pageable) {
        log.debug("Request to get all Pacientes");
        return pacienteRepository.findAll(pageable);
    }


    /**
     * Get one paciente by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Paciente> findOne(Long id) {
        log.debug("Request to get Paciente : {}", id);
        return pacienteRepository.findById(id);
    }

    /**
     * Delete the paciente by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Paciente : {}", id);
        pacienteRepository.deleteById(id);
    }
}
