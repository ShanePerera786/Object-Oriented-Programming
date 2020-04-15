import java.util.Scanner;

public class Schedule extends Vehicle {
    private int day;
    private int month;
    private int year;
    private int validDays; //check if the date is valid for corresponding month..

    private static Scanner input=new Scanner(System.in);
    public Schedule(){}

    public Schedule(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        while (day<1||day>validDays){ //check whether the day is valid..
            System.out.println("This month has "+validDays+"days");
            day =input.nextInt();
            input.nextLine();
            setDay(day);

        }

        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        while(month<1||month>12){ //check whether the month is valid..
            System.out.println("Please enter valid month..");
            month=input.nextInt();
            input.nextLine();
            setMonth(month);
        }
        this.month = month;
        switch (month){
            case 1: case 3 : case 5: case 7: case 8: case 10: case 12:
                validDays=31;
                break;
            case 4 : case 6: case 9: case 11:
                validDays=30;
                break;
            case 2:
                if(isLeap(year)){
                    validDays=29;
                }else {
                    validDays = 28;
                }

        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        while (year<1900| year>2019){// check whether the year is valid...
            System.out.println("Please Enter a valid year");
            year=input.nextInt();
            setYear(year);
        }

        this.year = year;


    }
    private boolean isLeap(int year) { //check whether the year is a leap year

        if((year%4!=0)||(year%100==0)){
            return false;
        }else if(year%400==0){
            return true;
        }
        else{
            return  true;
        }
    }

    //returning the string representation of the object..
    @Override
    public String toString() {
        return "Schedule{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                "} " + super.toString();
    }
}
