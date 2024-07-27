
public abstract class DocumentProcessor{

    //all the common method & attributes in interface/abstract class
    private String documentName;
    private abstract DocumentType supportType();
    private abstract void processDoc();
}