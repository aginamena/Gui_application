

/**
 * The GUI from the notes (p.15 Chapter 11 Slides)
 * 
 * @author Lynn Marshall
 * @version Skeleton: November 17, 2012
 * 
 * @author Agina Oghenemena Benaiah
 * @version April 5th, 2019
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class NotesGui implements ActionListener, ChangeListener,ListSelectionListener
, ItemListener
{
    private Container contentPane;
    private JToggleButton toggleButton;
    private JTextField textField;
    private JSlider slider;
    private JSpinner spinner;
    private JList<String> list;
    private JComboBox comboBox;
    public NotesGui() {
        // JFrame and contentPane
        JMenuBar menubar = new JMenuBar();
        JFrame frame = new JFrame("Swing Component Demo");
        frame.setJMenuBar(menubar);
        JMenu menu = new JMenu("Quit");
        menubar.add(menu);
        JMenuItem close= new JMenuItem("Close");
        
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(); // to save typing
        close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, SHORTCUT_MASK));
        
        close.addActionListener(this);
        menu.add(close);
        contentPane = frame.getContentPane();

        // set the layout of the contentPane
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));

        // add all the GUI components
        addComponents_part1();
        addComponents_part2();
        addComponets_part3();
        addComponents_part4();
  
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    /** 
     * This action listener is called when the user clicks / enters
     * information using the GUI. 
     * 
     * @param e stores the event
     */
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();
        if(o instanceof JButton){
            //instaceof checks if the dynamic type of o is a button object of
            //any subclass of button
            System.out.println("JButton clicked.");
        }
        else if(o instanceof JToggleButton && o ==toggleButton){
            System.out.println("JToggleButton clicked.");
        }
        else if(o instanceof JCheckBox ){
            System.out.println("JCheckBox clicked.");
        }
        else if(o instanceof JRadioButton){
            System.out.println("JRadioButton clicked.");
        }
        else if(o instanceof JTextField){
            //we've to get the text entered
            String s = textField.getText();
            System.out.println("Text '"+s+ "' entered in JTextArea.");
        }
        else if(o instanceof JMenuItem){
            System.exit(0);
        }

    }
    
    /**
     * This state changed is called when the user moves the slider or rolls 
     * the spinner 
     * 
     * @param e stores the event
     */
    public void stateChanged(ChangeEvent e){
        Object o = e.getSource();
        if(o instanceof JSlider && o == slider){
            JSlider s = (JSlider)o;
            if(!s.getValueIsAdjusting()){
                System.out.println("JSlider moved to "+s.getValue());
            }
            
             
        }else if( o instanceof JSpinner && o == spinner){
            JSpinner p = (JSpinner)o;
            System.out.println("JSpinner rolled to "+p.getValue());
        }
        
    }
    
    /**
     * This value changed is called when the user selects an item
     * 
     * @param e stores the event
     */
    public void valueChanged(ListSelectionEvent e){
        Object ob = e.getSource();
        JList l = (JList)ob;
        if(l == list && !l.getValueIsAdjusting()){
            System.out.println("You selected "+l.getSelectedValue() );
        }
        
    }
    
    /**
     * The item state changed is called when the user selects an item
     * in a combo box
     * 
     * @param e stores the event
     */
    public void itemStateChanged(ItemEvent evt){
         Object ob = evt.getSource();
        JComboBox l = (JComboBox)ob;

        if(evt.getStateChange() == ItemEvent.SELECTED){
            System.out.println("You selected "+l.getSelectedItem() );
        }
        
    }
    
    /**
     * creating part1 of gui
     */
    public void addComponents_part1(){
        JPanel holdPart1 = new JPanel();
        holdPart1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"Buttons"));

        //part 1 of 1 begins
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(1,3,19,0));
        JPanel panel = new JPanel(); // creating a jpanel to hold the
        //togglebutton and the button
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JButton button1 = new JButton("A JButton");
        //add a listener
        button1.addActionListener(this);
        toggleButton = new JToggleButton("A JToggleButton");
        //add a listener
        toggleButton.addActionListener(this);
        button1.setBorder( BorderFactory.createLoweredBevelBorder());
        toggleButton.setBorder( BorderFactory.createLoweredBevelBorder());
        panel.add(button1);
        //adding a space
        panel.add(Box.createRigidArea(new Dimension(0,2)));
        panel.add(toggleButton);       
        //adding the button into the grid
        grid.add(panel);

        //part 2 of 1
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createLoweredBevelBorder());
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(Box.createRigidArea(new Dimension(5,0)));
        JCheckBox checkBox = new JCheckBox("A JCheckBox");
        checkBox.addActionListener(this);
        JCheckBox anotherCheckBox = new JCheckBox("Another JCheckBox");
        anotherCheckBox.addActionListener(this);
        panel2.add(checkBox);panel2.add(anotherCheckBox);
        //adding panel2 to the grid
        grid.add(panel2);

        //part 3 of 1
        JPanel panel3 = new JPanel();
        //adding a title to panel3 called A ButtonGroup
        panel3.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"A ButtonGroup"));
        panel3.add(Box.createRigidArea(new Dimension(10,0)));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        JRadioButton radiobutton = new JRadioButton("A JRadioButton");
        radiobutton.addActionListener(this);
        JRadioButton anotherRadioButton = new JRadioButton("Another JRadioButton");
        anotherRadioButton.addActionListener(this);
        panel3.add(radiobutton);panel3.add(anotherRadioButton);
        //adding panel3 to the grid
        grid.add(panel3);
        //adding all 3 parts of part one into holdpart1
        holdPart1.add(grid);

        //adding everything about part1 into the contentpane
        contentPane.add(holdPart1);
    }

    /**
     * creating part2 of gui
     */
    public void addComponents_part2(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(29,0));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"Labels and Text Entry"));
        JLabel label = new JLabel("A JLabel with a text label.");
        textField = new JTextField("You can type text in an editable JTextField");
        //adding a listener to the text field
        textField.addActionListener(this);
        panel.add(label,BorderLayout.WEST);
        //panel.add(Box.createRigidArea(new Dimension(90,0)));
        panel.add(textField,BorderLayout.CENTER);
        contentPane.add(panel);
    }

    /**
     * creating part3 of gui
     */
    public void addComponets_part3(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"A JProgress Bar"));
        JProgressBar progressBar= new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setValue(75);
        panel.add(progressBar,BorderLayout.CENTER);
        contentPane.add(panel);
    }
    
    /**
     * creating part 4 of gui
     */
    public void addComponents_part4(){
        JPanel holdAll = new JPanel();
        holdAll.setLayout(new BorderLayout());
        holdAll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"Components for Select"
                +"ing"));
        //hodlall has flowlayout
        
        
        JPanel p1 = new JPanel(); //should hold row 1
        
        
        //  part 1 of 4
            //P3 is the variable to hold the spinner
           JPanel p3 = new JPanel();
        //p3.setLayout(new BorderLayout());
        slider = new JSlider(JSlider.HORIZONTAL,0,10,4);
        slider.setPreferredSize(new Dimension(290,80));
        slider.addChangeListener(this);
        slider.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"A JSlider"));
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        //p3.add(slider,BorderLayout.WEST);
        p3.add(slider);
        
        
        p1.add(p3);
        
        //part 2 of 4
        // p2 to hold the JSpinner
        JPanel p2 = new JPanel(); 
        p2.setLayout(new BorderLayout());
        p2.setPreferredSize(new Dimension(150,50));
        //p2.setLayout(new FlowLayout(FlowLayout.CENTER));
         p2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"A JSpinner"));
        spinner = new JSpinner();
        spinner.addChangeListener(this);
        spinner.setPreferredSize(new Dimension(60,18));
        p2.add(spinner,BorderLayout.WEST);

        p1.add(p2); //add part 1 and 2 into the flowlayout
   
        //add p1 to holdall
        holdAll.add(p1,BorderLayout.WEST); //part 1and 2 ends

        //creating a new flowlayout for part3 and 5
        JPanel p5 = new JPanel();
        
        
        //part 3 and 4 begins
        JPanel p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        
        p4.setPreferredSize(new Dimension(300,190));
        p4.setLayout(new BorderLayout());
        p4.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"A JList in a JScroll"
                +"Pane"));
        String[] s = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7",
                "Item 8", "Item 9", "Item 10"};
        list = new JList<String>(s);
        list.setFixedCellWidth(180);
        list.addListSelectionListener(this);
        list.setFixedCellWidth(180);
        JScrollPane scrollpane = new JScrollPane(list);
        //scrollpane.setPreferredSize(new Dimension(12,190));
        scrollpane.setBorder( BorderFactory.createLoweredBevelBorder());
        
        p4.add(scrollpane,BorderLayout.WEST);

        //creating a new borderlayout at the button
        JPanel p6 = new JPanel();
        p6.setLayout(new BorderLayout());
        
        //p6.add(p5,BorderLayout.WEST);//
         p6.add(p4,BorderLayout.WEST);
        //add the new border to the south
        
        //holdAll.add(p6,BorderLayout.SOUTH);
                //part 4 of 4
          JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),"A JComboBox"));
         comboBox = new JComboBox(s);
        comboBox.addItemListener(this);
        comboBox.setPreferredSize(new Dimension(120,40));
        pane.add(comboBox);

        
        JPanel a = new JPanel();
        a.setLayout(new BorderLayout());
        
        JPanel b = new JPanel();
        b.setLayout(new FlowLayout());
        b.add(p6);b.add(pane);
        a.add(b,BorderLayout.WEST);
        holdAll.add(a,BorderLayout.SOUTH);
        
       
        contentPane.add(holdAll);
    }
}
