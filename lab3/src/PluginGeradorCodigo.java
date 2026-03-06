public class PluginGeradorCodigo implements IAcaoAgente {
    @Override
    public void processarRequisicao(String comando)
            throws PromptInadequadoException, FalhaProcessamentoAgenteException{

        if(comando.length()>50){
            throw new FalhaProcessamentoAgenteException("Comando muito longo!!");
            }
            System.out.println("Snippet de código Java gerado para: " + comando);
    }
}
 