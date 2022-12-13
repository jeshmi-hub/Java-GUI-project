import javax.swing.*;//importing all the necessary packages
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.KeyStroke;
import java.util.InputMismatchException;


public class Gui {
    JFrame frame;// declaring attributes for each method for gui components
    JMenuBar menubar;
    JMenu menu1, menu2, menu3;
    JMenuItem item1, item2, item3, item4, item5, item6;
    JTable table;
    DefaultTableModel chgmod;
    JScrollPane scroll;
    JLabel label1, label2, label3;
    JTextField text1, text2, text3;
    JPanel pan1, pan2, pan3, pan4, pan5;
    JCheckBox check;
    JRadioButton radiobtn1, radiobtn2;
    JButton but1, but2, but3, but4;
    int rows;
    Object[] row;



    public Gui() {


        try {
            frame = new JFrame("Phone Book");
            frame.setSize(955, 515);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setResizable(true);
            /****JPanel 1****/ //This panel consists menu bar and the table
            //creating table
            pan1 = new JPanel();
            chgmod = new DefaultTableModel(55, 0);//declaring the rows for the table
            Object[] column = {"Forename", "Surname", "Phone", "Private"};//column heading of the table
            row = new Object[4];
            chgmod.setColumnIdentifiers(column);
            table = new JTable(chgmod);
            scroll = new JScrollPane(table);

            pan1.add(scroll);//adding a scroll bar for the table
            pan1.setBorder(new TitledBorder("Name:"));
            pan1.setLayout(new FlowLayout());


            //setting a menu bar
            menubar = new JMenuBar();
            menu1 = new JMenu("File");
            item1 = new JMenuItem("Exit");
            menubar.add(menu1);
            menu1.add(item1);
            menu1.setMnemonic(KeyEvent.VK_C);
            menu1.setToolTipText("ALT + C");//hovers when you put your mouse pointer on the specific menu
            item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));//shortcut key to quit the program i.e. CTRL + C
            item1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }

            });
            menu2 = new JMenu("Edit");
            item2 = new JMenuItem("Clear");
            menu2.setMnemonic(KeyEvent.VK_F);
            menu2.setToolTipText("ALT + F");
            menubar.add(menu2);
            menu2.add(item2);
            item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));//CTRL + X
            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Clear();

                }
            });
            item3 = new JMenuItem("Update");
            menubar.add(menu2);
            menu2.add(item3);
            menu2.addSeparator();
            item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));//CTRL + U
            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Update();

                }
            });

            item4 = new JMenuItem("Add");
            menubar.add(menu2);
            menu2.add(item4);
            item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));//CTRL + A
            item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Add();
                }
            });
            item5 = new JMenuItem("Remove");
            menubar.add(menu2);
            menu2.add(item5);
            item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));//CTRL + R
            item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Remove();
                }
            });

            menu3 = new JMenu("Help");
            item6 = new JMenuItem("About");
            menubar.add(menu3);
            menu3.add(item6);
            menu3.setMnemonic(KeyEvent.VK_H);
            menu3.setToolTipText("ALT + H");
            item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));//CTRL + J
            item6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Coming soon", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            /*****JPanel 2****/ //This panel consists of the registration fields
            pan2 = new JPanel();

            label1 = new JLabel("First Name:");
            pan2.add(label1);
            text1 = new JTextField(20);
            pan2.add(text1);

            label2 = new JLabel("Second Name:");
            pan2.add(label2);
            text2 = new JTextField(20);
            pan2.add(text2);

            label3 = new JLabel("Phone:");
            pan2.add(label3);
            text3 = new JTextField(20);
            pan2.add(text3);

            check = new JCheckBox("Private");
            pan2.add(check);


            pan2.setBorder(new TitledBorder("Info:"));
            pan2.setLayout(new GridLayout(4, 1));

            /*****JPanel 3*****/ //This panel consists of the JRadio Button part
            pan3 = new JPanel();
            ButtonGroup btn1 = new ButtonGroup();

            radiobtn1 = new JRadioButton("Forename, Surname");
            btn1.add(radiobtn1);
            pan3.add(radiobtn1);


            radiobtn2 = new JRadioButton("Surname, Forename");
            btn1.add(radiobtn2);
            pan3.add(radiobtn2);

            radiobtn1.setSelected(true);
            radiobtn1.setEnabled(false);
            radiobtn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    table.moveColumn(0, 1);
                    radiobtn2.setEnabled(false);
                    radiobtn1.setEnabled(true);
                }
            });
            radiobtn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    table.moveColumn(0, 1);
                    radiobtn2.setEnabled(true);
                    radiobtn1.setEnabled(false);
                }
            });

            pan3.setBorder(new TitledBorder("File as:"));
            pan3.setLayout(new GridLayout(2, 1));

            /***JPanel 4*****/ //This panel consists of all the functional Jbuttons
            pan4 = new JPanel();

            but1 = new JButton("Clear");
            pan4.add(but1);
            but1.setToolTipText("It clears the field");
            but1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Clear();
                }
            });

            but2 = new JButton("Update");
            pan4.add(but2);
            but2.setToolTipText("Updates the table");
            but2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Update();
                }
            });

            but3 = new JButton("Add");
            pan4.add(but3);
            but3.setToolTipText("Adds the entered values in the table");
            but3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Add();
                }
            });

            but4 = new JButton("Remove");
            pan4.add(but4);
            but4.setToolTipText("Removes the selected row of the table.");
            but4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Remove();
                }
            });


            pan4.setLayout(new GridLayout(2, 2));

            /*****JPanel 5*****/ //This panel decides the placement of the Jbutton,JRadio button and Jlabel
            pan5 = new JPanel();
            pan5.add(pan2);
            pan5.add(pan3);
            pan5.add(pan4);

            pan5.setLayout(new GridLayout(3, 1));
            frame.add(pan5);// adds panel2,panel3,and panel4

            //Giving direction to the different panels
            frame.add(menubar, BorderLayout.NORTH);
            frame.add(pan5, BorderLayout.EAST);
            frame.add(pan1, BorderLayout.WEST);

            frame.setJMenuBar(menubar);//menu bar gets stick on the top of the frame
            frame.setVisible(true);//sets the visibility of frame to the user
        } catch (NullPointerException ne) {
            System.out.println("Null pointer exception" + ne.getMessage());
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Array index out of bound exception" + ae.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //Method for add function
    public void Add() {
        try {
            //declaring the Jlabel fields and creating objects to get the text entered in the Jlabel text field
            String firstName = text1.getText().trim();//trim removes any unnecessary spaces in the fields
            String secondName = text2.getText().trim();
            String phoneNum = text3.getText().trim();
            int error = 0;
            //use of nested if
            if (!(firstName.isEmpty() || secondName.isEmpty() || phoneNum.isEmpty())) {//condition that checks if the fields are empty or not
                if (firstName.matches("^[a-zA-Z]*$")) {//^ checks the entered letter is correct ,matches any lower or uppercase letters
                    row[0] = text1.getText();
                } else {
                    JOptionPane.showMessageDialog(null, "Error enter a valid name.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    error = 1;
                }
                if (secondName.matches("^[a-zA-Z]*$")) {
                    row[1] = text2.getText();
                } else {
                    JOptionPane.showMessageDialog(null, "Error enter a valid name.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    error = 1;
                }
                if (phoneNum.matches("^[\\d]{10}")) {//makes sure that the entered phone number is of 10 digits
                    row[2] = text3.getText();
                } else {
                    JOptionPane.showMessageDialog(null, "Error you must enter 10 numbers.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    error = 1;
                }
                if (check.isSelected()) {
                    row[3] = check.getText();
                } else {
                    row[3] = null;
                }
                if (error == 0) {
                    if(radiobtn1.isEnabled()){
                        // firstname, surname
                        table.setValueAt(row[0], rows, 0);
                        table.setValueAt(row[1], rows, 1);
                    } else {
                        // surname, firstname
                        table.setValueAt(row[0], rows, 1);
                        table.setValueAt(row[1], rows, 0);
                    }

                    table.setValueAt(row[2], rows, 2);
                    table.setValueAt(row[3], rows, 3);
                    Registration res = new Registration();
                    res.insert(row[0].toString(),row[1].toString(), row[2].toString(),row[3].toString());
                    rows++;
                } else {
                    JOptionPane.showMessageDialog(null, "You are not Registered", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "All the fields must be filled", "WARNING", JOptionPane.WARNING_MESSAGE);
            }//if any of the fields are empty

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Table cannot take anymore data it is full", "INFO", JOptionPane.INFORMATION_MESSAGE);
        }//if the input index of the table is negative or more than the index of the table
        catch (InputMismatchException ie) {
            JOptionPane.showMessageDialog(null, "Please enter information do not leave it empty", "WARNING", JOptionPane.WARNING_MESSAGE);
        }//catches error according to the field inputs
        catch (Exception ep) {
            JOptionPane.showMessageDialog(null, "You have an error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }//pops up if there are any error other than the above mentioned errors
    }

    //Method for remove function
    public void Remove() {
        try {
            if (table.getValueAt(table.getSelectedRow(), 0).toString() != null) {
                if (table.getSelectedRow() != -1 && rows != 0) {
                    chgmod.removeRow(table.getSelectedRow());//inorder to make the remove button work the rows must get selected
                    rows--;
                    Object[] rose = {"", "", "", ""};//after remove button is pressed the empty rows are displayed
                    chgmod.addRow(rose);
                }
            }
        } catch (NullPointerException eg) {
            JOptionPane.showMessageDialog(null, "I am empty", "INFO", JOptionPane.INFORMATION_MESSAGE);
        }//if the table has no values this error pops up
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something is fishy", "ERROR", JOptionPane.ERROR_MESSAGE);
        }//if the rows of table are not selected this error pops up
    }

    //Method for clear function
    public void Clear() {//clears the JLabel text fields
        text1.setText("");
        text2.setText("");
        text3.setText("");
        check.setSelected(false);
    }

    //Method for update function
    public void Update() {//updates the table if user wants any changes in the entered value
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                text1.setText(chgmod.getValueAt(selectedRow, 0).toString());
                text2.setText(chgmod.getValueAt(selectedRow, 1).toString());
                text3.setText(chgmod.getValueAt(selectedRow, 2).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "You must select the row first");
                    return;
                }
                try {
                    String firstName = text1.getText().trim();//trim removes any unnecessary spaces in the fields
                    String secondName = text2.getText().trim();
                    String phoneNum = text3.getText().trim();
                    int error =0;
                    //use of nested if
                    if (!(firstName.isEmpty() || secondName.isEmpty() || phoneNum.isEmpty())) {//condition that checks if the fields are empty or not
                        if (firstName.matches("^[a-zA-Z]*$")) {//^ checks the entered letter is correct ,matches any lower or uppercase letters
                            row[0] = text1.getText();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error enter a valid name.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            error = 1;
                        }
                        if (secondName.matches("^[a-zA-Z]*$")) {
                            row[1] = text2.getText();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error enter a valid name.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            error = 1;
                        }
                        if (phoneNum.matches("^[\\d]{10}")) {//makes sure that the entered phone number is of 10 digits
                            row[2] = text3.getText();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error you must enter 10 numbers.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            error = 1;
                        }
                        if (check.isSelected()) {
                            row[3] = check.getText();
                        } else {
                            row[3] = null;
                        }
                        if (error == 0) {
                            chgmod.setValueAt(firstName, selectedRow, 0);
                            chgmod.setValueAt(secondName, selectedRow, 1);
                            chgmod.setValueAt(phoneNum, selectedRow, 2);
                            check.setSelected(false);
                            but1.doClick();
                            radiobtn1.setEnabled(true);
                            radiobtn2.setEnabled(true); //If all the criteria is met the values gets filled in the table
                        } else {
                            JOptionPane.showMessageDialog(null, "Updated Successfully", "INFO", JOptionPane.INFORMATION_MESSAGE);
                            but1.doClick();
                        }
                    }
                } catch (Exception ep) {
                    JOptionPane.showMessageDialog(null, "You have an error", "ERROR", JOptionPane.ERROR_MESSAGE);
                }//pops up if there are any error other than the above mention

            }
        });

    }

    public static void main(String[] args) {

        Gui obj = new Gui();
    }

}