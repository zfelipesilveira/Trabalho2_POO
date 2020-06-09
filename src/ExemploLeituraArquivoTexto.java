import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExemploLeituraArquivoTexto {

    public void leLinhasTexto() {
        Path path1 = Paths.get("teste1.txt");
        try (BufferedReader reader = Files.newBufferedReader(path1,
                Charset.defaultCharset())) {
            String line = null;
            int numLinha = 0;
            while ((line = reader.readLine()) != null) {
                numLinha++;
                System.out.println("Linha " + numLinha + ": " + line);
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

    }

    public void leRegistrosTexto() {

        Path path = Paths.get("teste2.txt");
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            String pal = null;
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            while (sc.hasNext()) {
                pal = sc.next();
                System.out.println(pal);
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTexto2() {
        Path path = Paths.get("teste2.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public static void main(String args[]) {
        ExemploLeituraArquivoTexto exemplo = new ExemploLeituraArquivoTexto();
        exemplo.leLinhasTexto();
        System.out.println("------");
        exemplo.leRegistrosTexto();
        System.out.println("------");
        exemplo.leRegistrosTexto2();
    }

}
