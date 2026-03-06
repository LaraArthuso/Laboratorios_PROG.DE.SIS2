
public class AgenteIA {
    
    // Lista de palavras proibidas para o filtro de segurança
    private static final String[] PALAVRAS_PROIBIDAS = {
        "hackear", "roubar", "invadir", "destruir", "atacar"
    };

    /**
     * Método principal que processa o prompt
     * Valida se o prompt não está vazio e não excede 100 caracteres
     */
    public void processarPrompt(String prompt) throws FalhaProcessamentoAgenteException {
        // Valida se o prompt não é nulo ou vazio
        if (prompt == null || prompt.isEmpty()) {
            throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
        }
        
        // Valida o tamanho do prompt
        if (prompt.length() > 100) {
            throw new FalhaProcessamentoAgenteException("Prompt muito longo para o modelo atual.");
        }
        
        System.out.println("Agente processando: " + prompt);
    }

    /**
     * EXERCÍCIO 1: Filtro de Segurança (Safety Guard)
     * Verifica se o prompt contém palavras inadequadas
     */
    public void verificarSeguranca(String prompt) throws PromptInadequadoException {
        if (prompt == null) {
            return;
        }
        
        String promptLower = prompt.toLowerCase();
        
        // Verifica cada palavra proibida
        for (String palavraProibida : PALAVRAS_PROIBIDAS) {
            if (promptLower.contains(palavraProibida)) {
                throw new PromptInadequadoException(
                    "Prompt contém conteúdo inadequado: '" + palavraProibida + "'",
                    palavraProibida
                );
            }
        }
    }

    /**
     * EXERCÍCIO 2: Simulador de Timeout de API
     * Simula a chamada a um modelo externo que pode falhar
     */
    public void chamarModeloExterno() throws ErroComunicacaoIAException {
        double random = Math.random();
        
        // 30% de chance de falhar (quando random > 0.7)
        if (random > 0.7) {
            String tipoFalha;
            
            if (random > 0.85) {
                tipoFalha = "TIMEOUT";
            } else {
                tipoFalha = "CONEXAO_PERDIDA";
            }
            
            throw new ErroComunicacaoIAException(
                "Falha ao comunicar com o modelo externo: " + tipoFalha,
                tipoFalha
            );
        }
        
        System.out.println("Comunicação com modelo externo bem-sucedida");
    }

    /**
     * Método completo que realiza todas as validações
     */
    public void processarPromptCompleto(String prompt) 
            throws FalhaProcessamentoAgenteException, 
                   PromptInadequadoException, 
                   ErroComunicacaoIAException {
        
        // 1. Valida o prompt
        processarPrompt(prompt);
        
        // 2. Verifica segurança
        verificarSeguranca(prompt);
        
        // 3. Chama modelo externo
        chamarModeloExterno();
        
        System.out.println("Processamento completo realizado com sucesso!");
    }
}