public abstract class AgenteIA {

    protected String nome;
    protected String status;

    public AgenteIA(String nome) {
        this.nome = nome;
    }

    public abstract void processarRequisicao(String input)//tive q colocar isso pq tava dando erro, mas n sei se é isso mesmo
    throws FalhaProcessamentoAgenteException,
           PromptInadequadoException,
           ErroComunicacaoIAException;

    
    public void conectarServidor() {
        try {
            if (Math.random() > 0.7) { // 30% de chance de falha
                throw new Exception("Falha na conexão com o servidor.");
            }
            System.out.println("Servidor conectado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro de conexão" + e.getMessage());
        }
    }

    public void verificarSeguranca(String prompt) {
        if (prompt == null || prompt.isEmpty()) {
            System.out.println("vazio!");
            return;
        }

        String p = prompt.toLowerCase();
        if (p.contains("hackear") || p.contains("roubar")) {
            System.out.println("bloqueado.");
        }
    }

    public String getNome() {
        return this.nome;
    }
}