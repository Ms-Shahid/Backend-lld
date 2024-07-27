public class PresentationDocumentProcessor implements DocumentProcessor{

    private String documentName;

    public PresentationDocumentProcessor(String documentName){
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