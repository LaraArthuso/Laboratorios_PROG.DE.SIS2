public class AgenteTexto extends AgenteIA {

    public AgenteTexto(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input) {

        try {

            if (input.length() > 500) {
                System.out.println("Erro: Prompt muito longo para o modelo atual.");
                return;
            }

            super.conectarServidor();

            System.out.println("Agente de Texto [" + this.nome +
                    "] gerando resposta para: [" + input + "]");

        } catch (Exception e) {
            System.out.println("Erro ao processar requisição: " + e.getMessage());
        }
    }
}


                
   
