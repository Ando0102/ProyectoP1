package VentaDoctor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Logical.Cita;
import Logical.Doctor;
import javafx.scene.layout.Background;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;




public class pnlCitasbtn extends JPanel  {
	//private static JTable table;
	//hora fila
	
	///
			private static Object[] fila;
			private static String[] columnNames = {"", "Domingo", "Lunes", "Martes", 
					"Miercoles", "Jueves", "Viernes", "Sabado"

				};
			private static DefaultTableModel modelo;
			private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
			private static JTable table;
			Doctor miDoctor = null;
			private JTextArea txtrBien;
			
		/**
		 * Create the applet.
		 */
		public pnlCitasbtn(Doctor miDoc) {
		
			this.miDoctor=miDoc;
			
			setBackground(new Color(240, 248, 255));
			setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 103, 1071, 481);
			add(panel_1);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setSize(1071, 443);
			scrollPane.setLocation(0, 0);
			panel_1.add(scrollPane);
			setBounds(0, 0, 1071, 783);
			txtrBien = new JTextArea();
			txtrBien.setBackground(UIManager.getColor("Button.background"));
			txtrBien.setEditable(false);
			txtrBien.setBounds(489, 33, 164, 45);
			add(txtrBien);
			table = new JTable();
			table.setDefaultEditor(Object.class, null);//sirve para evitar que se edite la table
			table.setDefaultRenderer(Object.class, new DTable());//dando formato
			
			modelo = new DefaultTableModel();
			cargar();
			table.setModel(modelo);
			JTableHeader header = table.getTableHeader();
		    header.setBackground(new Color(176, 196, 222));
		    table.setBackground( new Color(240, 248, 255));
		//
		
			
			
			cargarDatos();
			scrollPane.setViewportView(table);
			
	
		

