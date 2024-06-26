public class TextDocumentProcessor implements DocumentProcessor{

    private String documentName;

    public TextDocumentProcessor(String documentName){
        this.documentName = documentName; 
    }

    public String getDocName(){
        return documentName;
    }

    @Override
    public DocumentType supportType(){
        return DocumentType.TEXT;
    }

    @Override
    public void processDocument(){
        System.out.println("Processing a text document: " + getDocName());
    }
}