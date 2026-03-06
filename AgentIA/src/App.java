public class App {
    public static void main(String[] args) throws Exception {
        try{
        AgenteTexto agente = new AgenteTexto("Agente gerador de código");
        PluginPesquisaWeb pesquisa = new PluginPesquisaWeb();
        PluginGeradorCodigo gerador = new PluginGeradorCodigo();

        String comando = ("como aprender Java");
        agente.usarHabilidade(pesquisa, comando);
        agente.usarHabilidade(gerador, comando);

        agente.usarHabilidade(pesquisa, "hackear");

        }catch(Exception e){
        System.out.println("Erro: " + e.getMessage());
       }
    }
}
