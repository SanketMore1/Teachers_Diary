class Grades {
    int physics;
    int chemistry;
    int maths;
    int total;
    int average;

    Grades() {
    }

    public Grades(int physics, int chemistry, int maths) {
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
        this.total = physics + chemistry + maths;
        this.average = total / 3;
    }

    public void setGrades(int physics, int chemistry, int maths) {
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
        this.total = physics + chemistry + maths;
        this.average = total / 3;
    }

    public void getGrades() {
        int total = physics + chemistry + maths;
        int avg = (total / 3);
        System.out.println("[ physics = " + physics + ", Chemistry = " + chemistry + ",Maths = " + maths + ",Total Marks = " + total + ",Average = " + avg + "% ]");
    }


}