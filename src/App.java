import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o limite do cartão: R$ ");
        double limite = scan.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0){
            System.out.println("Digte a descrição da compra: ");
            String descricao = scan.next();

            System.out.println("Digite o valor da compra: R$ ");
            double valor = scan.nextDouble();

            Compra compra = new Compra(descricao,valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para conitnuar");
                sair = scan.nextInt();
            
            }else{
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***************************************");
        System.out.println("COMPRAS REALIZADAS:\n");

        double totalCompras = 0;
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
           System.out.println(c.getDescricao() + " - " + c.getValor());
           totalCompras += c.getValor(); 
        }
        System.out.println("***************************************");
        System.out.println("Compras Total: R$ " + totalCompras);
        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());

        scan.close();
    }
}
