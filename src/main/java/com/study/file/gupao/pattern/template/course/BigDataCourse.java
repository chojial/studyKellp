package com.study.file.gupao.pattern.template.course;


public class BigDataCourse extends NetworkCourse {

    private boolean needFlag = false;

    public BigDataCourse(boolean needFlag) {
        this.needFlag = needFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("检查大数据的课后作业");
    }

    @Override
    protected boolean needHomework(){
        return this.needFlag;
    }
}
