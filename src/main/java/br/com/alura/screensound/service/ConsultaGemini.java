package br.com.alura.screensound.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
  public static String obterInformacao(String texto) {
    // The client gets the API key from the environment variable `GOOGLE_API_KEY`.
    try (Client client = new Client()) {
      GenerateContentResponse response = client.models.generateContent(
          "gemini-2.5-flash",
          "Me fale sobre o artista(Deve ser um breve resumo de 5 linhas apenas): " + texto,
          null);

      var resposta = response.text();
      return resposta;
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
      return "Erro: " + e.getMessage();
    }

  }
}
