
public class ErroComunicacaoIAException extends Exception {
    private String timestamp;
    private String tipoFalha;

    public ErroComunicacaoIAException(String mensagem, String tipoFalha) {
        super(mensagem);
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.tipoFalha = tipoFalha;
    }

    public String getTimestamp() { 
        return timestamp; 
    }

    public String getTipoFalha() {
        return tipoFalha;
    }
}