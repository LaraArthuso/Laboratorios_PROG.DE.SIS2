import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<AgenteIA> lista = new ArrayList<>();

        lista.add(new AgenteTexto("GPT-4"));
        lista.add(new AgenteImagem("DALL-e"));

        for (AgenteIA agente : lista) {
            try {
                agente.processarRequisicao("Hello, World!");
            } catch (Exception e) {
                System.out.println("Erro no agente "
                        + agente.getNome() + ": "
                        + e.getMessage());
            }
        }
    }
}