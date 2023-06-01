package furama_resort.model;

import java.util.Objects;

public class Contract {
    private int numberContract;
    private String codeBooking;
    private float deposit;
    private float paymentAmount;

    public Contract(int numberContract, String codeBooking, float deposit, float paymentAmount) {
        this.numberContract = numberContract;
        this.codeBooking = codeBooking;
        this.deposit = deposit;
        this.paymentAmount = paymentAmount;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return numberContract == contract.numberContract && Float.compare(contract.deposit, deposit) == 0 && Float.compare(contract.paymentAmount, paymentAmount) == 0 && Objects.equals(codeBooking, contract.codeBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberContract, codeBooking, deposit, paymentAmount);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract=" + numberContract +
                ", codeBooking='" + codeBooking + '\'' +
                ", deposit=" + deposit +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
