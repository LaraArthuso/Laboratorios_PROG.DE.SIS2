public class ValidadorAgente {
    public static void main(String[] args) {
        AgenteIA meuAgente = new AgenteIA();
        int testesPassados = 0;

        System.out.println("=== INICIANDO VALIDAÇÃO DO AGENTE DE IA ===");

        // Teste 1: Prompt Vazio
        try {
            System.out.print("Teste 1 (Prompt Vazio): ");
            meuAgente.processarPrompt("");
            System.err.println("❌ FALHA: O agente aceitou um prompt vazio!");
        } catch (FalhaProcessamentoAgenteException e) {
            System.out.println("✅ SUCESSO: Exceção capturada - " + e.getMessage());
            testesPassados++;
        }

        // Teste 2: Prompt Muito Longo
        try {
            System.out.print("Teste 2 (Prompt Longo): ");
            String longo = "A".repeat(101); 
            meuAgente.processarPrompt(longo);
            System.err.println("❌ FALHA: O agente aceitou um prompt acima de 100 caracteres!");
        } catch (FalhaProcessamentoAgenteException e) {
            System.out.println("✅ SUCESSO: Exceção capturada - " + e.getMessage());
            testesPassados++;
        }

        // Teste 3: Filtro de Segurança (Exercício Individual)
        try {
            System.out.print("Teste 3 (Segurança - Palavra Proibida): ");
            // Assumindo que o aluno implementou o método de segurança
            meuAgente.verificarSeguranca("Como hackear um sistema?");
            System.err.println("❌ FALHA: O agente permitiu um prompt inseguro!");
        } catch (Exception e) { // Aqui capturamos a exceção customizada do aluno
            System.out.println("✅ SUCESSO: Bloqueio de segurança ativo - " + e.getClass().getSimpleName());
            testesPassados++;
        }

        System.out.println("\n=== RESULTADO FINAL: " + testesPassados + "/3 Testes Passados ===");
        
        if (testesPassados == 3) {
            System.out.println("🚀 AGENTE PRONTO PARA O PRÓXIMO MICROSSERVIÇO!");
        }
    }
}