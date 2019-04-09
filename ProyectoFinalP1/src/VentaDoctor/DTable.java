package VentaDoctor;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class DTable extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent (JTable table,
	Object value, boolean isSelected, boolean hasFocus, int rown, int column){
		
	JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rown, column);
	cell.setBackground(Color.WHITE);
	cell.setForeground(Color.black);
	Calendar mi = Calendar.getInstance();
	mi.setTime(fechaActual());
	switch (mi.get(Calendar.DAY_OF_WEEK)) {
	case 1:
		//Domingo
		if(column==1) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		break;
	case 2:
		// lunes
		if(column==2) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		
		break;
	case 3:
		//martes
		if(column==3) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		break;
	case 4:
		//miercoles
		if(column==4) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		break;
	case 5:
		//Jueves 
		if(column==5) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		break;
	case 6:
		//Viernes
		if(column==6) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		break;
	case 7:
		//Sabado
		if(column==7) {
			cell.setBackground(Color.LIGHT_GRAY);
		}
		break;

	default:
		break;
	}

	return cell;
	
	}
	public Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}


}
