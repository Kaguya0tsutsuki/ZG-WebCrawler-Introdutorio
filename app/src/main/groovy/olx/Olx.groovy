package olx

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class Olx {
    static List<Olx> olx(String url){

        List<Olx> listOLX = new ArrayList<>()

        Document doc = Jsoup.connect(url).get()

        List<Element> lerList = doc.getElementsByClass("sc-1fcmfeb-2")

        for (int i=0; i < 4; i++){

            OlxClass olx = new OlxClass();
            Element ler = lerList.remove(0)
            if(i==2){
                continue
            }

            Element anchor = ler.getElementsByTag("a").first()

            olx.url = anchor.attr("href")
            olx.titulo = anchor.attr("title")

            println(olx.titulo)

            Element addressDiv = anchor.getElementsByClass("sc-1c3ysll-0").first()

            Element spanAddress = addressDiv.getElementsByTag("span").first()

            Element priceDiv = anchor.getElementsByClass("sc-1kn4z61-1").first()

            Element spanPrice = priceDiv.getElementsByTag("span").first()

            olx.endereco = spanAddress.text()

            String priceString = spanPrice.text()

            String[] parts = priceString.split(/(R\$\s)/)

            olx.preco =  Double.parseDouble(parts[1])*1000

            listOLX << olx
        }

        return listOLX
    }
}
