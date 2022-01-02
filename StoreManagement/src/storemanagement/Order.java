package storemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public final class Order extends javax.swing.JFrame {

   
    public Order() {
        initComponents();
        SelectProd();
        SelectCust();
        GetToday();
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    public void SelectProd()
    {
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InvDB","Staff1","admin");
            St = Con.createStatement();
            Rs = St.executeQuery("select * from PRODUCTSTBL");
            ProductTable.setModel(DbUtils.resultSetToTableModel(Rs));
        
        }catch(SQLException e)
        {
            e.printStackTrace();
            
        }
    }
    
     public void SelectCust()
    {
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InvDB","Staff1","admin");
            St = Con.createStatement();
            Rs = St.executeQuery("select * from CUSTOMER");
            CustomerTbl.setModel(DbUtils.resultSetToTableModel(Rs));
        
        }catch(SQLException e)
        {
            e.printStackTrace();
            
        }
    }
     
     private void GetToday()
     {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDateTime now = LocalDateTime.now();
         Datelbl.setText(dtf.format(now));
         
         //Deixnei thn wra
     }
     private void update()
     {
         int newqty = oldqty - Integer.valueOf(Qtytb1.getText());
         try{
                        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InvDB","Staff1","admin");
                        String UpdateQuery = "update Staff1.PRODUCTSTBL set PRODQUTY="+newqty+""+"where PRODID ="+productid;
                        Statement Add = Con.createStatement();
                        Add.executeUpdate(UpdateQuery);
                        //JOptionPane.showMessageDialog(this, "Category Updated Succesfully");
                        SelectProd();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
     }
    
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        OrderId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        AddToBtn = new javax.swing.JButton();
        CustNamelbls = new javax.swing.JTextField();
        PrintBtn = new javax.swing.JButton();
        Datelbl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CustomerTbl = new javax.swing.JTable();
        TotAmttbl = new javax.swing.JTextField();
        Qty = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BillTbl = new javax.swing.JTable();
        Price = new javax.swing.JTextField();
        Qtytb1 = new javax.swing.JTextField();
        Qty1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("OrderId");

        ProductTable.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Id", "Quantity", "Description", "Category"
            }
        ));
        ProductTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductTable.setRowHeight(25);
        ProductTable.setSelectionBackground(new java.awt.Color(101, 109, 74));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        jPanel2.setBackground(new java.awt.Color(101, 109, 74));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(237, 224, 212));
        jLabel9.setText("Order Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(25, 25, 25))
        );

        OrderId.setBackground(new java.awt.Color(237, 224, 212));
        OrderId.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setText("PRODUCTS LIST");

        AddToBtn.setBackground(new java.awt.Color(237, 224, 212));
        AddToBtn.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        AddToBtn.setText("ADD TO ORDER");
        AddToBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToBtnMouseClicked(evt);
            }
        });
        AddToBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToBtnActionPerformed(evt);
            }
        });

        CustNamelbls.setBackground(new java.awt.Color(237, 224, 212));
        CustNamelbls.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        CustNamelbls.setText("CustName");

        PrintBtn.setBackground(new java.awt.Color(237, 224, 212));
        PrintBtn.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        PrintBtn.setText("PRINT");
        PrintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBtnMouseClicked(evt);
            }
        });
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        Datelbl.setBackground(new java.awt.Color(237, 224, 212));
        Datelbl.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        Datelbl.setText("Date");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("Date");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setText("CustomerName");

        AddBtn.setBackground(new java.awt.Color(237, 224, 212));
        AddBtn.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        AddBtn.setText("ADD ORDER");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setBackground(new java.awt.Color(237, 224, 212));
        UpdateBtn.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        UpdateBtn.setText("VIEW ORDERS");
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel10.setText("CUSTOMERS LIST");

        CustomerTbl.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        CustomerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Id", "Quantity", "Description", "Category"
            }
        ));
        CustomerTbl.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CustomerTbl.setRowHeight(25);
        CustomerTbl.setSelectionBackground(new java.awt.Color(101, 109, 74));
        CustomerTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CustomerTbl);

        TotAmttbl.setBackground(new java.awt.Color(237, 224, 212));
        TotAmttbl.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        TotAmttbl.setText("Amount");

        Qty.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Qty.setText("Quantity");

        BillTbl.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        BillTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Product", "Quantity", "UPrice", "Total"
            }
        ));
        BillTbl.setIntercellSpacing(new java.awt.Dimension(0, 0));
        BillTbl.setRowHeight(25);
        BillTbl.setSelectionBackground(new java.awt.Color(101, 109, 74));
        BillTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(BillTbl);

        Price.setBackground(new java.awt.Color(237, 224, 212));
        Price.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N

        Qtytb1.setBackground(new java.awt.Color(237, 224, 212));
        Qtytb1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N

        Qty1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Qty1.setText("Price");

        jButton4.setBackground(new java.awt.Color(237, 224, 212));
        jButton4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jButton4.setText("HOME");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(156, 156, 156)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(AddBtn)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustNamelbls, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Qty1)
                                    .addComponent(UpdateBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(176, 176, 176))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Qty)
                        .addGap(27, 27, 27)
                        .addComponent(Qtytb1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddToBtn)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TotAmttbl, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PrintBtn)
                .addGap(149, 149, 149))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(jButton4)
                    .addContainerGap(982, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustNamelbls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddToBtn)
                            .addComponent(Qty)
                            .addComponent(Qtytb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddBtn)
                            .addComponent(UpdateBtn))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Qty1))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotAmttbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrintBtn))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(561, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(128, 128, 128)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    int flag = 0,productid,oldqty;
    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
       DefaultTableModel model = (DefaultTableModel)ProductTable.getModel();
        int Myindex = ProductTable.getSelectedRow();
        productid = Integer.valueOf(model.getValueAt(Myindex,1).toString());
        Prodname = model.getValueAt(Myindex, 0).toString();
        oldqty = Integer.valueOf(model.getValueAt(Myindex,2).toString());
        //Datelbl.setText(model.getValueAt(Myindex, 3).toString());
        flag = 1;
       
    }//GEN-LAST:event_ProductTableMouseClicked

    
   int i =1,Uprice,tot=0,total;
   String Prodname;
    private void AddToBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToBtnMouseClicked
        if(flag == 0 || Qtytb1.getText().isEmpty() || Price.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Select Product and Enter Qty");
        }
        else
        { 
        Uprice = Integer.valueOf(Price.getText());
        tot = Uprice * Integer.valueOf(Qtytb1.getText());
        Vector v = new Vector();
        v.add(Prodname);
        v.add(Qtytb1.getText());
        v.add(Uprice);
        v.add(tot);
        DefaultTableModel dt = (DefaultTableModel)BillTbl.getModel();
        dt.addRow(v);
        total=total+tot;
        TotAmttbl.setText("$"+total);
        update();
        i++;
       }
       
        /*if(ProdId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter the product to be deleted");
        }
        else
        {
            try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InvDB","Staff1","admin");
                String Id = ProdId.getText();
                String Query = "Delete from Staff1.PRODUCTSTBL where PRODID="+Id;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                SelectProd();
                JOptionPane.showMessageDialog(this, "Product deleted succesfully");
            }catch(SQLException e)
            {
                e.printStackTrace(CustNamelbl        }
        }
         */
    }//GEN-LAST:event_AddToBtnMouseClicked

    private void AddToBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToBtnActionPerformed

    }//GEN-LAST:event_AddToBtnActionPerformed

    private void PrintBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseClicked
        try{
            OrderId.print();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }//GEN-LAST:event_PrintBtnMouseClicked

    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed

    }//GEN-LAST:event_PrintBtnActionPerformed

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked

        if(OrderId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter The Bill Id");
        }else{
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InvDB","Staff1","admin");
            PreparedStatement add = Con.prepareStatement("insert into ORDERTBL values(?,?,?,?)");
            add.setInt(1, Integer.valueOf(OrderId.getText()));
            add.setString(2, CustNamelbls.getText());
            add.setString(3, Datelbl.getText());
            add.setInt(4, Integer.valueOf(TotAmttbl.getText()));
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this,"Product Successfully Added");
            Con.close();
            SelectProd();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        }  //Προσθηκη product 
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed

    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
     /*   if(ProdName.getText().isEmpty()|ProdId.getText().isEmpty()|ProdQty.getText().isEmpty()|Datelbl.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Infortmation");
        }
        else
        {
            try{
    CustName     Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InvDB","Staff1","admin");
                String UpdateQuery = "update Staff1.PRODUCTSTBL set PRODNAME='"+ProdName.getText()+"'"+",PRODQTY="+ProdQty.getText()+""+",PRODDESC='"+Datelbl.getText()+"'"+",PRODCAT='"+CatCb.getSelectedItem().toString()+"'"+"where PRODID ="+ProdId.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
                JOptionPane.showMessageDialog(this, "Product Updated Succesfully");
                SelectProd();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
    }//GEN-LAST:event_UpdateBtnMouseClicked
/*
    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {     CustNamelbls//GEN-FIRST:event_UpdateBtnActionPerformed

    }//GEN-LAST:event_UpdateBtnActionPerformed
*/
    private void CustomerTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTblMouseClicked
        DefaultTableModel model = (DefaultTableModel)CustomerTbl.getModel();
        int Myindex = CustomerTbl.getSelectedRow();
       // CustId.setText(model.getValueAt(Myindex, 0).toString());
        CustNamelbls.setText(model.getValueAt(Myindex, 0).toString());
       // CustPhone.setText(model.getValueAt(Myindex, 2).toString());
    }//GEN-LAST:event_CustomerTblMouseClicked

    private void BillTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BillTblMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        new HUb().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddToBtn;
    private javax.swing.JTable BillTbl;
    private javax.swing.JTextField CustNamelbls;
    private javax.swing.JTable CustomerTbl;
    private javax.swing.JTextField Datelbl;
    private javax.swing.JTextField OrderId;
    private javax.swing.JTextField Price;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JTable ProductTable;
    private javax.swing.JLabel Qty;
    private javax.swing.JLabel Qty1;
    private javax.swing.JTextField Qtytb1;
    private javax.swing.JTextField TotAmttbl;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}
