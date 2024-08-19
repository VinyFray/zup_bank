import java.util.Scanner;

public class IO {

    public static Scanner input(String message){
        System.out.println(message);
        return new Scanner(System.in);
    }

    public static int menu(){
        StringBuilder model = new StringBuilder();
        model.append("Digite 1 para abrir uma conta");
        model.append("\n");
        model.append("Digite 2 para visualizar contas existentes");
        model.append("\n");
        model.append("Digite 3 para dacar de uma conta existente");
        System.out.println(model);
        return new Scanner(System.in).nextInt();
    }
}
