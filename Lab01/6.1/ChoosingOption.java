import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
    "Do you want to change to the first class ticket");
        JOptionPane.showMessageDialog(null,"You've chosen: " 
        + (option==JOptionPane.YES_OPTION?"Yes":"NO"));
        System.exit(0);
    }    
}

/**
 * If users choose "Cancel", the output will be: "You've chosen: NO"
 * To customize the options to users we can use JOptionPane.showOptionDialog
 * Object[] options = {"I do", "I don't"};
 * int option = JOptionPane.showOptionDialog(null,
    "Do you want to change to the first class ticket" // Message
    JOptionPane.YES_NO_OPTION, // Kiểu tùy chọn (2 lựa chọn)
    JOptionPane.QUESTION_MESSAGE, // Kiểu thông điệp
    null,
    options, // Mảng tùy chọn đã khai báo ở trên
    options[0]); // Giá trị mặc định ("I do")
 */