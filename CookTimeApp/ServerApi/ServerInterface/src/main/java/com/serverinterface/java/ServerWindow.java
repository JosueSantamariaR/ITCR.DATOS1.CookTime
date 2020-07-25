package com.serverinterface.java;

import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class in charge of creating the Server interface.
 */
public class ServerWindow extends javax.swing.JFrame {

    /**
     * Constructor of the window.
     */
    public ServerWindow() {     
        
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnUsers = new javax.swing.JButton();
        btnRecipes = new javax.swing.JButton();
        btnEnterprises = new javax.swing.JButton();
        scrollPanelUsers = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        scrollPanelRecipes = new javax.swing.JScrollPane();
        tableRecipes = new javax.swing.JTable();
        btnAssignChef = new javax.swing.JButton();
        scrollPanelEnterprises = new javax.swing.JScrollPane();
        tableEnterprises = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome to CookTime Server");

        btnUsers.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnUsers.setText("Check Users");
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnRecipes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRecipes.setText("Check Recipes");
        btnRecipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecipesActionPerformed(evt);
            }
        });

        btnEnterprises.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnEnterprises.setText("Check Enterprises");
        btnEnterprises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterprisesActionPerformed(evt);
            }
        });

        scrollPanelUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollPanelUsers.setViewportView(null);

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Email", "Name", "LastName", "Age", "Password", "Photo", "My Menu List", "Followers", "Followed", "Chef"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableUsers.getTableHeader().setReorderingAllowed(false);
        scrollPanelUsers.setViewportView(tableUsers);
        if (tableUsers.getColumnModel().getColumnCount() > 0) {
            tableUsers.getColumnModel().getColumn(0).setResizable(false);
            tableUsers.getColumnModel().getColumn(1).setResizable(false);
            tableUsers.getColumnModel().getColumn(2).setResizable(false);
            tableUsers.getColumnModel().getColumn(3).setResizable(false);
            tableUsers.getColumnModel().getColumn(4).setResizable(false);
            tableUsers.getColumnModel().getColumn(5).setResizable(false);
            tableUsers.getColumnModel().getColumn(6).setResizable(false);
            tableUsers.getColumnModel().getColumn(7).setResizable(false);
            tableUsers.getColumnModel().getColumn(8).setResizable(false);
            tableUsers.getColumnModel().getColumn(9).setResizable(false);
            tableUsers.getColumnModel().getColumn(10).setResizable(false);
        }

        tableRecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipe", "Name", "Author", "Type", "Portions", "Duration", "Time", "Difficulty", "Diet Tag", "Photo", "Ingredients", "Steps", "Price", "Qualification", "Day", "Month", "Year", "Commentaries"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRecipes.getTableHeader().setReorderingAllowed(false);
        scrollPanelRecipes.setViewportView(tableRecipes);
        if (tableRecipes.getColumnModel().getColumnCount() > 0) {
            tableRecipes.getColumnModel().getColumn(0).setResizable(false);
            tableRecipes.getColumnModel().getColumn(1).setResizable(false);
            tableRecipes.getColumnModel().getColumn(2).setResizable(false);
            tableRecipes.getColumnModel().getColumn(3).setResizable(false);
            tableRecipes.getColumnModel().getColumn(4).setResizable(false);
            tableRecipes.getColumnModel().getColumn(5).setResizable(false);
            tableRecipes.getColumnModel().getColumn(6).setResizable(false);
            tableRecipes.getColumnModel().getColumn(7).setResizable(false);
            tableRecipes.getColumnModel().getColumn(8).setResizable(false);
            tableRecipes.getColumnModel().getColumn(9).setResizable(false);
            tableRecipes.getColumnModel().getColumn(10).setResizable(false);
            tableRecipes.getColumnModel().getColumn(11).setResizable(false);
            tableRecipes.getColumnModel().getColumn(12).setResizable(false);
            tableRecipes.getColumnModel().getColumn(13).setResizable(false);
            tableRecipes.getColumnModel().getColumn(14).setResizable(false);
            tableRecipes.getColumnModel().getColumn(15).setResizable(false);
            tableRecipes.getColumnModel().getColumn(16).setResizable(false);
            tableRecipes.getColumnModel().getColumn(17).setResizable(false);
        }

        btnAssignChef.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAssignChef.setText("Assign New Chef");
        btnAssignChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignChefActionPerformed(evt);
            }
        });

        tableEnterprises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise", "Name", "Logo", "Contact", "Schedule", "Direction", "Qualification", "Followers", "Members", "My Menu List"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEnterprises.getTableHeader().setReorderingAllowed(false);
        scrollPanelEnterprises.setViewportView(tableEnterprises);
        if (tableEnterprises.getColumnModel().getColumnCount() > 0) {
            tableEnterprises.getColumnModel().getColumn(0).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(1).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(2).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(3).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(4).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(5).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(6).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(7).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(8).setResizable(false);
            tableEnterprises.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanelUsers)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(btnUsers)
                                        .addGap(9, 9, 9)
                                        .addComponent(btnRecipes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEnterprises)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAssignChef)))
                                .addGap(0, 1126, Short.MAX_VALUE))
                            .addComponent(scrollPanelRecipes)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPanelEnterprises)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsers)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRecipes)
                        .addComponent(btnEnterprises)
                        .addComponent(btnAssignChef)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanelRecipes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanelEnterprises, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecipesActionPerformed
        
        HttpClient httpClient = new HttpClient(new OnHttpRequestComplete() {
            
            @Override
            public void onComplete(Response status) {
                
                if (status.isSuccess()) {
                    
                    JSONParser parser = new JSONParser();

                    try {
                        
                        JSONArray jsonFile = (JSONArray) parser.parse(status.getResult());
                        
                        DefaultTableModel model = (DefaultTableModel) tableRecipes.getModel();
                        
                        model.setRowCount(0);
                                                                        
                        for (int i = 0; i < jsonFile.size(); i ++) {
                                                    
                            addRowRecipe((JSONObject) jsonFile.get(i), i + 1);
                            
                        }
                        
                    } catch (Exception e) {

                        e.printStackTrace();

                    }
                    
                }
                
            }
            
        });
        
        httpClient.excecute("http://localhost:8080/cooktime1/api/services/getAllRecipes/");
        
    }//GEN-LAST:event_btnRecipesActionPerformed

    private void btnEnterprisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterprisesActionPerformed
        
        HttpClient httpClient = new HttpClient(new OnHttpRequestComplete() {
            
            @Override
            public void onComplete(Response status) {
                
                if (status.isSuccess()) {
                    
                    JSONParser parser = new JSONParser();

                    try {
                        
                        JSONArray jsonFile = (JSONArray) parser.parse(status.getResult());
                        
                        DefaultTableModel model = (DefaultTableModel) tableEnterprises.getModel();
                        
                        model.setRowCount(0);
                                                                        
                        for (int i = 0; i < jsonFile.size(); i ++) {
                                                    
                            addRowEnterprise((JSONObject) jsonFile.get(i), i + 1);
                            
                        }
                        
                    } catch (Exception e) {

                        e.printStackTrace();

                    }
                    
                }
                                
            }
            
        });
        
        httpClient.excecute("http://localhost:8080/cooktime1/api/services/getAllEnterprises/");
        
    }//GEN-LAST:event_btnEnterprisesActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        
        HttpClient httpClient = new HttpClient(new OnHttpRequestComplete() {

            @Override
            public void onComplete(Response status) {

                if (status.isSuccess()) {

                    JSONParser parser = new JSONParser();

                    try {

                        JSONArray jsonFile = (JSONArray) parser.parse(status.getResult());
                        
                        DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
                        
                        model.setRowCount(0);

                        for (int i = 0; i < jsonFile.size(); i ++) {

                            addRowUser((JSONObject) jsonFile.get(i), i + 1);

                        }

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                }

            }

        });

        httpClient.excecute("http://localhost:8080/cooktime1/api/services/getAllUsers/");

    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnAssignChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignChefActionPerformed
        
        String email = JOptionPane.showInputDialog(null, "Insert user's email", "Assign New User", HEIGHT);
                
        String url = "http://localhost:8080/cooktime1/api/services/postChef/";
                
        Client client = Client.create();
        WebResource target = client.resource(url);
        
        ClientResponse response = target.queryParam("email", email).accept("application/json")
                      .type("application/json").post(ClientResponse.class, email);
        
    }//GEN-LAST:event_btnAssignChefActionPerformed
    
    private void addRowUser(JSONObject object, int number) {
                                
        DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
        
        Object rowData[] = new Object[11];

        rowData[0] = number;
        rowData[1] = (String) object.get("email");
        rowData[2] = (String) object.get("name");
        rowData[3] = (String) object.get("lastName");
        rowData[4] = (String) object.get("age").toString();
        rowData[5] = (String) object.get("password");
        rowData[6] = (String) object.get("photo");
        rowData[7] = (String) object.get("myMenuList").toString();
        rowData[8] = (String) object.get("followers").toString();
        rowData[9] = (String) object.get("followed").toString();
        rowData[10] = (String) object.get("chef").toString();

        model.addRow(rowData);
            
    }
    
    private void addRowRecipe(JSONObject object, int number) {
        
        DefaultTableModel model = (DefaultTableModel) tableRecipes.getModel();

        Object rowData[] = new Object[18];

        rowData[0] = number;
        rowData[1] = (String) object.get("name");
        rowData[2] = (String) object.get("author");
        rowData[3] = (String) object.get("type");
        rowData[4] = (String) object.get("portions").toString();
        rowData[5] = (String) object.get("duration").toString();
        rowData[6] = (String) object.get("time");
        rowData[7] = (String) object.get("difficulty").toString();
        rowData[8] = (String) object.get("dietTag");
        rowData[9] = (String) object.get("photo");
        rowData[10] = (String) object.get("ingredients");
        rowData[11] = (String) object.get("steps");
        rowData[12] = (String) object.get("price").toString();
        rowData[13] = (String) object.get("calification").toString();
        rowData[14] = (String) object.get("day").toString();
        rowData[15] = (String) object.get("month").toString();
        rowData[16] = (String) object.get("year").toString();
        rowData[17] = (String) object.get("commentary").toString();
        
        model.addRow(rowData);
            
    }
    
    private void addRowEnterprise(JSONObject object, int number) {
                
        DefaultTableModel model = (DefaultTableModel) tableEnterprises.getModel();

        Object rowData[] = new Object[10];

        rowData[0] = number;
        rowData[1] = (String) object.get("name");
        rowData[2] = (String) object.get("logo");
        rowData[3] = (String) object.get("contact");
        rowData[4] = (String) object.get("schedule");
        rowData[5] = (String) object.get("direction");
        rowData[6] = (String) object.get("calification").toString();
        rowData[7] = (String) object.get("followers").toString();
        rowData[8] = (String) object.get("members").toString();
        rowData[9] = (String) object.get("myMenuList").toString();
        
        model.addRow(rowData);
            
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                new ServerWindow().setVisible(true);
                
            }
            
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignChef;
    private javax.swing.JButton btnEnterprises;
    private javax.swing.JButton btnRecipes;
    private javax.swing.JButton btnUsers;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPanelEnterprises;
    private javax.swing.JScrollPane scrollPanelRecipes;
    private javax.swing.JScrollPane scrollPanelUsers;
    private javax.swing.JTable tableEnterprises;
    private javax.swing.JTable tableRecipes;
    private javax.swing.JTable tableUsers;
    // End of variables declaration//GEN-END:variables
}
