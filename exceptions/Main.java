public class Main {

    public static void main(String[] args) throws SaldoInsuficienteException, ValorInvalidoException {
        ContaCorrente contaCorrente = new ContaCorrente();

        Teclado keyboard = new Teclado();

        contaCorrente.setBalance(200);

        System.out.println("Current balance: " + contaCorrente.getBalance());

        contaCorrente.drawOut(keyboard.leDouble("How many do you want to draw out? "));

        contaCorrente.deposit(keyboard.leDouble("How many do you want to deposit? "));
    }
}
