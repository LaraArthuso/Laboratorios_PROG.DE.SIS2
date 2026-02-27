public class AgenteImagem extends AgenteIA {

    public AgenteImagem(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input) {

        try {

            if (input == null || input.isEmpty()) {
                System.out.println("Erro: descrição da imagem inválida.");
                return;
            }

            super.conectarServidor();

            System.out.println("Agente de Imagem [" + this.nome +
                    "] gerando imagem para: [" + input + "]");

        } catch (Exception e) {
            System.out.println("Erro ao processar requisição: " + e.getMessage());
        }
    }
}