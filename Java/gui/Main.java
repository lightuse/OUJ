package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Eliza クローン
 * @author lightuse
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    static JFrame myframe = new JFrame("GUItest");
    static JTextField mytextfield = new JTextField();
    static JButton mybutton = new JButton("OK");
    static JTextArea mytextarea = new JTextArea();
    static Eliza myEliza = new Eliza();

    public static void main(String[] args) {
        // TODO code application logic here
        myframe.setBounds(100, 100, 640, 480);
        myframe.setVisible(true);
        myframe.setLayout(null);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.add(mytextfield);
        mytextfield.setBounds(10, 10, 500, 50);
        myframe.add(mytextarea);
        mytextarea.setBounds(10, 70,600,360);
        myframe.add(mybutton);
        mybutton.setBounds(520, 10, 100, 50);
        mybutton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //ここにボタンをクリックした場合の処理
                    mytextarea.setText(mytextarea.getText()+"\n"
                            + mytextfield.getText()+"\n"
                            +"Eliza:「"
                            +myEliza.speak(mytextfield.getText())+"」");
                }
            }
        );
    }
}

/**
 * Elizaクラス
 */
class Eliza{

    /**
     * 会話アルゴリズム
     * @param str1
     * @return
     */
    public String speak(String str1) {
        //「こんにちは」が含まれるか判断
        final int hello = str1.indexOf("こんにちは");
        if (hello >= 0) return("ちわ！");

        //「ありがとう」が含まれるか判断
        final int thanks = str1.indexOf("ありがとう");
        if (thanks >= 0) return("どういたしまして！");

        //私は○○が好きに対応
        int k1 = str1.indexOf("私は");
        int k2 = str1.indexOf("が好き");
        if (k1 >= 0 && k2 >= 0) {
            String str2 = str1.substring(k1 + 2, k2);
            return ("あなたが好きなのは「" + str2 + "」ですね？");
        }

        //どんな食べ物が好き？
        k1 = str1.indexOf("食べ物");
        k2 = str1.indexOf("好き");
        if (k1 >= 0 && k2 >= 0) {
            java.util.Date d = new java.util.Date();
            final long t = d.getTime();
            if (t % 3 == 0) {
                return ("Elizaは夏みかんが好き．");
            }
            else if (t % 3 == 1) {
                return ("あなたは，何が好きなの？");
            }
            else {
                return ("今，おなかいっぱい．");
            }
        }
        return randomMessage();
    }

    /**
     * ランダムメッセージを作成し返す
     * @return
     */
    private String randomMessage() {
        Random random = new Random();
        final int randomValue = random.nextInt(4);
        String str = "";
        switch (randomValue) {
            case 0:
                str = "え，何？";
                break;
            case 1:
                str = "疲れちゃった";
                break;
            case 2:
                str = "今日はもう眠たい";
                break;
            case 3:
                str = "また明日ね";
                break;
            default:
                str = "え，何？";
                break;
        }
        return str;
    }
}