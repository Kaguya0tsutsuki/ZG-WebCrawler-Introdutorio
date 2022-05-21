package olx

class Valor {
    static BigDecimal mediaValor(List<OlxClass> list){

        BigDecimal average = 0.00

        for (OlxClass data: list) {
            average = (average + data.preco)/2
        }

        return average

    }
}
