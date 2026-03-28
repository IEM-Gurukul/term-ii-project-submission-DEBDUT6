//Import required packages
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
//Main class declaration
public class StudentManager extends JFrame {
    //UI components + data storage
    JTextField idField, nameField, courseField;
    JButton addBtn, updateBtn, deleteBtn;
    JTable table;
    DefaultTableModel model;
    ArrayList<String[]> students = new ArrayList<>();
    //Constructor
    public StudentManager() {
        setTitle("Student Manager");
        setSize(500,400);
        setLayout(null);
        // ID
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(20,20,100,25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(100,20,150,25);
        add(idField);
        // Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20,60,100,25);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(100,60,150,25);
        add(nameField);
        // Course
        JLabel courseLabel = new JLabel("Course");
        courseLabel.setBounds(20,100,100,25);
        add(courseLabel);
        courseField = new JTextField();
        courseField.setBounds(100,100,150,25);
        add(courseField);
        //Buttons (Controller part)
        addBtn = new JButton("Add");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        addBtn.setBounds(300,20,100,30);
        updateBtn.setBounds(300,60,100,30);
        deleteBtn.setBounds(300,100,100,30);
        add(addBtn);
        add(addBtn);
        add(updateBtn);
        add(deleteBtn);
        // Table setup
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20,150,440,200);
        add(pane);
        // CONTROLLER (Action Listeners)
        //  ADD
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String course = courseField.getText();
                if(id.isEmpty() || name.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Fill all fields");
                    return;
                }
                students.add(new String[]{id,name,course});
                model.addRow(new Object[]{id,name,course});
            }
        });
        // UPDATE
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if(row == -1) {
                    JOptionPane.showMessageDialog(null,"Select a row to update");
                    return;
                }
                model.setValueAt(idField.getText(), row, 0);
                model.setValueAt(nameField.getText(), row, 1);
                model.setValueAt(courseField.getText(), row, 2);
            }
        });
        //  DELETE
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null,"Select a row to delete");
                    return;
                }
                model.removeRow(row);
            }
        });
    }
    public static void main(String[] args) {
        new StudentManager().setVisible(true);
    }
}
