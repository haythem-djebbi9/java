module TPADDBOOK {
	requires javafx.controls;
	requires javafx.fxml;
	 exports application;
	    opens application to javafx.fxml, javafx.base;
	
	
}
