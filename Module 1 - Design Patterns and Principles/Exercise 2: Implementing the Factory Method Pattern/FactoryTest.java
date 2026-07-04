public class FactoryTest {
    public static void main(String[] args) {
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document myPdf = pdfFactory.createDocument();
        myPdf.open();

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document myWord = wordFactory.createDocument();
        myWord.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document myExcel = excelFactory.createDocument();
        myExcel.open();
    }
}
