module com.minhquan.oubussystem {
     requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires java.naming;
    requires java.base;
    requires org.hibernate.orm.core;

    opens com.minhquan.oubussystem to javafx.fxml;
    exports com.minhquan.oubussystem;
    //requires java.persistence;
}
