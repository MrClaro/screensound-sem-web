package br.com.alura.screensound.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  private String nome;

  @Enumerated(EnumType.STRING)
  private TipoArtista tipo;

  @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Musica> musicas = new ArrayList<>();

  public Artista() {
  }

  public Artista(String nome, TipoArtista tipoArtista) {
    this.nome = nome;
    this.tipo = tipoArtista;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public TipoArtista getTipo() {
    return tipo;
  }

  public void setTipo(TipoArtista tipo) {
    this.tipo = tipo;
  }

  public List<Musica> getMusicas() {
    return musicas;
  }

  public void setMusicas(List<Musica> musicas) {
    this.musicas = musicas;
  }

  @Override
  public String toString() {
    return "Artista=" + nome + ", tipo=" + tipo + ", musicas=" + musicas;
  }

}
