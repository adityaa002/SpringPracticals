package in.co.rays.ioc;

public class Order1 {

	public Payment payment;
	public Inventory inventory;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void bookATicket(int items) {

		int price = 10;

		double totalAmount = 10 * items;

		double updatedBalance = payment.makePayment(totalAmount);

		int updatedStock = inventory.sold(items);

		System.out.println("Tickets booked : " + items);
		System.out.println("Amount paid : " + totalAmount);
		System.out.println("Remaining balance : " + updatedBalance);
		System.out.println("Tickets left : " + updatedStock);
	}
}
