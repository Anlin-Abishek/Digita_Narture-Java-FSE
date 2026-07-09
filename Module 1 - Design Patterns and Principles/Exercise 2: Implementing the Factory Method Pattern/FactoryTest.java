public class FactoryTest {
    public static void main(String[] args) {
        DocumentFactory pdfFactory = new PdfDocumentFact();
        Document myPdf = pdfFactory.create();
        myPdf.open();

        DocumentFactory wordFactory = new WordDocumentfact();
        Document myWord = wordFactory.create();
        myWord.open();

        DocumentFactory excelFactory = new ExcelDocumentfact();
        Document myExcel = excelFactory.create();
        myExcel.open();
    }
}