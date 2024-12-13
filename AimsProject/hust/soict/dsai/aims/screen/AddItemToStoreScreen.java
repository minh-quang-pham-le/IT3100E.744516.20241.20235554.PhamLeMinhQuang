package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddItemToStoreScreen extends JFrame {

    private Store store;
	private Cart cart;
	
	public AddItemToStoreScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new StoreScreen(store, cart);
			}
		});
	}
}
