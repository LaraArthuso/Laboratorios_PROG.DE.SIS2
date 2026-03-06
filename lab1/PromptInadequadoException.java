
public class PromptInadequadoException extends Exception {
    private String timestamp;
    private String palavraProibida;

    public PromptInadequadoException(String mensagem, String palavraProibida) {
        super(mensagem);
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.palavraProibida = palavraProibida;
    }

    public String getTimestamp() { 
        return timestamp; 
    }

    public String getPalavraProibida() {
        return palavraProibida;
    }
}