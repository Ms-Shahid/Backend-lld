
public class DocumentProcessorFactory{

    //this simple factory method helps to get the doc based on name of doc
    public static DocumentProcessor getDocument( String docName, DocumentType docType ){

        switch( docType ){
            case DocumentType.PRESENTATION : return new PresentationDocumentProcessor( docName );
            case DocumentType.TEXT : return new TextDocumentProcessor( docName );
            default return new SpreadsheetDocumentProcessor( docName );
        }
    }
}