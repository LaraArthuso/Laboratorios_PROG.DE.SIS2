public class ModuloConexao {

    public static void validarLink() throws ErroComunicacaoIAException {

        if (Math.random() > 0.8) {
            throw new ErroComunicacaoIAException(
                "Falha na comunicação com a GPU!"
            );
        }
    }
}