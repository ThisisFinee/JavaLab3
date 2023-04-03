import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Interface{
    static String Title_message = "Окно сообщений";
    static JFrame a = new JFrame("Personal info");
    static JPanel lp = new JPanel();
    static JLabel label1 = new JLabel("Введите полное имя пользователя(Фамилия, Имя, Отчество):");
    static JTextField Full_name = new JTextField(30);
    static JLabel label2 = new JLabel("Введите дату рождения(дата.месяц.год):");
    static JTextField Date1 = new JTextField(30);
    static JButton but = new JButton("Получить результат:");
    static JLabel label3 = new JLabel();

    private static void addActions(){
        but.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean flag = false;
                String FullNAD;
                String[] AllMas = {};
                FullNAD = Full_name.getText() + " " + Date1.getText();
                System.out.println(FullNAD);
                AllMas = FullNAD.split(" ");
                System.out.println(Arrays.toString(AllMas));
                if (Main.FullFormatCheck(AllMas)){
                    if (Main.DateCheck(AllMas[3])) {
                        if (Main.LanguageCheck(AllMas)) {flag = true;}
                        else{JOptionPane.showMessageDialog(a, new String[] {"В имени пользователя используются английские буквы"}, Title_message,  JOptionPane.ERROR_MESSAGE); }}
                    else {JOptionPane.showMessageDialog(a, new String[] {"Дата введена некорректно"}, Title_message,  JOptionPane.ERROR_MESSAGE); }}
                else {JOptionPane.showMessageDialog(a, new String[] {"Параметры введены некорректно"}, Title_message,  JOptionPane.ERROR_MESSAGE);}
                if (flag == true) {
                        String result = "";
                        result += AllMas[0]+" ";
                        String InitName = AllMas[1].charAt(0) + ".";
                        String InitPat = AllMas[2].charAt(0) + ". ";
                        result += InitName + InitPat;
                        result += " " + Main.Gender(AllMas);
                        result += " " + Main.WordDef(Main.AgeCalc(AllMas[3]));
                        label3.setText(result);
                }
            }
        });
    }
    public static void MainWindow(){
        a.setLayout(null);
        a.setTitle("DateInj");
        lp.add(label1);
        lp.add(Full_name);
        lp.add(label2);
        lp.add(Date1);
        lp.add(but);
        lp.add(label3);
        a.setContentPane(lp);
        a.setVisible(true);
        a.setSize(400,200);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        addActions();
    }

}
