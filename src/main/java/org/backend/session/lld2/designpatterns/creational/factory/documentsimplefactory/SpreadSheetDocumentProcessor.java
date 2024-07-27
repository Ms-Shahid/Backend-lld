public class SpreadSheetDocumentProcessor implements DocumentProcessor{

    private String documentName;

    public SpreadSheetDocumentProcessor(String documentName){
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