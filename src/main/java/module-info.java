module com.patient.patientdoctor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.patient.patientdoctor to javafx.fxml;
    exports com.patient.patientdoctor;
}