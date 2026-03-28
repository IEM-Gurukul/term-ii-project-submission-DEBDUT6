//StudentManager 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
//Main class declaration (GUI extends JFrame)
public class StudentManager extends JFrame {
     //Declare UI components and data storage
    JTextField idField, nameField, courseField;
    JButton addBtn;
    JTable table;
    DefaultTableModel model;
    ArrayList<String[]> students = new ArrayList<>();
     //Constructor - Initialize GUI
    public StudentManager() {
        setTitle("Student Manager");
        setSize(500,400);
        setLayout(null);
         //ID Label and Field
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(20,20,100,25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(100,20,150,25);
        add(idField);
         //Name Label and Field
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20,60,100,25);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(100,60,150,25);
        add(nameField);
         //Course Label and Field
        JLabel courseLabel = new JLabel("Course");
        courseLabel.setBounds(20,100,100,25);
        add(courseLabel);
        courseField = new JTextField();
        courseField.setBounds(100,100,150,25);
        add(courseField);
         //Add Button
        addBtn = new JButton("Add");
        addBtn.setBounds(300,20,100,30);
        add(addBtn);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20,150,440,200);
        add(pane);
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
    }
    public static void main(String[] args) {
        new StudentManager().setVisible(true);
    }
}
