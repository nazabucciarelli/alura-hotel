package views;

import controller.BookingController;
import controller.CustomerController;
import model.Booking;
import model.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Optional;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHuesped;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;
    private BookingController bookingController;
    private CustomerController customerController;
    /**
     * Launch the application.
     */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

    /**
     * Create the frame.
     */
    public Busqueda(long userId) {
        this.bookingController = new BookingController();
        this.customerController = new CustomerController();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);


        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 360, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");

        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
        scroll_table.setVisible(true);

        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
        modeloHuesped.addColumn("Número de Huesped");
        modeloHuesped.addColumn("Nombre");
        modeloHuesped.addColumn("Apellido");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        modeloHuesped.addColumn("Número de Reserva");
        cargarTablas();
        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario(userId);
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario(userId);
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarPorParametro(txtBuscar.getText());
            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eliminar();
                limpiarTablas();
                cargarTablas();
            }
        });

        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modificarRegistro();
                limpiarTablas();
                cargarTablas();
            }
        });

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
    }

    private boolean tieneFilaElegida(JTable table) {
        return table.getSelectedRowCount() != 0 || table.getSelectedColumnCount() != 0;
    }

    private void eliminar() {
        if (!tieneFilaElegida(tbHuespedes) && !tieneFilaElegida(tbReservas)) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }
        if (tieneFilaElegida(tbHuespedes)) {
            Optional.ofNullable(tbHuespedes.getModel().getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                    .ifPresentOrElse(fila -> {
                        long id = Long.parseLong(tbHuespedes.getModel().getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
                        int rowsDeleted = this.bookingController.deleteById(id);
                        JOptionPane.showMessageDialog(this, "Se han eliminado " + rowsDeleted + " clientes y reservas.");
                    }, () -> JOptionPane.showMessageDialog(this, "Ha ocurrido un error"));
        }
        if (tieneFilaElegida(tbReservas)) {
            Optional.ofNullable(tbReservas.getModel().getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                    .ifPresentOrElse(fila -> {
                        long id = Long.parseLong(tbReservas.getModel().getValueAt(tbReservas.getSelectedRow(), 0).toString());
                        int bookingsCustomersDeleted = this.bookingController.deleteById(id);
                        JOptionPane.showMessageDialog(this, "Se han eliminado " + bookingsCustomersDeleted + " clientes y reservas.");
                    }, () -> JOptionPane.showMessageDialog(this, "Ha ocurrido un error"));
        }
    }

    public void modificarRegistro(){
        if (tieneFilaElegida(tbHuespedes)) {
            Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                    .ifPresentOrElse(fila -> {
                        long id = (long) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0);
                        String name = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
                        String lastname = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
                        Date birthDate = Date.valueOf((String)modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3));
                        String nacionality = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),4).toString();
                        String phoneNumber = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),5).toString();
                        this.customerController.updateById(new Customer(name,lastname,birthDate,nacionality,phoneNumber), id);
                        JOptionPane.showMessageDialog(this,"Registro de ID " + id +" editado correctamente");
                    }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
        } else if(tieneFilaElegida(tbReservas)){
            Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                    .ifPresentOrElse(fila -> {
                        long id = (long) modelo.getValueAt(tbReservas.getSelectedRow(), 0);
                        Date checkinDate = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
                        Date checkoutDate = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
                        double value = (double) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
                        String payMethod = modelo.getValueAt(tbReservas.getSelectedRow(),4).toString();
                        this.bookingController.updateById(new Booking(checkinDate,checkoutDate,value,payMethod), id);
                        JOptionPane.showMessageDialog(this,"Registro de ID " + id +" editado correctamente");
                    }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
        }
    }

    private void cargarTablas() {
        List<Customer> customers = customerController.getAllCustomers();
        List<Booking> bookings = bookingController.getAllBookings();
        customers.forEach(customer -> modeloHuesped.addRow(new Object[]{customer.getId(), customer.getName(),
                customer.getLastname(), customer.getBirthDate(), customer.getNacionality(), customer.getPhoneNumber(),
                customer.getBookingId()}));
        bookings.forEach(booking -> modelo.addRow(new Object[]{booking.getId(), booking.getCheckInDate(), booking.getCheckOutDate(),
                booking.getValue(), booking.getPayMethod()}));
    }

    private void limpiarTablas() {
        modelo.getDataVector().clear();
        modeloHuesped.getDataVector().clear();
    }

    private void buscarPorParametro(String param){
        limpiarTablas();
        if(!param.isEmpty()){
            try{
                long id = Long.parseLong(param);
                List<Customer> customersResult = this.customerController.getByBookingId(id);
                customersResult.forEach(customer -> modeloHuesped.addRow(new Object[]{customer.getId(), customer.getName(),
                        customer.getLastname(), customer.getBirthDate(), customer.getNacionality(), customer.getPhoneNumber(),
                        customer.getBookingId()}));
                List<Booking> bookingsResult =  this.bookingController.getById(id);
                bookingsResult.forEach(booking -> modelo.addRow(new Object[]{booking.getId(), booking.getCheckInDate(), booking.getCheckOutDate(),
                        booking.getValue(), booking.getPayMethod()}));

            } catch (Exception e){
                List<Customer> customersResult = this.customerController.getByLastname(param);
                customersResult.forEach(customer -> modeloHuesped.addRow(new Object[]{customer.getId(), customer.getName(),
                        customer.getLastname(), customer.getBirthDate(), customer.getNacionality(), customer.getPhoneNumber(),
                        customer.getBookingId()}));
                List<Booking> bookingsResult =  this.bookingController.getById(customersResult.get(0).getBookingId());
                bookingsResult.forEach(booking -> modelo.addRow(new Object[]{booking.getId(), booking.getCheckInDate(), booking.getCheckOutDate(),
                        booking.getValue(), booking.getPayMethod()}));
            }
        } else {
            limpiarTablas();
            cargarTablas();
        }
    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
