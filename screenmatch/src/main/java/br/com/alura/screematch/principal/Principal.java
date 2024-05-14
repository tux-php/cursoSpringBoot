package br.com.alura.screematch.principal;

import br.com.alura.screematch.model.DadosEpisodio;
import br.com.alura.screematch.model.DadosSerie;
import br.com.alura.screematch.model.DadosTemporada;
import br.com.alura.screematch.model.Episodio;
import br.com.alura.screematch.service.ConsumoAPI;
import br.com.alura.screematch.service.ConverteDados;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ce1c6b43";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    public void exibirMenu(){
        System.out.println("Digite o nome da série:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO+nomeSerie.replace(" ","+")+API_KEY);
        DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
        System.out.println("Objeto java: " + dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for(int i = 1; i < dados.totalTemporadas(); i++){
			json = consumo.obterDados(ENDERECO+nomeSerie.replace(" ","+")+"&season="+i+API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

//        List<String> nomes = Arrays.asList("Fernando", "Dayanne", "Sophia","Guilherme" );
//        nomes.stream()
//                .sorted()
//                .limit(3)
//                .filter(n -> n.startsWith("G"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 5 episódios:");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n Lista da nova classe Episodio");
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(),d))
                ).collect(Collectors.toList());
        episodios.forEach(System.out::println);

        System.out.println("A partir de que ano vc deseja ver os episódios? ");
        var ano = leitura.nextInt();
        leitura.nextLine();
        //LocalDate trabalha o ano inserido pelo usuário
        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        //Data formatada no padrão brasileiro
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento()!=null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                "Episodio: " + e.getTitulo() +
                                "Data Lançamento: " + e.getDataLancamento().format(formatador)
                ));
    }
}
