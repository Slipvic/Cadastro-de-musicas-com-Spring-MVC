package br.senac.tads.dsw.musicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.tads.dsw.musicas.entities.Musicas;


public interface MusicaRepository extends  JpaRepository<Musicas, Long> {

}
