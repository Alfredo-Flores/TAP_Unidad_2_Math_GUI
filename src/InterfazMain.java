import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;

public class InterfazMain extends JFrame implements ActionListener, KeyListener {
    JSplitPane splitPane = new JSplitPane();    Panel sidebar = new Panel(), mainpane = new Panel();
    JPanel innerpane = new JPanel();
    Image imagetoothicon = new ImageIcon("src/assets/logo.png").getImage();
    File montserratregular = new File("src/assets/Montserrat-Regular.ttf");
    File montserratbold = new File("src/assets/Montserrat-Bold.ttf");
    Font fontregular = Font.createFont(Font.TRUETYPE_FONT, montserratregular);
    Font fontbold = Font.createFont(Font.TRUETYPE_FONT, montserratbold);
    Font sizedFontBold = fontbold.deriveFont(14f);
    Font sizedFontRegular = fontregular.deriveFont(12f);
    ImageIcon imagetooth = new ImageIcon(new ImageIcon("src/assets/logo.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon imagebrand = new ImageIcon(new ImageIcon("src/assets/brand.png").getImage().getScaledInstance(120, 40, Image.SCALE_SMOOTH));
    ImageIcon imageclientes = new ImageIcon(new ImageIcon("src/assets/table-solid.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    ImageIcon imagecitas = new ImageIcon(new ImageIcon("src/assets/shapes-solid.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    ImageIcon imagetrabajadores = new ImageIcon(new ImageIcon("src/assets/square-root-alt-solid.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    ImageIcon imageshrink = new ImageIcon(new ImageIcon("src/assets/arrow-left-solid.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    ImageIcon imageexpand = new ImageIcon(new ImageIcon("src/assets/arrow-right-solid.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    ImageIcon imageVariacionCon = new ImageIcon(new ImageIcon("src/assets/VariacionCon.png").getImage().getScaledInstance(165, 30, Image.SCALE_SMOOTH));
    ImageIcon imageVariacionSin = new ImageIcon(new ImageIcon("src/assets/VariacionSin.png").getImage().getScaledInstance(165, 50, Image.SCALE_SMOOTH));
    ImageIcon imagePermutacionSin = new ImageIcon(new ImageIcon("src/assets/PermutacionSin.png").getImage().getScaledInstance(120, 30, Image.SCALE_SMOOTH));
    ImageIcon imageCombinacionCon = new ImageIcon(new ImageIcon("src/assets/CombinacionesCon.png").getImage().getScaledInstance(165, 50, Image.SCALE_SMOOTH));
    ImageIcon imageCombinacionSin = new ImageIcon(new ImageIcon("src/assets/CombinacionesSin.png").getImage().getScaledInstance(165, 50, Image.SCALE_SMOOTH));
    ImageIcon imageDerivadaEjemplo = new ImageIcon(new ImageIcon("src/assets/DerivadaEjemplo.png").getImage().getScaledInstance(165, 40, Image.SCALE_SMOOTH));
    ImageIcon image_a = new ImageIcon(new ImageIcon("src/assets/a.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_b = new ImageIcon(new ImageIcon("src/assets/b.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_c = new ImageIcon(new ImageIcon("src/assets/c.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_d = new ImageIcon(new ImageIcon("src/assets/d.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_e = new ImageIcon(new ImageIcon("src/assets/e.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_f = new ImageIcon(new ImageIcon("src/assets/f.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_g = new ImageIcon(new ImageIcon("src/assets/g.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_h = new ImageIcon(new ImageIcon("src/assets/h.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_i = new ImageIcon(new ImageIcon("src/assets/i.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_j = new ImageIcon(new ImageIcon("src/assets/j.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_k = new ImageIcon(new ImageIcon("src/assets/k.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_L = new ImageIcon(new ImageIcon("src/assets/L.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_m = new ImageIcon(new ImageIcon("src/assets/m.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    ImageIcon image_n = new ImageIcon(new ImageIcon("src/assets/n.png").getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
    JButton TabProbabilidad = new JButton("Probabilidad", imageclientes), TabTrigonometria = new JButton("Trigonometria", imagecitas);
    JButton TabCalculo = new JButton("Calculo", imagetrabajadores), buttonshrink = new JButton(imageshrink);
    JLabel labelVariacionConResultado = new JLabel("Resultado: ");
    JLabel labelVariacionConResultado2 = new JLabel("Resultado: ");
    JLabel labelPermutacionSinResultado = new JLabel("Resultado: ");
    JLabel labelCombionacionConResultado = new JLabel("Resultado: ");
    JLabel labelCombionacionSinResultado = new JLabel("Resultado: ");
    JLabel labelResultadoHipotenusa = new JLabel("Hipotenusa: ");
    JLabel labelResultadoAngulo1 = new JLabel("Angulo a: ");
    JLabel labelResultadoAngulo2 = new JLabel("Angulo b: ");
    JLabel labelResultadoAnguloEscaleno1 = new JLabel("Angulo a: ");
    JLabel labelResultadoAnguloEscaleno2 = new JLabel("Angulo b: ");
    JLabel labelResultadoAnguloEscaleno3 = new JLabel("Angulo c: ");
    JLabel labelResultadoDerivada = new JLabel("Resultado: ");
    JTextField field_n = new JTextField(), field_m = new JTextField();
    JTextField field_n2 = new JTextField(), field_m2 = new JTextField();
    JTextField field_a2 = new JTextField();
    JTextField field_cateto_adyacente = new JTextField();
    JTextField field_cateto_opuesto = new JTextField();
    JTextField field_cateto_adyacente2 = new JTextField();
    JTextField field_cateto_opuesto2 = new JTextField();
    JTextField field_hipotenusa = new JTextField();
    JTextField field_n3 = new JTextField();
    JTextField field_n4 = new JTextField(), field_m4 = new JTextField();
    JTextField field_n5 = new JTextField(), field_m5 = new JTextField();
    JTextField field_ecuacion = new JTextField(), field_valor = new JTextField();
    int pestanaactual = 1;
    boolean banderasidebar = false;

    InterfazMain() throws IOException, FontFormatException {
        super("Mi Math");  setSize(1152, 640);
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
                        "¿Estas seguro que quieres salir de la aplicación?", "Cerrar ventana",
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

    public void setProbabilidadPane() throws IOException, FontFormatException {
        JTitulo labelVariacionCon = new JTitulo("Varciación con repetición: "), labelVariacionSin = new JTitulo("Varciación sin repetición: ");
        JTitulo labelPermutacionSin = new JTitulo("Permutación sin repetición: ");
        JTitulo labelCombinacionCon = new JTitulo("Combinación con repetición: "), labelCombinacionSin = new JTitulo("Combinación sin repetición: ");

        JLabel labelVariacionConLatex = new JLabel(imageVariacionCon);
        JLabel label_n = new JLabel(image_n);
        JLabel label_m = new JLabel(image_m);

        JLabel labelVariacionSinLatex = new JLabel(imageVariacionSin);
        JLabel label_a2 = new JLabel(image_a);
        JLabel label_n2 = new JLabel(image_n);
        JLabel label_m2 = new JLabel(image_m);

        JLabel labelPermutacionSinLatex = new JLabel(imagePermutacionSin);
        JLabel label_n3 = new JLabel(image_n);

        JLabel labelCombinacionSinLatex = new JLabel(imageCombinacionSin);
        JLabel label_n4 = new JLabel(image_n);
        JLabel label_m4 = new JLabel(image_m);

        JLabel labelCombinacionConLatex = new JLabel(imageCombinacionCon);
        JLabel label_n5 = new JLabel(image_n);
        JLabel label_m5 = new JLabel(image_m);


        field_n.removeKeyListener(this);
        field_m.removeKeyListener(this);
        field_a2.removeKeyListener(this);
        field_n2.removeKeyListener(this);
        field_m2.removeKeyListener(this);
        field_n3.removeKeyListener(this);
        field_n4.removeKeyListener(this);
        field_m4.removeKeyListener(this);
        field_n5.removeKeyListener(this);
        field_m5.removeKeyListener(this);
        field_n.addKeyListener(this);
        field_m.addKeyListener(this);
        field_a2.addKeyListener(this);
        field_n2.addKeyListener(this);
        field_m2.addKeyListener(this);
        field_n3.addKeyListener(this);
        field_n4.addKeyListener(this);
        field_m4.addKeyListener(this);
        field_n5.addKeyListener(this);
        field_m5.addKeyListener(this);

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
        c.gridx = 7;    innerpane.add(labelVariacionConResultado, c);
        c.gridx = 0;

        c.gridy = 3;    innerpane.add(labelVariacionSin, c);
        c.gridy = 4;    innerpane.add(labelVariacionSinLatex, c);
        c.gridx = 1;    innerpane.add(label_a2, c);    c.gridx = 2; innerpane.add(field_a2, c);
        c.gridx = 3;    innerpane.add(label_n2, c);    c.gridx = 4; innerpane.add(field_n2, c);
        c.gridx = 5;    innerpane.add(label_m2, c);    c.gridx = 6; innerpane.add(field_m2, c);
        c.gridx = 7;    innerpane.add(labelVariacionConResultado2, c);
        c.gridx = 0;

        c.gridy = 5;    innerpane.add(labelPermutacionSin, c);
        c.gridy = 6;    innerpane.add(labelPermutacionSinLatex, c);
        c.gridx = 1;    innerpane.add(label_n3, c);    c.gridx = 2; innerpane.add(field_n3, c);
        c.gridx = 7;    innerpane.add(labelPermutacionSinResultado, c);
        c.gridx = 0;

        c.gridy = 7;    innerpane.add(labelCombinacionCon, c);
        c.gridy = 8;    innerpane.add(labelCombinacionConLatex, c);
        c.gridx = 1;    innerpane.add(label_n4, c);    c.gridx = 2; innerpane.add(field_n4, c);
        c.gridx = 3;    innerpane.add(label_m4, c);    c.gridx = 4; innerpane.add(field_m4, c);
        c.gridx = 7;    innerpane.add(labelCombionacionConResultado, c);
        c.gridx = 0;

        c.gridy = 9;    innerpane.add(labelCombinacionSin, c);
        c.gridy = 10;   innerpane.add(labelCombinacionSinLatex, c);
        c.gridx = 1;    innerpane.add(label_n5, c);    c.gridx = 2; innerpane.add(field_n5, c);
        c.gridx = 3;    innerpane.add(label_m5, c);    c.gridx = 4; innerpane.add(field_m5, c);
        c.gridx = 7;    innerpane.add(labelCombionacionSinResultado, c);
        c.gridx = 0;

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

    public void setTrignometriaPane() throws IOException, FontFormatException {
        JTitulo labelTrianguloRectangulo = new JTitulo("Triangulo Rectangulo: ");
        JLabel labelCatetoAdyacente = new JLabel("Cateto Adyacente: ");
        JLabel labelCatetoOpuesto = new JLabel("Cateto Opuesto: ");
        JLabel labelCatetoAdyacente2 = new JLabel("Cateto Adyacente: ");
        JLabel labelCatetoOpuesto2 = new JLabel("Cateto Opuesto: ");
        JLabel labelHipotenusa2 = new JLabel("Hipotenusa: ");

        JTitulo labelTrianguloEscaleno = new JTitulo("Triangulo Escaleno: ");

        JTriangle triangulofactory = new JTriangle();
        JPanel triangulo = triangulofactory.getJTriangulo(100, 100);
        JPanel trianguloEscaleno = triangulofactory.getJTrianguloEscaleno(100, 70, 150);

        field_cateto_adyacente.removeKeyListener(this);
        field_cateto_opuesto.removeKeyListener(this);
        field_cateto_adyacente.addKeyListener(this);
        field_cateto_opuesto.addKeyListener(this);

        GridBagConstraints c = new GridBagConstraints();
        Insets inset = new Insets(5, 5, 5, 5);
        innerpane.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.insets = inset;
        c.ipady = 0;
        c.ipadx = 0;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;

        c.gridwidth = 8;
        innerpane.add(labelTrianguloRectangulo, c);
        c.gridy = 2;
        innerpane.add(triangulo, c);
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 3;    innerpane.add(labelCatetoAdyacente, c);         c.gridx = 2; innerpane.add(field_cateto_adyacente, c);
        c.gridx = 3;    innerpane.add(labelCatetoOpuesto, c);           c.gridx = 4; innerpane.add(field_cateto_opuesto, c);
        c.gridx = 5;    innerpane.add(labelResultadoHipotenusa, c);       c.gridx = 6; innerpane.add(labelResultadoAngulo1, c);
        c.gridx = 7;    innerpane.add(labelResultadoAngulo2, c);
        c.gridx = 8;    innerpane.add(new JLabel("Angulo c: 90°"), c);
        c.gridx = 0;

        c.gridwidth = 8;
        c.gridy = 4;    innerpane.add(labelTrianguloEscaleno, c);
        c.gridy = 5;
        innerpane.add(trianguloEscaleno, c);

        field_cateto_adyacente2.removeKeyListener(this);
        field_cateto_opuesto2.removeKeyListener(this);
        field_hipotenusa.removeKeyListener(this);
        field_cateto_adyacente2.addKeyListener(this);
        field_cateto_opuesto2.addKeyListener(this);
        field_hipotenusa.addKeyListener(this);

        c.gridwidth = 1;
        c.gridy = 6;    innerpane.add(labelCatetoAdyacente2, c);    c.gridx = 2; innerpane.add(field_cateto_adyacente2, c);
        c.gridx = 3;    innerpane.add(labelCatetoOpuesto2, c);      c.gridx = 4; innerpane.add(field_cateto_opuesto2, c);
        c.gridx = 5;    innerpane.add(labelHipotenusa2, c);         c.gridx = 6; innerpane.add(field_hipotenusa, c);
        c.gridx = 7;    innerpane.add(labelResultadoAnguloEscaleno1, c);
        c.gridx = 8;    innerpane.add(labelResultadoAnguloEscaleno2, c);
        c.gridx = 9;    innerpane.add(labelResultadoAnguloEscaleno3, c);

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

    public void setCalculoPane() throws IOException, FontFormatException {
        JTitulo labelDerivada = new JTitulo("Derivada polinomial: ");
        JLabel labelDerivadaEjemplo = new JLabel("Ejemplo de formato: ");
        JLabel labelDerivadaImagen = new JLabel(imageDerivadaEjemplo);
        JLabel labelDerivadaTexto = new JLabel("Formato: 3x^3+x^2+x");
        JLabel labelEcuacion = new JLabel("Ecuación: ");
        JLabel labelValor = new JLabel("Valor a evaluar: ");

        field_ecuacion.removeKeyListener(this);
        field_valor.removeKeyListener(this);
        field_ecuacion.addKeyListener(this);
        field_valor.addKeyListener(this);


        GridBagConstraints c = new GridBagConstraints();
        Insets inset = new Insets(5, 5, 5, 5);
        innerpane.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.insets = inset;
        c.ipady = 0;
        c.ipadx = 0;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        innerpane.add(labelDerivada, c);
        c.gridy = 2;
        innerpane.add(labelDerivadaEjemplo, c);
        c.gridy = 3; innerpane.add(labelDerivadaImagen, c); c.gridx = 1; innerpane.add(labelDerivadaTexto, c); c.gridx = 0;
        c.gridy = 4; innerpane.add(labelEcuacion, c); c.gridx = 1; innerpane.add(field_ecuacion, c);
        c.gridx = 2; innerpane.add(labelValor, c); c.gridx = 3; innerpane.add(field_valor, c);
        c.gridx = 4; innerpane.add(labelResultadoDerivada, c);


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

    public void setSideBar(int tab) {
        this.pestanaactual = tab;
        GridLayout gridLayout = new GridLayout(10, 1, 5, 10);
        sidebar.setLayout(gridLayout);
        JLabel LabelTitulo = new JLabel("Mi Math");
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

    private void calcularVariacionCon(int n, int m) {
        int res = Operadores.pow(n,m);

        labelVariacionConResultado.setText("Resultado: " + res);
    }

    private void calcularVariacionSin(int a, int n, int m) {

        int factorial_numerador = Operadores.factorial(a);
        int factorial_demominador = Operadores.factorial((n-m));

        double res = (double) factorial_numerador / factorial_demominador;

        labelVariacionConResultado2.setText("Resultado: " + res);
    }

    private void calcularPermutacionSin(int n) {
        labelPermutacionSinResultado.setText("Resultado: " + Operadores.factorial(n));
    }

    private void calcularCombinacionCon(int n, int m) {
        int factorial_numerador = (m + n + 1);
        int factorial_demominador = Operadores.factorial(m) *  Operadores.factorial(n - 1) ;

        double res = (double) factorial_numerador / factorial_demominador;

        labelCombionacionConResultado.setText("Resultado: " + res);
    }

    private void calcularCombinacionSin(int n, int m) {
        int factorial_numerador = Operadores.factorial(n);
        int factorial_demominador = Operadores.factorial(m) *  Operadores.factorial(n - m) ;

        double res = (double) factorial_numerador / factorial_demominador;

        labelCombionacionSinResultado.setText("Resultado: " + res);
    }

    private void calcularTrianguloRectangulo(int a, int b) {
        double hipotenusa = Operadores.raizCuadrada(Operadores.pow(a,2) + Operadores.pow(b,2));

        double anguloa = Trigonometria.Grados(Trigonometria.asin(a / hipotenusa));
        double angulob = Trigonometria.Grados(Trigonometria.asin(b / hipotenusa));

        DecimalFormat df = new DecimalFormat("#.00");
        hipotenusa = Double.parseDouble(df.format(hipotenusa));
        anguloa = Double.parseDouble(df.format(anguloa));
        angulob = Double.parseDouble(df.format(angulob));

        labelResultadoHipotenusa.setText("Hipotenusa: " + hipotenusa);
        labelResultadoAngulo1.setText("Angulo a: " + anguloa);
        labelResultadoAngulo2.setText("Angulo b: " + angulob);
    }

    private void calcularTrianguloEscaleno(int a, int b, int c) {
        double anguloa = Trigonometria.Grados(Trigonometria.acos((double) (Operadores.pow(a, 2) - Operadores.pow(b, 2) - Operadores.pow(c, 2))/(-2 * b * c)));
        double angulob = Trigonometria.Grados(Trigonometria.acos((double) (Operadores.pow(b, 2) - Operadores.pow(a, 2) - Operadores.pow(c, 2))/(-2 * a * c)));
        double anguloc = Trigonometria.Grados(Trigonometria.acos((double) (Operadores.pow(c, 2) - Operadores.pow(b, 2) - Operadores.pow(a, 2))/(-2 * b * a)));

        DecimalFormat df = new DecimalFormat("#.00");
        anguloa = Double.parseDouble(df.format(anguloa));
        angulob = Double.parseDouble(df.format(angulob));
        anguloc = Double.parseDouble(df.format(anguloc));

        labelResultadoAnguloEscaleno1.setText("Angulo a: " + anguloa);
        labelResultadoAnguloEscaleno2.setText("Angulo b: " + angulob);
        labelResultadoAnguloEscaleno3.setText("Angulo c: " + anguloc);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        Object Objecto = keyEvent.getSource();

        if (Objecto == field_n || Objecto == field_m) {
            String n = field_n.getText();
            String m = field_m.getText();

            if (!valirdarInt(n) || !valirdarInt(m)) {
                labelVariacionConResultado.setText("Resultado: ");
                return;
            }

            calcularVariacionCon(Integer.parseInt(field_n.getText()), Integer.parseInt(field_m.getText()));
        } if (Objecto == field_a2 || Objecto == field_n2 || Objecto == field_m2) {
            String a = field_a2.getText();
            String n = field_n2.getText();
            String m = field_m2.getText();

            if (!valirdarInt(a) || !valirdarInt(n) || !valirdarInt(m)) {
                labelVariacionConResultado2.setText("Resultado: ");
                return;
            }

            calcularVariacionSin(Integer.parseInt(field_a2.getText()), Integer.parseInt(field_n2.getText()), Integer.parseInt(field_m2.getText()));
        } if (Objecto == field_n3) {
            String n = field_n3.getText();

            if (!valirdarInt(n)) {
                labelPermutacionSinResultado.setText("Resultado: ");
                return;
            }

            calcularPermutacionSin(Integer.parseInt(n));
        } if (Objecto == field_n4 || Objecto == field_m4) {
            String n = field_n4.getText();
            String m = field_m4.getText();

            if (!valirdarInt(n) || !valirdarInt(m)) {
                labelCombionacionConResultado.setText("Resultado: ");
                return;
            }

            calcularCombinacionCon(Integer.parseInt(field_n4.getText()), Integer.parseInt(field_m4.getText()));
        } if (Objecto == field_n5 || Objecto == field_m5) {
            String n = field_n5.getText();
            String m = field_m5.getText();

            if (!valirdarInt(n) || !valirdarInt(m)) {
                labelCombionacionSinResultado.setText("Resultado: ");
                return;
            }

            calcularCombinacionSin(Integer.parseInt(field_n5.getText()), Integer.parseInt(field_m5.getText()));
        }if (Objecto == field_cateto_adyacente || Objecto == field_cateto_opuesto) {
            String n = field_cateto_adyacente.getText();
            String m = field_cateto_opuesto.getText();

            if (!valirdarInt(n) || !valirdarInt(m)) {
                labelResultadoHipotenusa.setText("Hipotenusa: ");
                labelResultadoAngulo1.setText("Angulo a: ");
                labelResultadoAngulo2.setText("Angulo b: ");
                return;
            }

            calcularTrianguloRectangulo(Integer.parseInt(field_cateto_adyacente.getText()), Integer.parseInt(field_cateto_opuesto.getText()));
        } if (Objecto == field_cateto_adyacente2 || Objecto == field_cateto_opuesto2 || Objecto == field_hipotenusa) {
            String a = field_cateto_adyacente2.getText();
            String b = field_cateto_opuesto2.getText();
            String c = field_hipotenusa.getText();

            if (!valirdarInt(a) || !valirdarInt(b) || !valirdarInt(c)) {
                labelResultadoAnguloEscaleno1.setText("Angulo a: ");
                labelResultadoAnguloEscaleno2.setText("Angulo b: ");
                labelResultadoAnguloEscaleno3.setText("Angulo c: ");
                return;
            }

            calcularTrianguloEscaleno(Integer.parseInt(field_cateto_adyacente2.getText()), Integer.parseInt(field_cateto_opuesto2.getText()), Integer.parseInt(field_hipotenusa.getText()));
        }

        if (Objecto == field_ecuacion || Objecto == field_valor) {
            String ecuacion = field_ecuacion.getText();
            String valor = field_valor.getText();

            if (!valirdarInt(valor)) {
                labelResultadoDerivada.setText("Resultado: ");
                return;
            }

            try {
                long res = Derivatives.derivativeVal(ecuacion, Integer.parseInt(valor));
                labelResultadoDerivada.setText("Resultado: " +  res);
            } catch (Exception e) {
                labelResultadoDerivada.setText("Resultado: ");
            }
        }


        repaint();
    }
}