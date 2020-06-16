import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeituraTexto {


    //USAR O MÉTODO DA CLASSE STRING PARA VERIFICAR O PRIMEIRO CARACTER DE CADA LINHA

//    DICA:
//    Você não vai conseguir ler e processar todas as linhas da mesma maneira.
//    Será necessário que o seu 'parser' leia o arquivo-texto linha-a-linha.
//    Para cada linha precisa verificar se é um comentário, uma seção, uma linha em branco ou dados - pelo primeiro caracter.
//            Se for uma linha com dados, você poderá utilizar o useDelimiter.
//    Se for uma seção, você precisa eliminar o abre e fecha colchetes.
//    Veja na API Java, que a classe String possui métodos para manipular os seus caracteres e partes da String (substring).
//
//    Prof. Yamaguti

    public void leituraArquivo() {
        Path path = Paths.get("CLIENTES.TXT");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                // separador: :
                Scanner sc = new Scanner(linha).useDelimiter(":");
                System.out.println(sc.next()+" - "+sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

}