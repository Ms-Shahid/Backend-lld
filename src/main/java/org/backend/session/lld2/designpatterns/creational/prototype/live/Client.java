package org.backend.session.lld2.designpatterns.prototype.live;

public class Client {

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        //add the specific changing attributes & get all other attributes from registry
        Student shahid = studentRegistry.getRegistry(String.valueOf(Batch.MAR24EVE)).clone();
        shahid.setName("Shahid");
        shahid.setAge(24);
        shahid.setPsp(96);

        Student anks = studentRegistry.getRegistry(String.valueOf(Batch.FEB24MOR)).clone();
        anks.setName("Akanksha");
        anks.setAge(26);
        anks.setPsp(98);




        System.out.println("Debug...");
    }

    private static void fillRegistry(StudentRegistry studentRegistry){
        Student marchStudent = new Student();
        marchStudent.setBatch(String.valueOf(Batch.MAR24EVE));
        marchStudent.setAvgBatchPsp(80.0);
        studentRegistry.setRegistry(String.valueOf(Batch.MAR24EVE), marchStudent);


        Student febStudent = new Student();
        febStudent.setBatch(String.valueOf(Batch.FEB24MOR));
        febStudent.setAvgBatchPsp(70.0);
        studentRegistry.setRegistry(String.valueOf(Batch.FEB24MOR), febStudent);

        IntelligentStudent aprStudent = new IntelligentStudent();
        aprStudent.setBatch(String.valueOf(Batch.APR24EVE));
        aprStudent.setAvgBatchPsp(80.0);
        aprStudent.iq = 100;
        studentRegistry.register(String.valueOf(Batch.APR24EVE), aprStudent);

    }
}
