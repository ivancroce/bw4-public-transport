package bw4_team5.entities;

public class Customer extends User {
    private Card card;

    public Customer(){}

    public Customer(long id,String firstName,String lastName){
        super(id, firstName, lastName);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "card=" + card +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
