package olx

import com.opencsv.CSVWriter

class CriarFile {
    static void criarFile(List<OlxClass> list)throws IOException{

        String[] file = ["Título","Valor","Endereço","URL"]
        def fileName = 'File.csv'

        CSVWriter writer = new CSVWriter(new FileWriter(fileName))

        writer.writeNext(file)

        for(OlxClass olx : list){
            String[] dataToWrite = [olx.titulo, "${olx.preco}", olx.endereco,olx.url]
            writer.writeNext(dataToWrite)
        }
        writer.close()

    }
}
