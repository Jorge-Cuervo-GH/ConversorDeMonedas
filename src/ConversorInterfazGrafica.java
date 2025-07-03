import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;


public class ConversorInterfazGrafica extends JFrame {

    private JComboBox<String> comboOrigen, comboDestino;
    private JTextField campoCantidad;
    private JLabel etiquetaResultado;
    private JTextArea areaHistorial;
    private HistorialConversiones historial;

    public ConversorInterfazGrafica() {
        setTitle("Conversor de Monedas");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));

        historial = new HistorialConversiones();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                salirYGuardar();
            }
        });

        JPanel panelEntrada = new JPanel(new GridLayout(5, 2, 5, 30));
        String[] monedas = {"USD = dólar estadounidense", "EUR = euro", "COP = peso colombiano", "GBP = libra esterlina", "JPY = yen japones",
        "MXN = peso mexicano", "BRL = real brasileño", "ARS = peso argentino", "CHF = franco suizo", "CAD = dólar canadiense",
        "AUD = dólar australiano", "NZD = dólar neozelandes", "CNY = yuan chino", "INR = rupia india", "RUB = rublo ruso", "CLP = peso chileno",
        "PEN = sol peruano", "VES = bolivar venezolano", "EGP = libra egipcia", "NGN = naira nigeriana", "ZAR = rand sudafricano",
        "KRW = won surcoreano", "TRY = lira turca", "SEK = corona sueca", "NOK = corona noruega", "SGD = dólar de singapur", "HKD = dolar de hong kong",
        "DKK = corona danesa", "OMR = rial omaní", "CZK = corona checa", "HUF = florin húngaro", "ILS = shekel israelí", "MYR = ringgit malayo",
        "THB = baht tailandés", "PHP = peso filipino", "IDR = rupia indonesia", "PKR = rupia pakistaní", "BGN = lev búlgaro", "RON = leu rumano",
        "HRK = kuna croata", "ISK = corona islandesa", "ALL = lek albanés", "UAH = grivna ucraniana", "KWD = dinar kuwaití", "BHD = dinar bareiní",
        "VND = dong vietnamita", "AED = dirham de los emiratos árabes unidos", "SAR = riyal saudita", "QAR = riyal catarí", "PLN = zloty polaco",};

        JLabel etiquetaMonedaBase = new JLabel("Moneda base:");
        etiquetaMonedaBase.setBorder(new EmptyBorder(0, 50, 0, 0)); // Desplaza hacia la derecha
        panelEntrada.add(etiquetaMonedaBase);
        comboOrigen = new JComboBox<>(monedas);
        panelEntrada.add(comboOrigen);

        JLabel etiquetaMonedaDestino = new JLabel("Moneda destino:");
        etiquetaMonedaDestino.setBorder(new EmptyBorder(0, 50, 0, 0)); // Desplaza hacia la derecha
        panelEntrada.add(etiquetaMonedaDestino);

        comboDestino = new JComboBox<>(monedas);
        comboDestino.setSelectedIndex(1);
        panelEntrada.add(comboDestino);

        JLabel etiquetaMonto = new JLabel("Monto a convertir:");
        etiquetaMonto.setBorder(new EmptyBorder(0, 50, 0, 0)); // Desplaza hacia la derecha
        panelEntrada.add(etiquetaMonto);
        campoCantidad = new JTextField();
        panelEntrada.add(campoCantidad);

        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.addActionListener(e -> convertirMoneda());
        panelEntrada.add(botonConvertir);

        etiquetaResultado = new JLabel("Resultado: ");
        panelEntrada.add(etiquetaResultado);

        add(panelEntrada, BorderLayout.NORTH);

        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaHistorial);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Historial de Conversiones"));

        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convertirMoneda() {
        String origen = comboOrigen.getSelectedItem().toString().split(" = ")[0];
        String destino = comboDestino.getSelectedItem().toString().split(" = ")[0];
        String textoCantidad = campoCantidad.getText();

        try {
            double cantidad = Double.parseDouble(textoCantidad);
            double resultado = ConversorMonedas.convertir(origen, destino, cantidad);

            Conversion conversion = new Conversion(origen, destino, cantidad, resultado, LocalDateTime.now());
            String mensaje = conversion.toString();

            etiquetaResultado.setText("Resultado: " + mensaje);
            areaHistorial.append(mensaje + "\n");
            historial.agregar(conversion);

        } catch (NumberFormatException e) {
            etiquetaResultado.setText("Cantidad inválida.");
        } catch (Exception e) {
            etiquetaResultado.setText("Error: " + e.getMessage());
        }
    }

    private void salirYGuardar() {
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Deseas guardar el historial antes de salir?",
                "Salir", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            historial.guardarEnArchivo("historial_conversiones.txt");
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConversorInterfazGrafica::new);
    }
}
