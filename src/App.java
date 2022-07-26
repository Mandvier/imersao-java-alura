import java.io.InputStream;
import java.net.URL;
//import java.security.Key;
import java.util.List;



public class App {
    public static void main(String[] args) throws Exception {
       

        // fazer uma conexão HTTP e buscar os top 250 filmes
       //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
     
       
       
       //exibir e manipular os dados
        String url  = "https://aluralinguagensapi-mandvier.herokuapp.com/linguagens";
      ExtratorDeConteudo extrator =  new ExtratorDeConteudoDoIMDB();

      var http = new ClienteHTTP();
      String json = http.buscaDados(url);

      
      List<Conteudo> conteudos = extrator.extraiConteudos(json);
       for (Conteudo conteudo : conteudos) {
       
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

       var geradora = new Geradordefigurinhas();
       geradora.cria(inputStream, nomeArquivo);

        System.out.println(conteudo.getTitulo());
        System.out.println();

        
       }



        
        
    }
}