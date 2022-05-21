package olx

class Main {
    static void main(String[] args) {
        Olx olx = new Olx()
        Valor valor = new Valor()
        CriarFile criarFile = new CriarFile()

       List<String> urls = new LinkedList<>()

        urls.add("https://go.olx.com.br/grande-goiania-e-anapolis?o=1&q=iphone%2011&sp=2")
        urls.add("https://go.olx.com.br/grande-goiania-e-anapolis?o=2&q=iphone%2011&sp=2")
        urls.add("https://go.olx.com.br/grande-goiania-e-anapolis?o=3&q=iphone%2011&sp=2")

        List<OlxClass> olxList = new ArrayList<>()

        for (String url : urls){
             olxList << olx.olx(url)
        }

        olxList = olxList.flatten()

        def priceAvg = valor.mediaValor(olxList)

        List<OlxClass> filteredData = new ArrayList<>()

        for (OlxClass value: olxList){
            if(value.preco <= priceAvg){
                filteredData << value
            }
        }

        criarFile.criarFile(filteredData)

    }

}
