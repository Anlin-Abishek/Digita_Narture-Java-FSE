public interface Document {
    void open();

    
}
 class WordDocument implements Document {
    public void open(){
        System.out.println("openning Word Document");

    }

    
}

 class PdfDocument implements Document{
    public void open(){
        System.out.println("Openning PDF Document");
    }
}

class ExcelDocument implements Document{
    public void open(){
        System.out.println("Openning Excel Document");
    }
}