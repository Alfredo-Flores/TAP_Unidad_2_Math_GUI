import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class InterfazMain extends JFrame implements ActionListener {
    JSplitPane splitPane = new JSplitPane();    Panel sidebar = new Panel(), mainpane = new Panel();
    JPanel innerpane = new JPanel();
    File montserratregular = new File("src/assets/Montserrat-Regular.ttf");
    File montserratbold = new File("src/assets/Montserrat-Bold.ttf");
    Font fontregular = Font.createFont(Font.TRUETYPE_FONT, montserratregular);
    Font fontbold = Font.createFont(Font.TRUETYPE_FONT, montserratbold);
    Font sizedFontBold = fontbold.deriveFont(14f);
    Font sizedFontRegular = fontregular.deriveFont(12f);
    Image imagetoothicon = new ImageIcon("src/assets/logo.png").getImage();
    ImageIcon imagetooth = new ImageIcon(new ImageIcon("src/assets/logo.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon imagebrand = new ImageIcon(new ImageIcon("src/assets/brand.png").getImage().getScaledInstance(120, 40, Image.SCALE_SMOOTH));
    ImageIcon imageclientes = new ImageIcon(new ImageIcon("src/assets/client.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    ImageIcon imagecitas = new ImageIcon(new ImageIcon("src/assets/documents.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    ImageIcon imagetrabajadores = new ImageIcon(new ImageIcon("src/assets/employees.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    ImageIcon imageshrink = new ImageIcon(new ImageIcon("src/assets/arrow-left-solid.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    ImageIcon imageexpand = new ImageIcon(new ImageIcon("src/assets/arrow-right-solid.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    ImageIcon imageVariacionCon = new ImageIcon(new ImageIcon("src/assets/VariacionCon.png").getImage().getScaledInstance(165, 30, Image.SCALE_SMOOTH));
    ImageIcon image_a = new ImageIcon(new ImageIcon("src/assets/a.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_b = new ImageIcon(new ImageIcon("src/assets/b.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_c = new ImageIcon(new ImageIcon("src/assets/c.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_d = new ImageIcon(new ImageIcon("src/assets/d.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_e = new ImageIcon(new ImageIcon("src/assets/e.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_f = new ImageIcon(new ImageIcon("src/assets/f.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_g = new ImageIcon(new ImageIcon("src/assets/g.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_h = new ImageIcon(new ImageIcon("src/assets/h.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_i = new ImageIcon(new ImageIcon("src/assets/i.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_j = new ImageIcon(new ImageIcon("src/assets/j.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_k = new ImageIcon(new ImageIcon("src/assets/k.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_L = new ImageIcon(new ImageIcon("src/assets/L.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
    ImageIcon image_m = new ImageIcon(new ImageIcon("src/assets/m.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_n = new ImageIcon(new ImageIcon("src/assets/n.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    JButton TabProbabilidad = new JButton("Probabilidad", imageclientes), TabTrigonometria = new JButton("Trigonometria", imagecitas);
    JButton TabCalculo = new JButton("Calculo", imagetrabajadores), buttonshrink = new JButton(imageshrink);
    JTextField field_n = new JTextField(), field_m = new JTextField(), fieldapellidomaterno = new JTextField();
    JTextField fieldtelefono = new JTextField(), fielddireccion = new JTextField(), fieldprocedimiento = new JTextField();
    JTextField fieldcosto = new JTextField(), fieldsalario = new JTextField();
    int pestanaactual = 1;
    boolean banderasidebar = false;

    InterfazMain() throws IOException, FontFormatException {
        super("OdontoClinic - Recepción");  setSize(1152, 640);
        setMinimumSize(new Dimension(850, 480));    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);    setResizable(true);     setIconImage(imagetoothicon);
        this.setSideBar(1); this.setProbabilidadPane();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, mainpane);
        splitPane.setEnabled(false);    getContentPane().add(splitPane);
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "¿Estas seguro que quieres salir del administrador?", "Cerrar ventana",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == 0){
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        InterfazMain frame = new InterfazMain();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object Objecto = actionEvent.getSource();

        try {
            if (Objecto == TabProbabilidad && pestanaactual != 1) {
                int response = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir de este panel? podria perderse progreso", "Cambiar de panel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == 0) {
                    this.removeSidebar();   this.removeCurrentPane();
                    this.setSideBar(1);     this.setProbabilidadPane();
                } else {
                    return;
                }
            }
            if (Objecto == TabTrigonometria && pestanaactual != 2) {
                int response = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir de este panel? podria perderse progreso", "Cambiar de panel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == 0) {
                    this.removeSidebar();   this.removeCurrentPane();
                    this.setSideBar(2);     this.setTrignometriaPane();
                    innerpane.repaint();    innerpane.revalidate();
                    mainpane.repaint();    mainpane.revalidate();
                } else {
                    return;
                }
            }
            if (Objecto == TabCalculo && pestanaactual != 3) {
                int response = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir de este panel? podria perderse progreso", "Cambiar de panel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == 0) {
                    this.removeSidebar();   this.removeCurrentPane();
                    this.setSideBar(3); this.setCalculoPane();
                } else {
                    return;
                }
            }
            if (Objecto == buttonshrink) {
                this.removeSidebar();   this.removeCurrentPane();
                this.changeSideBar();   this.setSideBar(this.pestanaactual);

                if (this.pestanaactual == 1) {
                    this.setProbabilidadPane();
                } else if (this.pestanaactual == 2) {
                    this.setTrignometriaPane();
                } else if (this.pestanaactual == 3) {
                    this.setCalculoPane();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void generate(String formula, String path) throws IOException {
        TeXFormula tf = new TeXFormula(formula);
        TeXIcon ti = tf.createTeXIcon(TeXConstants.STYLE_DISPLAY, 40);
        BufferedImage bimg = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D g2d = bimg.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,ti.getIconWidth(),ti.getIconHeight());
        JLabel jl = new JLabel();
        jl.setForeground(new Color(0, 0, 0));
        ti.paintIcon(jl, g2d, 0, 0);

        File out = new File(path);
        ImageIO.write(bimg, "png", out);
    }

    public void setProbabilidadPane() {
        JLabel labelVariacionCon = new JLabel("Varciación con repetición: "), labelVariacionSin = new JLabel("Varciación sin repetición: ");
        JLabel labelPermutacionCon = new JLabel("Permutación con repetición: "), labelPermutacionSin = new JLabel("Permutación sin repetición: ");
        JLabel labelCombinacionCon = new JLabel("Combinación con repetición: "), labelCombinacionSin = new JLabel("Combinación con repetición: ");

        JLabel labelVariacionConLatex = new JLabel(imageVariacionCon);
        JLabel label_n = new JLabel(image_n);
        JLabel label_m = new JLabel(image_m);
        JLabel labelVariacionConResultado = new JLabel("Resultado: ");

        labelVariacionCon.setFont(sizedFontBold);
        labelVariacionSin.setFont(sizedFontBold);
        labelPermutacionCon.setFont(sizedFontBold);
        labelPermutacionSin.setFont(sizedFontBold);
        labelCombinacionCon.setFont(sizedFontBold);
        labelVariacionConResultado.setFont(sizedFontRegular);
        field_n.setFont(sizedFontRegular);
        field_m.setFont(sizedFontRegular);
        fieldapellidomaterno.setFont(sizedFontRegular);
        fieldtelefono.setFont(sizedFontRegular);
        fielddireccion.setFont(sizedFontRegular);

        GridBagConstraints c = new GridBagConstraints();
        Insets inset = new Insets(5, 5, 5, 5);
        innerpane.setLayout(new GridBagLayout());
        c.gridy = 1;    c.insets = inset;   c.ipady = 0;
        c.ipadx = 0;    c.weightx = 0.1;    c.weighty = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        innerpane.add(labelVariacionCon, c);

        c.gridy = 2;    innerpane.add(labelVariacionConLatex, c);
        c.gridx = 1;    innerpane.add(label_n, c);    c.gridx = 2; innerpane.add(field_n, c);
        c.gridx = 3;    innerpane.add(label_m, c);    c.gridx = 4; innerpane.add(field_m, c);
        c.gridx = 5;    innerpane.add(labelVariacionConResultado, c);
        c.gridx = 0;
        c.gridy = 3;    innerpane.add(labelVariacionSin, c);
        c.gridy = 5;    innerpane.add(labelPermutacionCon, c);
        c.gridy = 7;    innerpane.add(labelPermutacionSin, c);
        c.gridy = 9;    innerpane.add(labelCombinacionCon, c);

        c = new GridBagConstraints();
        inset = new Insets(5, 5, 5, 5);
        c.gridy = 1;
        c.gridx = 0;
        c.insets = inset;   c.ipady = 0;
        c.ipadx = 0;    c.weightx = 0.1;    c.weighty = 0.1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;

        ScrollPane innerScroll = new ScrollPane();
        innerScroll.add(innerpane);
        mainpane.add(innerScroll, c);
    }

    public void setTrignometriaPane() {
    }

    public void setCalculoPane() {

    }

    public void setSideBar(int tab) {
        this.pestanaactual = tab;
        GridLayout gridLayout = new GridLayout(10, 1, 5, 10);
        sidebar.setLayout(gridLayout);
        JLabel LabelTitulo = new JLabel("OdontoClinic");
        String fontname = LabelTitulo.getFont().getName();
        LabelTitulo.setFont(new Font(fontname, Font.BOLD, 18));
        Font sizedFont = fontbold.deriveFont(14f);
        Font sizedFontRegular = fontregular.deriveFont(12f);
        if (banderasidebar) {
            splitPane.setDividerLocation(50);
            LabelTitulo = new JLabel(imagetooth);
            LabelTitulo.setHorizontalAlignment(JLabel.CENTER);
            sidebar.add(LabelTitulo);
            TabProbabilidad = new JButton(imageclientes);
            TabTrigonometria = new JButton(imagecitas);
            TabCalculo = new JButton(imagetrabajadores);
        } else {
            splitPane.setDividerLocation(195);
            LabelTitulo = new JLabel(imagebrand);
            LabelTitulo.setHorizontalAlignment(JLabel.CENTER);
            sidebar.add(LabelTitulo);
            TabProbabilidad = new JButton("PROBABILIDAD", imageclientes);
            TabTrigonometria = new JButton("TRIGONOMETRIA", imagecitas);
            TabCalculo = new JButton("CALCULO", imagetrabajadores);

            TabProbabilidad.setIconTextGap(10);
            TabCalculo.setIconTextGap(55);

            TabProbabilidad.setFont(sizedFont);
            TabTrigonometria.setFont(sizedFont);
            TabCalculo.setFont(sizedFont);
        }

        TabProbabilidad.removeActionListener(this);
        TabTrigonometria.removeActionListener(this);
        TabCalculo.removeActionListener(this);

        TabProbabilidad.addActionListener(this);
        TabTrigonometria.addActionListener(this);
        TabCalculo.addActionListener(this);

        sidebar.add(TabProbabilidad);
        sidebar.add(TabTrigonometria);
        sidebar.add(TabCalculo);
        sizedFont = fontbold.deriveFont(20f);
        JLabel LabelPanel = new JLabel("NOPE");
        if (tab == 1) {
            LabelPanel = new JLabel("Probabilidad");
            LabelPanel.setFont(sizedFont);
        } if (tab == 2) {
            LabelPanel = new JLabel("Trigonometria");
            LabelPanel.setFont(sizedFont);
        } if (tab == 3) {
            LabelPanel = new JLabel("Calculo");
            LabelPanel.setFont(sizedFont);
        }
        mainpane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Insets inset = new Insets(5, 10, 5, 10);
        if (banderasidebar) {
            buttonshrink = new JButton(imageexpand);
        } else {
            buttonshrink = new JButton(imageshrink);
        }
        buttonshrink.removeActionListener(this);
        buttonshrink.addActionListener(this);
        c.weightx = 0.001;
        c.weighty = 0.001;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 30;
        c.ipadx = 30;
        c.insets = inset;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        buttonshrink.setBorder(null);
        buttonshrink.setBorderPainted(false);
        buttonshrink.setContentAreaFilled(false);
        buttonshrink.setOpaque(false);
        mainpane.add(buttonshrink, c);
        c.gridx = 1;
        c.gridy = 0;
        mainpane.add(LabelPanel, c);
    }

    private void removeSidebar() {
        sidebar.removeAll();
    }

    private void removeCurrentPane() {
        innerpane.removeAll();
        mainpane.removeAll();
    }

    private void changeSideBar() {
        this.banderasidebar = !this.banderasidebar;
    }

    private boolean valirdarString(String string) {
        return string != null && !string.equals("");
    }

    private boolean valirdarInt(String string) {
        try {
            if (string != null && !string.equals("")){
                Integer.parseInt(string);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}