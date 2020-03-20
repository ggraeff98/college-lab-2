public class ContaCorrente {
    String holder;
    double balance;

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void drawOut(double value) throws SaldoInsuficienteException {
        this.balance = this.balance - value;
        if (this.balance < 0) {
            throw new SaldoInsuficienteException("Not enough balance!");
        }
    }

    public void deposit(double value) throws ValorInvalidoException {
        if (value <= 0) {
            throw new ValorInvalidoException("Invalid value!");
        }

        this.balance = this.balance + value;
    }

}
