module com.minhquan.oubussystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minhquan.oubussystem to javafx.fxml;
    exports com.minhquan.oubussystem;
}
