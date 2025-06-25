package br.com.alura.screensound.client;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;
import br.com.alura.screensound.service.ConsultaGemini;

public class Principal {
  private final Scanner leitura = new Scanner(System.in);
  private ArtistaRepository repository;

  public Principal(ArtistaRepository artistaRepository) {
    this.repository = artistaRepository;
  }

  public void exibeMenu() {
    var opcao = -1;

    while (opcao != 0) {
      var menu = """
          *** Screen Sound Músicas ***

          1- Cadastrar artistas
          2- Cadastrar músicas
          3- Listar músicas
          4- Buscar músicas por artistas
          5- Pesquisar dados sobre um artista

          0 - Sair
          """;

      System.out.println(menu);
      opcao = leitura.nextInt();
      leitura.nextLine();

      switch (opcao) {
        case 1:
          cadastrarArtistas();
          break;
        case 2:
          cadastrarMusicas();
          break;
        case 3:
          listarMusicas();
          break;
        case 4:
          buscarMusicasPorArtista();
          break;
        case 5:
          pesquisarDadosDoArtista();
          break;
        case 0:
          System.out.println("Encerrando a aplicação!");
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  private void cadastrarMusicas() {
    System.out.println("Digite o nome do artista:");
    var nome = leitura.nextLine();
    Optional<Artista> artistaOptional = repository.findByNomeContainingIgnoreCase(nome);
    if (artistaOptional.isEmpty()) {
      System.out.println("Artista não encontrado. Por favor, cadastre o artista primeiro.");
      return;
    }
    System.out.println("Digite o nome da música:");
    var nomeMusica = leitura.nextLine();
    Musica musica = new Musica(nomeMusica);
    musica.setArtista(artistaOptional.get());
    artistaOptional.get().getMusicas().add(musica);
    repository.save(artistaOptional.get());
  }

  private void pesquisarDadosDoArtista() {
    System.out.println("Pesquisar dados sobre qual artista? ");
    var nome = leitura.nextLine();
    var resposta = ConsultaGemini.obterInformacao(nome);
    System.out.println(resposta.trim());
  }

  private void buscarMusicasPorArtista() {
    System.out.println("Buscar músicas de que artista? ");
    var nome = leitura.nextLine();
    List<Musica> musicas = repository.buscaMusicasPorArtista(nome);
    musicas.forEach(System.out::println);
  }

  private void listarMusicas() {
    List<Artista> artistas = repository.findAll();
    artistas.forEach(artista -> {
      System.out.println("Artista: " + artista.getNome() + " (" + artista.getTipo() + ")");
      artista.getMusicas().forEach(musica -> {
        System.out.println("  Música: " + musica.getTitulo());
      });
    });
  }

  private void cadastrarArtistas() {
    var resposta = "S";
    while (resposta.equalsIgnoreCase("S")) {
      System.out.println("Digite o nome do artista:");
      var nome = leitura.nextLine();
      System.out.println("Digite o tipo do artista (BANDA, DUPLA ou SOLO):");
      var tipo = leitura.nextLine();
      TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
      Artista artista = new Artista(nome, tipoArtista);
      repository.save(artista);
      System.out.println("Cadastrar novo artista? (S/N)");
      resposta = leitura.nextLine();
    }
  }

}
