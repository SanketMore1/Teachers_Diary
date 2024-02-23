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

    public int getAverage(){
        int total = physics + chemistry + maths;
       if(this.total==0){return 0;}else{
        return total/3;}
    }

    public String toString(){

           return "[ physics = " + physics + ", Chemistry = " + chemistry + ",Maths = " + maths + ",Total Marks = " + total + ",Average = " + total / 3 + "% ]";

    }

}