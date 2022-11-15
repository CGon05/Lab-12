package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author cgonc
 */
public class AccessLoginView {

    @FXML
    private TextField EmailField;
    @FXML
    private TextField PasswordField;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("AccessFBView.fxml");
    }

    @FXML
    private void LoginUser() throws IOException {

        LogUser();

    }

    public void LogUser() {
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(EmailField.getText().trim());
            // See the UserRecord reference doc for the contents of userRecord.
            System.out.println("Successfully fetched user data: " + userRecord.getEmail());
        } catch (FirebaseAuthException ex) {
            Logger.getLogger(AccessLoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
