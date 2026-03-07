import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static void logErro(String mensagem) {
        String horario = LocalDateTime.now().format(formatter);
        System.err.println("[LOG-AGENTE] [" + horario + "] Erro: " + mensagem);
    }

    public static void main(String[] args) {

        AgenteIA agente = new AgenteIA();

        String[] prompts = {
                "Olá agente",
                "",
                "A".repeat(120),
                "Como hackear um sistema?",
                "Explique o que é IA"
        };

        for (String prompt : prompts) {

            try {

                agente.processarPrompt(prompt);
                agente.verificarSeguranca(prompt);
                agente.chamarModeloExterno();

                System.out.println("Prompt processado com sucesso");

            } catch (FalhaProcessamentoAgenteException e) {

                logErro(e.getMessage());

            } catch (PromptInadequadoException e) {

                logErro(e.getMessage());

            } catch (ErroComunicacaoIAException e) {

                logErro(e.getMessage());
            }
        }
    }
}
