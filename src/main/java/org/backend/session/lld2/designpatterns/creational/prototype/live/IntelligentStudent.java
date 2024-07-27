package org.backend.session.lld2.designpatterns.prototype.live;

public class IntelligentStudent extends Student{

    public int iq;

    public IntelligentStudent(IntelligentStudent student){
//        this.setBatch(student.getBatch());
//        this.setAvgBatchPsp(student.getAvgBatchPsp());
//        this.iq = student.iq;
        //The above can be set, if the student(parent) class exposes setter method
        //if it doesn't then ?

        super(student);
        this.iq = student.iq;
    }

    public IntelligentStudent(){}
    public Student clone(){
        return new IntelligentStudent(this);
    }
}
