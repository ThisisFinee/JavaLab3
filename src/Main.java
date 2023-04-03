import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;

public class Main {

    public static boolean LanguageCheck(String[] Mas){
        boolean surname = Mas[0].matches("[a-zA-Z]*");
        boolean name = Mas[1].matches("[a-zA-Z]*");
        boolean patronomyc = Mas[2].matches("[a-zA-Z]*");
        if (surname == false && name == false && patronomyc == false) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean FullFormatCheck(String[] Full){
        if (Full.length == 4){
            return true;
        }
        else{
            return false;
        }
    }

    public static String Gender(String[] FullName){
        String patronomyc = FullName[2];
        if (patronomyc.endsWith("вич") || (patronomyc.endsWith("лы")) || (patronomyc.endsWith("ов"))
                || (patronomyc.endsWith("ев") || (patronomyc.endsWith("ич")))){
            return "М";
        }
        else if ((patronomyc.endsWith("овна") || (patronomyc.endsWith("евна")) || (patronomyc.endsWith("ична")))){
            return "Ж";
        }
        return "М/Ж";
    }

    public static boolean DateCheck(String date){
        SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
        form.setLenient(false);
        try{
            form.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }}


    public static String CurrDate(){
        GregorianCalendar GCal = new GregorianCalendar();
        String result = "";
        String date = GCal.get(Calendar.DATE)+".";
        int month1 = GCal.get(Calendar.MONTH)+1;
        String month = "";
        if (month1<10){month = "0"+month1+".";}
        else {month = month1+".";}
        String year = GCal.get(Calendar.YEAR)+"";
        result = date+month+year;
        return result;
    }

    public static int AgeCalc(String date){
        String date1 = CurrDate();
        String[] mas_date1 = date1.split("\\.");
        int mas_day = Integer.parseInt(mas_date1[0]);
        if (mas_day<10) {date1 = "0"+date1;}
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate Startdate = LocalDate.parse(date, form);
        LocalDate Enddate = LocalDate.parse(date1, form);
        Period result = Period.between(Startdate, Enddate);
        int result1 = result.getYears();
        return result1;
    }

    public static String WordDef(int calc){
        if (calc%10==1 && calc!= 11){
            return calc + " год";
        }
        else if (((calc%10==2) || (calc%10==3) || (calc%10==4)) && calc!= 12 && calc!=13 && calc!=14 ){
            return calc + " года";
        }
        else {
            return calc + " лет";
        }
    }

    public static void main(String[] args){
        Interface.MainWindow();
    }
}
    /*public static void main(String[] args) {
        String[] AllMas = {};
        while (true){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите полное имя пользователя(Фамилия, Имя, Отчество) и дату его рождения(дата.месяц.год):");
        String FullNAD = in.nextLine();
        AllMas = FullNAD.split(" ");
        if (FullFormatCheck(AllMas)){
            if (DateCheck(AllMas[3])) {
                if (LanguageCheck(AllMas)) {break;}
                else{System.out.println("В имени пользователя используются английские буквы");}}
            else {System.out.println("Дата введена некорректно");}}
        else {System.out.println("Параметры введены некорректно");}
        }
        try{
        String result = "";
        result += AllMas[0]+" ";
        String InitName = AllMas[1].charAt(0) + ".";
        String InitPat = AllMas[2].charAt(0) + ". ";
        result += InitName + InitPat;
        result += " " + Gender(AllMas);
        result += " " + WordDef(AgeCalc(AllMas[3]));
        System.out.println(result);}
        catch (Exception e){
            System.out.println("Параметры введены некорректно");
        }
}}*/