			table.addMouseListener(new MouseAdapter() {
				private Cita ciataDelDia;
				private Calendar fechaCitaCompara;

				@Override
				public void mouseClicked(MouseEvent e) {

					Calendar d = Calendar.getInstance();
					d.setTime(fechaActual());
					
				/*String country;
					int delivery;*/
					int row =0;
					int colu = 0;
					
					if(table.getSelectedRow()>=0){
						System.out.println("hora por fila: "+row);
						row = table.getSelectedRow();
						colu=table.getSelectedColumn();
						//d.get(Calendar.DAY_OF_WEEK);//da la dia semana

						if(d.get(Calendar.DAY_OF_WEEK)==colu) {
							System.out.println("Dia actual selecionado");
							String n = "";
							n = (String) table.getValueAt(row, colu);
							fechaCitaCompara = Calendar.getInstance();
							fechaCitaCompara.setTime(fechaActual());
							if(n!=null) {
								//cargar venta Consulta
							//	System.out.println("Contendio: "+n);
								
								//miDoctor.buscar_Cita_Fecha(d);
							/*	
								System.out.println("DESDE CONSULTA");
								System.out.println("D: "+fechaCitaCompara.get(Calendar.DATE));
								System.out.println("A: "+fechaCitaCompara.get(Calendar.YEAR));
								System.out.println("M: "+fechaCitaCompara.get(Calendar.MONTH));
						*/
						//	 miDoctor.pruebaFecha(fechaCitaCompara);
								switch (row) {
								case 0:
									//son las 8
									
									ciataDelDia = miDoctor.buscar_Cita_Fecha(fechaCitaCompara, 8);
									System.out.println(ciataDelDia.getMiPersona().getNombre());
									System.out.println("SOn las 8");
									break;
								case 1:
									//son las 9
									ciataDelDia = miDoctor.buscar_Cita_Fecha(fechaCitaCompara, 9);

									System.out.println("SOn las 9");
									break;
								case 2:
									//son las 10
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 10);
									System.out.println("SOn las 10");
									break;
								case 3:
									//son las 11
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 11);
									System.out.println("SOn las 11");
									break;
								case 4:
									//son las 12
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 12);
									System.out.println("SOn las 12");
									break;
								case 5:
									//son las 13
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 13);
									System.out.println("SOn las 13");
									break;
								case 6:
									//son las 14Dd
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 14);
									System.out.println("SOn las 14");
									break;
								case 7:
									//son las 15
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 15);
									System.out.println("SOn las 15");
									break;
								case 8:
									//son las 16
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 16);
									System.out.println("SOn las 16");
									break;
								case 9:
									//son las 17
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 17);
									System.out.println("SOn las 17");
									break;
								case 10:
									//son las 14
									ciataDelDia = miDoctor.
									buscar_Cita_Fecha(fechaCitaCompara, 18);
									System.out.println("SOn las 18");
									break;
								default:
									break;
									
									
								}
								if(ciataDelDia!=null) {
									//abrimos venta
									System.out.println("Existo ventana");
									RealizarConsulta dialog = new RealizarConsulta(ciataDelDia);
									//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									dialog.setVisible(true);
									
								}else {
									System.out.println("No se puedo cargar");
								}
								
							}else {
								System.out.println("....");
							}
							
						}else {
							//System.out.println("Dia despus o ante dela actual");
						}
						System.out.println("DIAA SEMANA: "+d.get(Calendar.DAY_OF_WEEK));
						System.out.println("row: "+table.getSelectedRow()+"Column"+table.getSelectedColumn());
						switch (row) {
						
						case 1:
							if(row==1) {
								System.out.println("Bienvendo/ Domingo son las 9");
							}
							break;

						default:
							break;
						}
					//	btnEliminar.setEnabled(true);
						///btnModificar.setEnabled(true);
						//int index = table.getSelectedRow();
						//code = (int)table.getModel().getValueAt(index, 0);

						
					}
				}
			});

		}
		
		public static void  cargar() {
			
			modelo.setColumnIdentifiers(columnNames);	
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];		
			int y =8;
			for (int i=0; i<11; i++) {	
				
				if(i==0) {
					fila[0] = "0"+y + ":00";
					
				}else {
					
				}
				if(i==1) {
					fila[0] = "0"+y + ":00";
				}
				if(i==2)
					fila[0] = y + ":00";
				if(i==3)
					fila[0] = y + ":00";
				if(i==4)
					fila[0] = y + ":00";
				if(i==5)
					fila[0] = y + ":00";
				if(i==6)
					fila[0] = y + ":00";
				if(i==7)
					fila[0] = y + ":00";
				if(i==8)
					fila[0] = y + ":00";
				if(i==9)
					fila[0] = y + ":00";
				if(i==10)
					fila[0] = y + ":00";
					
				
					//fila[1] = 
					//fila[2] = 
					//fila[3] = 
					///fila[4] = 
				y++;
				modelo.addRow(fila);
					
				}	
			/*
			 * 	table.setRowHeight(40);
			
			table.setModel(tableModel);		
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getTableHeader().setReorderingAllowed(false);
			TableColumnModel columnModel = table.getColumnModel();
			
			 */
				table.setRowHeight(40);
				
				table.setModel(modelo);		
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				TableColumnModel columnModel = table.getColumnModel();
				

				//sirve para dar un tamnno a las columnas 
			
				columnModel.getColumn(0).setPreferredWidth(90);
				columnModel.getColumn(1).setPreferredWidth(140);
				columnModel.getColumn(2).setPreferredWidth(140);
				columnModel.getColumn(3).setPreferredWidth(140);
				columnModel.getColumn(4).setPreferredWidth(140);
				columnModel.getColumn(5).setPreferredWidth(140);
				columnModel.getColumn(6).setPreferredWidth(140);
				columnModel.getColumn(7).setPreferredWidth(140);
				
				
				
			}	
		public void  cargarDatos() {
		
		//	table.getModel().setValueAt(aux, 3, 3);
			//dias_semana();
			Calendar c = Calendar.getInstance();
			
			c.setTime(fechaActual());
			//fecha_dia_uno__de_semana(c);
			String[] fechasSemana = {
					"","","","",
					"","",""
			};
//------------------------------			
			Calendar Domingo = Calendar.getInstance();
			Calendar Lunes = Calendar.getInstance();
			Calendar Martes = Calendar.getInstance();
			Calendar Miercoles = Calendar.getInstance();
			Calendar Jueves = Calendar.getInstance();
			Calendar Viernes = Calendar.getInstance();
			Calendar Sabado = Calendar.getInstance();

//----------------------------------------------------------
			
			fechasSemana = fechas_semana(c);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {

					Domingo.setTime(sdf.parse(fechasSemana[0]));
					Lunes.setTime(sdf.parse(fechasSemana[1]));
					Martes.setTime(sdf.parse(fechasSemana[2]));
					Miercoles.setTime(sdf.parse(fechasSemana[3]));
					Jueves.setTime(sdf.parse(fechasSemana[4]));
					Viernes.setTime(sdf.parse(fechasSemana[5]));
					Sabado.setTime(sdf.parse(fechasSemana[6]));
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Error a cargar fecha semanas");
				e.printStackTrace();
			}
			//String n = fechasSemana[0];
			//textField.set
			String mesInicio = "";
			switch (Domingo.get(Calendar.MONTH)) {
			case 0:
				mesInicio = "Enero";
				break;
			case 1:
				mesInicio = "Febrero";
				break;
			case 2:
				mesInicio = "Marzo";
				break;
			case 3:
				mesInicio = "Abril";
				break;
			case 4:
				mesInicio = "Mayo";
				break;
			case 5:
				mesInicio = "Junio";
				break;
			case 6:
				mesInicio = "Julio";
				break;
			case 7:
				mesInicio = "Agosto";
				break;
			case 8:
				mesInicio = "Septiembre";
				break;
			case 9:
				mesInicio = "Nobiembre";
				break;
			case 10:
				mesInicio = "Diciembre";
				break;
			default:
				break;
			}
			String mesFin = "";
			switch (Sabado.get(Calendar.MONTH)) {
			case 0:
				mesFin = "Enero";
				break;
			case 1:
				mesFin = "Febrero";
				break;
			case 2:
				mesFin = "Marzo";
				break;
			case 3:
				mesFin = "Abril";
				break;
			case 4:
				mesFin = "Mayo";
				break;
			case 5:
				mesFin = "Junio";
				break;
			case 6:
				mesFin = "Julio";
				break;
			case 7:
				mesFin = "Agosto";
				break;
			case 8:
				mesFin = "Septiembre";
				break;
			case 9:
				mesFin = "Nobiembre";
				break;
			case 10:
				mesFin = "Diciembre";
				break;
			default:
				break;
			}
			String Incio = "";
			if(Domingo.get(Calendar.DATE)<10) {
				Incio = "-Desde el Domingo "+"0"+Domingo.get(Calendar.DATE)+" " +mesInicio;

			}else {
			Incio = "-Desde el Domingo "+Domingo.get(Calendar.DATE)+" " +mesInicio;
			}
			String fin = "";
			fin ="-Hasta el Sabado "+ Sabado.get(Calendar.DATE)+" "+mesFin;
			
			System.out.println("DIA: "+Domingo.get(Calendar.DATE));
			txtrBien.setText(" "+Incio+"\r\n"+" "+fin);
//-------------------------------------------------------------------------			
			
			System.out.println("Domingo:   " +fechasSemana[0]);
			System.out.println("Lunes:     "+fechasSemana[1]);
			System.out.println("Martes:    "+fechasSemana[2]);
			System.out.println("Miercoles: "+fechasSemana[3]);
			System.out.println("Jueves:    "+fechasSemana[4]);
			System.out.println("Viernes:   "+fechasSemana[5]);
			System.out.println("Sabado:    "+fechasSemana[6]);
			
//-------------------------------------------------------------------------			
			///
			String cedula = "";
			
			
			///
			/*
			table.getModel().setValueAt("L-08:00", 0, 1);
			table.getModel().setValueAt("L-09:00", 1, 1);
			table.getModel().setValueAt("L-10:00", 2, 1);
			table.getModel().setValueAt("L-11:00", 3, 1);
			table.getModel().setValueAt("L-12:00", 4, 1);
			table.getModel().setValueAt("L-13:00", 5, 1);
			table.getModel().setValueAt("L-14:00", 6, 1);
			table.getModel().setValueAt("L-15:00", 7, 1);
			table.getModel().setValueAt("L-16:00", 8, 1);
			table.getModel().setValueAt("L-17:00", 9, 1);
			JLabel p = new JLabel("klk\n b");
			JPanel PN = new JPanel();
			PN.setBackground(Color.BLUE);
			JButton N = new JButton("kl");
			table.getModel().setValueAt(N, 10, 1);
			
		
			Calendar auxFecha = Calendar.getInstance();
			
			System.out.println("pepe: ");
			
			System.out.println("Cantida: "+miDoctor.getMisCitas().size());
			System.out.println("Cantida: "+miDoctor.getMisCitas().size());
			System.out.println("-------------");
			*/
			ArrayList<Cita> misC = new ArrayList<Cita>();
			misC = miDoctor.citas_de_semana_actual(Domingo, Sabado);
			//table.getModel().setValueAt(Color.BLUE, 3, 1);

			for (Cita miCita : misC) {
				Calendar hora = miCita.getFecha();
				int auxHora = hora.get((Calendar.DATE));
				int HoraCita = miCita.getHora();
				/*
				System.out.println("Nombre: "+ miCita.getMiPersona().getNombre());
				System.out.println("Dia Semana: "+ auxHora);
				System.out.println("Hora CITA: "+ miCita.getHora());
				System.out.println("-------------");
				*/
				switch (HoraCita) {
				case 8:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 0);
					
					break;
				case 9:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 1);
					break;
				case 10:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 2);
					break;
				case 11:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 3);
					break;
				case 12:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 4);
					break;
				case 13:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 5);
					break;
				case 14:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 6);
					break;
				case 15:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 7);
					break;
				case 16:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 8);
					break;
				case 17:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 9);
					break;
				case 18:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 10);
					break;
				case 19:
					System.out.println("La hora es: "+HoraCita);
					cargarCitas(miCita, 11);
					break;
				default:
					break;
				}
				
			}
		
				
			//table.getModel().setValueAt(, 10, 1);
			//table.getModel().setValueAt("L-18:00", 0, 10);
		//	table.getModel().setValueAt(aValue, rowIndex, columnIndex);
		
		
			}
		public void cargarCitas(Cita miCita, int poner_horaFila) {
			Calendar auxFecha = Calendar.getInstance();
			auxFecha = miCita.getFecha();
			int dia_semana=auxFecha.get(Calendar.DAY_OF_WEEK)-1;

			if(miCita.getEstado().equalsIgnoreCase("Pendiente")) {
				System.out.println("La cita esta esta pendiente");
			
			if(dia_semana==0) {
				System.out.println("****Domingo");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 1);

			}
			if(dia_semana==1) {
				System.out.println("***Lunes");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 2);

			}
			if(dia_semana==2) {
				System.out.println("***Martes");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 3);

			}
			if(dia_semana==3) {
				System.out.println("**Miercoles");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 4);

			}
			if(dia_semana==4) {
				System.out.println("**Jueves");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 5);

			}
			if(dia_semana==5) {
				System.out.println("**Viernes");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 6);

			}
			if(dia_semana==6) {
				System.out.println("**Sabado");
				System.out.println("");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 7);

			}
		}
						
			/*
			switch (dia_semana) {
			
			case 1:
				System.out.println("DOMINGO");
				//Domingo
				//table.getModel().setValueAt(aValue, rowIndex, columnIndex);
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 1);
				
				break;
			case 2:
				// lunes
				System.out.println("lUNES");

				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 2);
				break;
			case 3:
				System.out.println("Marte///");

				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 3);
			
			case 4:
				//miercoles
				System.out.println("Miercoles");
				//System.out.println("CITA MIERCOLES");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 4);
				break;
		
			case 5:
				//Jueves 
				System.out.println("Jueves");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 5);

				break;
			case 6:
				//Viernes
				System.out.println("Viernes");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 6);

				break;
			case 7:
				//Sabado
				System.out.println("Sabado");
				table.getModel().setValueAt(miCita.getMiPersona().getNombre(), poner_horaFila, 7);

				break;

			default:
				break;
			}
					
*/
			
		}

		public void dias_semana() {
			int restadia=0;//para obtener luego dia inicial de una semana 
			String[] strDays = new String[]{
					"Domingo",
					"Lunes",
					"Martes",
					"Miercoles",
					"Jueves",
					"Viernes",
					"Sabado"
					};	
			
			Calendar f = Calendar.getInstance();
			GregorianCalendar calendar = new GregorianCalendar();
			 calendar.setTime(fechaActual());
			f.setTime(fechaActual());
			int dia  = f.get(Calendar.DATE);//dia >n 
			int mes  = f.get(Calendar.MONTH);
			int anno = f.get(Calendar.YEAR);
			
			
			System.out.println("Hoy es : " + strDays[f.get(Calendar.DAY_OF_WEEK) - 1]);

			//f.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
			//int nuevo = f.get(Calendar.DATE);
			//System.out.println("EL nuevo dia: "+nuevo );//dia >n );
			//System.out.println("Hoy es : " + strDays[f.get(Calendar.DAY_OF_WEEK) - 1]);

			
			System.out.println("DIA SEMANA: "+ f.get(Calendar.DAY_OF_WEEK));
			switch (f.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				//Domingo
				restadia = 0;
				break;
			case 2:
				// lunes
				restadia = -1;
				break;
			case 3:
				//martes
				restadia = -2;
				break;
			case 4:
				//miercoles
				restadia = -3;
				break;
			case 5:
				//Jueves 
				restadia = -4;
				break;
			case 6:
				//Viernes
				restadia = -5;
				break;
			case 7:
				//Sabado
				restadia = -6;
				break;

			default:
				break;
			}
			f.add(Calendar.DAY_OF_YEAR, restadia);  // numero de días a añadir, o restar en caso de días<0
			System.out.println("Primer dia semana : " + f.get(Calendar.DATE));

			/*
			int ks = 6;
			int[] mesesValor = {
					0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0
					};
			
			*/
					
		
			//
			/*
		//	f.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
			int ultimoDigito = anno%1000;//ultimo digito A
			if(calendar.isLeapYear(anno)) {
				//El año es bisiesto
				mesesValor[0] = 6;
				mesesValor[1] = 2;
				
			}else {
				mesesValor[0] = 0;
				mesesValor[1] = 3;
				//El año NO es bisiesto 
			}
			mesesValor[2] = 3;
			mesesValor[3] = 6;
			mesesValor[4] = 1;
			mesesValor[5] = 4;
			mesesValor[6] = 6;
			mesesValor[7] = 2;
			mesesValor[8] = 5;
			mesesValor[9] = 0;
			mesesValor[10] = 3;
			mesesValor[11]  =  5;
			//(Calendar.MONTH));
			//annio = Integer.toString(c.get(Calendar.YEAR))
			System.out.println("dia: "+dia+"mes: "+mes +" Anno: "+anno+"Ultimo digito: "+ultimoDigito);
		*/
			
			/*
			int N = dia;
			int M = mesesValor[mes-1];
			int A = ultimoDigito;
			int diaSemanaActual = (N  + M + A+ A/4+ks)%7;//dia actua
			System.out.println("EL DIA DE LA SEMANA: "+diaSemanaActual);

		/*
		 *0 > D
		 *1 > L
		 *
		 * 6 > S
		 *
		 */
		

		//el dia de la semana obtien get(Calendar.DAY_OF_WEEK)
		// El dia de la semana inicia en el 1 mientras que el array empieza en el 0
		
		}
		
		public Date fechaActual() {
			Date fecha = new Date();
			SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
			
			return fecha;
		}
		
		public Calendar fecha_dia_uno__de_semana(Calendar fecha) {
			//debuelve la fecha del primer dia de la semana 
			
			//retonarna el primer dia de la semana actual
			Calendar aux = Calendar.getInstance();
			int restadia =0;
			switch (aux.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				//Domingo
				restadia = 0;
				break;
			case 2:
				// lunes
				restadia = -1;
				break;
			case 3:
				//martes
				restadia = -2;
				break;
			case 4:
				//miercoles
				restadia = -3;
				break;
		
			case 5:
				//Jueves 
				restadia = -4;
				break;
			case 6:
				//Viernes
				restadia = -5;
				break;
			case 7:
				//Sabado
				restadia = -6;
				break;

			default:
				break;
			}
			aux.add(Calendar.DAY_OF_YEAR, restadia); 
			System.out.println("El primer dia de la semana: "+ aux.get(Calendar.DATE));
			return aux;
		}

		
		public String[] fechas_semana(Calendar fecha) {
			//Devuelve las fecha de los 7 dia de la semana 
			String fechasx[] = {
					"","","","","",
					"","","",""};
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
			Calendar a = Calendar.getInstance();
			
			a = fecha_dia_uno__de_semana(fecha);
			fechasx[0]= sdf.format(a.getTime());

		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[1]= sdf.format(a.getTime());

		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[2]= sdf.format(a.getTime());
		    
		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[3]= sdf.format(a.getTime());
		   
		    a.add(Calendar.DAY_OF_YEAR, 1);	
		    fechasx[4]= sdf.format(a.getTime());
		    
		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[5]= sdf.format(a.getTime());
		    
		    a.add(Calendar.DAY_OF_YEAR, 1);//sabado
		    fechasx[6]= sdf.format(a.getTime());
		    return fechasx;
			
		}


		public void cargar_Agenda_Doctor() {
			Doctor miDoctor= null;
			
			for (Cita miCita : miDoctor.getMisCitas()) {
				
				
			}
			
			
			
		}

		public Cita buscarCita() {
			Cita no = null;
			Calendar obj = Calendar.getInstance();
			obj.setTime(fechaActual());
			for (Cita pepe : miDoctor.getMisCitas()) {
				if(pepe.getFecha().equals(obj)) {
					System.out.println("prueba pepe");
				}else {
					System.out.println("no tengo peque cho pepe");
				}
			}
			return no;
		}
}
