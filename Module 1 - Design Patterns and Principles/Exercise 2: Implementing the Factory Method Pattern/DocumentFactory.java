public abstract class DocumentFactory {
    public abstract Document create();
}

class WordDocumentfact extends DocumentFactory{
    public Document create(){
        return new WordDocument();
    }
}
 class PdfDocumentFact extends DocumentFactory {
    public Document create(){
        return new PdfDocument();
    }

    
}

class ExcelDocumentfact extends DocumentFactory {
    public Document create(){
        return new ExcelDocument();
    }

    
}