/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drafto.hmi;

import drafto.Console;
import drafto.CustomCellRenderer;
import drafto.CustomModel;
import drafto.CustomTable;
import drafto.DraftoMachine;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFileChooser;
import javax.swing.table.JTableHeader;

/**
 *
 * @author cbachich
 */
public class DraftDisplay extends javax.swing.JFrame {

  // Static Values
  private static String START  = "Start";
  private static String END    = "End";
  private static String RESUME = "Resume";
  private static String PAUSE  = "Pause";
  
  // Error Text
  private static String BAD_TABLE = 
          "There is bad data in the table. Please correct!";
  
  // Global Values
  private Console console;
  private DraftoMachine drafto;
  private Thread draftoThread;
  
  /**
   * Creates new form DraftDisplay
   */
  public DraftDisplay() {
    initComponents();
    
    // Setup the console
    console = new Console(consoleTextArea);
    
    // Create a custom table
    CustomTable pickTable = new CustomTable();
    
    // Create a custom model and allocate it to the pickTable
    pickModel = new CustomModel(console);
    pickTable.setModel(pickModel);
    pickTable.resizeColumns();
    
    // Turn on basic header sorting
    pickTable.setAutoCreateRowSorter(true);
    
    // Change the header colors
    JTableHeader header = pickTable.getTableHeader();
    header.setBackground(new Color(193,205,193));
    header.setForeground(new Color(25,25,112));
    header.setFont(new Font("Dialog", Font.BOLD, 14));
  
    // Set the custom cell renderer
    pickCellRenderer = new CustomCellRenderer();
    pickTable.setDefaultRenderer(Object.class, pickCellRenderer);
    
    // Finally set the scroll pane to include the pickTable
    pickScrollPane.setViewportView(pickTable);
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonPanel = new javax.swing.JPanel();
    startButton = new javax.swing.JButton();
    resumeButton = new javax.swing.JButton();
    pauseButton = new javax.swing.JButton();
    endButton = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    pickPanel = new javax.swing.JPanel();
    pickScrollPane = new javax.swing.JScrollPane();
    draftoScrollPane = new javax.swing.JScrollPane();
    consoleTextArea = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

    startButton.setText("Start");
    startButton.setPreferredSize(new java.awt.Dimension(80, 30));
    startButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        startDrafto(evt);
      }
    });
    buttonPanel.add(startButton);

    resumeButton.setText("Resume");
    resumeButton.setEnabled(false);
    resumeButton.setPreferredSize(new java.awt.Dimension(100, 30));
    resumeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resumeDrafto(evt);
      }
    });
    buttonPanel.add(resumeButton);

    pauseButton.setText("Pause");
    pauseButton.setEnabled(false);
    pauseButton.setPreferredSize(new java.awt.Dimension(80, 30));
    pauseButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pauseDrafto(evt);
      }
    });
    buttonPanel.add(pauseButton);

    endButton.setText("End");
    endButton.setEnabled(false);
    endButton.setPreferredSize(new java.awt.Dimension(80, 30));
    endButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        endDrafto(evt);
      }
    });
    buttonPanel.add(endButton);

    jButton1.setText("Load");
    jButton1.setPreferredSize(new java.awt.Dimension(80, 30));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LoadPicks(evt);
      }
    });
    buttonPanel.add(jButton1);

    javax.swing.GroupLayout pickPanelLayout = new javax.swing.GroupLayout(pickPanel);
    pickPanel.setLayout(pickPanelLayout);
    pickPanelLayout.setHorizontalGroup(
      pickPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 710, Short.MAX_VALUE)
      .addGroup(pickPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pickScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
    );
    pickPanelLayout.setVerticalGroup(
      pickPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 234, Short.MAX_VALUE)
      .addGroup(pickPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pickScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
    );

    consoleTextArea.setColumns(20);
    consoleTextArea.setRows(5);
    draftoScrollPane.setViewportView(consoleTextArea);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(draftoScrollPane)
          .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(pickPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pickPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(draftoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(30, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void startDrafto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDrafto
    // Check that the table contains good values. If not, inform the user and do
    // not continue
    if(!pickModel.isTableGood()) {
      console.write(BAD_TABLE);
      return;
    }
    
    // Toggle the buttons
    toggleButtons(START);
    
    // Lock the fields
    pickModel.lockCells();
    
    // Create a new pick panel
    PickPanel pickPanel = new PickPanel();
    draftoScrollPane.setViewportView(pickPanel);
    
    // Start Drafto
    drafto = new DraftoMachine(pickPanel, pickModel);
    draftoThread = new Thread(drafto);
    draftoThread.start();
  }//GEN-LAST:event_startDrafto

  private void pauseDrafto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseDrafto
    // Toggle the buttons
    toggleButtons(PAUSE);
    
    // Pause Drafto
    drafto.pause();
  }//GEN-LAST:event_pauseDrafto

  private void resumeDrafto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeDrafto
    // Toggle the buttons
    toggleButtons(RESUME);
    
    // Resume Drafto
    drafto.resume();
  }//GEN-LAST:event_resumeDrafto

  private void endDrafto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDrafto
    // Toggle the buttons
    toggleButtons(END);
    
    // Unlock the fields
    pickModel.unlockCells();
  }//GEN-LAST:event_endDrafto

  final JFileChooser fc = new JFileChooser();
  
  private void LoadPicks(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadPicks
    System.out.println("LoadPicks selected");
    int returnVal = fc.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      pickModel.loadPicks(fc.getSelectedFile());
      pickModel.fireTableDataChanged();
    }
  }//GEN-LAST:event_LoadPicks
  
  // Toggle the buttons
  private void toggleButtons(String cmd) {
    if (cmd.matches(START) || cmd.matches(RESUME)) {
      startButton.setEnabled(false);
      resumeButton.setEnabled(false);
      pauseButton.setEnabled(true);
      endButton.setEnabled(false);
    } else if (cmd.matches(PAUSE)) {
      startButton.setEnabled(false);
      resumeButton.setEnabled(true);
      pauseButton.setEnabled(false);
      endButton.setEnabled(true);
    } else if (cmd.matches(END)) {
      startButton.setEnabled(true);
      resumeButton.setEnabled(false);
      pauseButton.setEnabled(false);
      endButton.setEnabled(false);     
    }
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DraftDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DraftDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DraftDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DraftDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new DraftDisplay().setVisible(true);
      }
    });
  }
  
  // Variables decleration - can modify
  private CustomModel pickModel;
  private CustomCellRenderer pickCellRenderer;
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel buttonPanel;
  private javax.swing.JTextArea consoleTextArea;
  private javax.swing.JScrollPane draftoScrollPane;
  private javax.swing.JButton endButton;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton pauseButton;
  private javax.swing.JPanel pickPanel;
  private javax.swing.JScrollPane pickScrollPane;
  private javax.swing.JButton resumeButton;
  private javax.swing.JButton startButton;
  // End of variables declaration//GEN-END:variables
}
