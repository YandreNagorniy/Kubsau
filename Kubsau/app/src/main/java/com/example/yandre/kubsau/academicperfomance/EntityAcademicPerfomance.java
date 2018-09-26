package com.example.yandre.kubsau.academicperfomance;

class EntityAcademicPerfomance {
    public String subjectNameAcPerf;
    public String ratingFirstAt;
    public String ratingSecondAt;
    public String ratingThridAt;
    public String ratingFourthtAt;
    public String teacherNameAcPerf;

    public EntityAcademicPerfomance(String subjectNameAcPerf, String ratingFirstAt, String ratingSecondAt,
                                    String ratingThridAt, String ratingFourthtAt, String teacherNameAcPerf) {

        this.subjectNameAcPerf=subjectNameAcPerf;
        this.ratingFirstAt=ratingFirstAt;
        this.ratingSecondAt=ratingSecondAt;
        this.ratingThridAt=ratingThridAt;
        this.ratingFourthtAt=ratingFourthtAt;
        this.teacherNameAcPerf=teacherNameAcPerf;
    }
}
