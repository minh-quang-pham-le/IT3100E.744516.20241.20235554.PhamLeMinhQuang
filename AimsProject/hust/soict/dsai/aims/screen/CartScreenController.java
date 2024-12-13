package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart.*;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;

public class CartScreenController {
    
    private Cart cart;
    private Store store;
    private JFrame stage;
    private boolean filterByID = true;
    private boolean sortByTitle = true;
    private FilteredList<Media> filteredCart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

	@FXML
	private Button btnDetails;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label costLabel;

    public CartScreenController(Store store, Cart cart, JFrame stage) {
        super();
        this.store = store;
        this.cart = cart;
        this.stage = stage;
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
		btnDetails.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
			}	
		});

        tfFilter.textProperty().addListener(new ChangeListener<String> () {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
			btnRemove.setVisible(false);
			btnPlay.setVisible(false);
			btnDetails.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			btnDetails.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}

    private void showFilteredMedia(String filter) {
		if (filter == null || filter.length() == 0) {
			filteredCart.setPredicate(s -> true);
		} else {
			if (filterByID) {
				try {
					filteredCart.setPredicate(s -> s.getID() == Integer.parseInt(filter));
				} catch (NumberFormatException e) {}
			} else {
				filteredCart.setPredicate(s -> s.getTitle().toLowerCase().contains(filter));
			}
		}
	}

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            this.cart.removeMedia(media);
			throw new NonExistingItemException(); 
        } catch (NonExistingItemException e) {
            Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("Failed to remove");
			alert.setContentText("Media not in cart");
			alert.showAndWait();
        }
        costLabel.setText(String.valueOf(this.cart.totalCost()));
    }

    @FXML
	private void btnPlayPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable)media).play();
			throw new PlayerException();
		} catch (PlayerException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Media Player");
			alert.setHeaderText("ERROR: Media length is non-positive.");
			alert.setContentText("Media cannot be played.");
			alert.showAndWait();
		}
	}

    @FXML
	private void placeOrderPressed(ActionEvent event) {	
		if (this.cart.getSize() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Notification");
			alert.setHeaderText("Success!");
			alert.setContentText("Your order has been placed.");
			alert.showAndWait();
			this.cart.empty();
			costLabel.setText(String.valueOf(this.cart.totalCost()));
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("ERROR: Failed to place order.");
			alert.setContentText("Your cart is empty");
			alert.showAndWait();
		}
	}

    @FXML
	private void setFilterByID() {
		this.filterByID = true;
	}

    @FXML 
	private void setFilterByTitle() {
		this.filterByID = false;
	}

    @FXML
	private void btnSortPressed() {
		if (sortByTitle) {
			this.cart.sortByTitle();
		} else {
			this.cart.sortByCost();
		}
	}

    @FXML
	private void setSortByTitle() {
		this.sortByTitle = true;
	}

    @FXML
	private void setSortByCost() {
		this.sortByTitle = false;
	}
	
	@FXML
	private void viewStore() {
		new StoreScreen(store,cart);
		stage.setVisible(false);
	}
	
	@FXML
	private void addDVDToStore() {
		new AddDigitalVideoDiscToStoreScreen(store, cart);
		stage.setVisible(false);
	}
	
	@FXML
	private void addBookToStore() {
		new AddBookToStoreScreen(store, cart);
		stage.setVisible(false);
	}
	
	@FXML
	private void addCDToStore() {
		new AddCompactDiscToStoreScreen(store, cart);
		stage.setVisible(false);
	}
}
