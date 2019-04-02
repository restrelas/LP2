package lab3;

import java.util.Scanner;

public class Main {

    public static String openMenu(){
        return "(C)adastrar Contato\n" + "(L)istar Contatos\n" +  "(E)xibir Contato\n" +  "(S)air\n" + "\nOpção> ";
    }

    public static void main(String[] args){
        String option;

        Scanner sc = new Scanner(System.in);
        System.out.println(openMenu());
        while(true){
            option = sc.nextLine();
            switch (option) {
                case "C":
                    System.out.println("Posição: ");
                    int position = sc.nextInt();
                    System.out.println("Nome: ")
                    String
                case "L":
                case "E":
                case "S":
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        }


    }
}
