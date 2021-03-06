/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proyek.organize.Catalog;
import proyek.organize.Products;

/**
 *
 * @author Reyhan
 */
public class TransactionPanel extends javax.swing.JPanel {

    /**
     * Creates new form TransactionPanel
     */
    private static final String FILE_PRODUCTS = "src\\proyek\\notes\\products.xlsx";
    private static final String FILE_LOGTRANSACTION = "logtest.xlsx";
    private Object kodeBarang;
    private Object namaBarang;
    private Object kategori;
    private Object harga;
    private int totalHarga;
    private Object stock;
    private DefaultTableModel dtm1;
    private DefaultTableModel dtm2;
    private Catalog catalogProducts = new Catalog();
    Map<String, Integer> nametobp = new TreeMap<String, Integer>();

    public TransactionPanel() {
        initComponents();
        jTableListItem.setAutoCreateRowSorter(true);
        Object[] header = {"Code", "Name", "Category", "Price", "Stock"};
        Object[] header2 = {"Code", "Name", "Category", "Quantity", "Price"};
        dtm1 = new DefaultTableModel(0, 0);
        dtm2 = new DefaultTableModel(0, 0);
        dtm1.setColumnIdentifiers(header);
        dtm2.setColumnIdentifiers(header2);
        jTableCart.setModel(dtm2);
    }

    public void showProducts() {
        jTableListItem.setModel(dtm1);
        DefaultTableModel tableProducts = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableListItem.setAutoCreateRowSorter(true);
        Object[] headerTable = {"Code", "Name", "Category", "Sale Price (Rp)", "Stock"};
        tableProducts.setColumnIdentifiers(headerTable);

        for (int indeksList = 0; indeksList < catalogProducts.getProducts().size(); indeksList++) {
            Object[] products = new Object[]{
                catalogProducts.getProducts().get(indeksList).getProductCode(),
                catalogProducts.getProducts().get(indeksList).getProductName(),
                catalogProducts.getProducts().get(indeksList).getProductCategory(),
                catalogProducts.getProducts().get(indeksList).getSalePrice(),
                catalogProducts.getProducts().get(indeksList).getProductStock(),};
            tableProducts.addRow(products);
        }
        jTableListItem.setModel(tableProducts);
    }

    public void SearchProducts(String textToSearch) {
        DefaultTableModel tableProducts = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableListItem.setAutoCreateRowSorter(true);
        Object[] headerTable = {"Code", "Name", "Category", "Sale Price (Rp)", "Stock"};
        tableProducts.setColumnIdentifiers(headerTable);

        for (int indeksList = 0; indeksList < catalogProducts.getProducts().size(); indeksList++) {
            if (catalogProducts.getProducts().get(indeksList).getProductName().contains(textToSearch)) {
                Object[] products = new Object[]{
                    catalogProducts.getProducts().get(indeksList).getProductCode(),
                    catalogProducts.getProducts().get(indeksList).getProductName(),
                    catalogProducts.getProducts().get(indeksList).getProductCategory(),
                    catalogProducts.getProducts().get(indeksList).getSalePrice(),
                    catalogProducts.getProducts().get(indeksList).getProductStock()
                };
                tableProducts.addRow(products);
            } else if (catalogProducts.getProducts().get(indeksList).getProductCode().contains(textToSearch)) {
                Object[] products = new Object[]{
                    catalogProducts.getProducts().get(indeksList).getProductCode(),
                    catalogProducts.getProducts().get(indeksList).getProductName(),
                    catalogProducts.getProducts().get(indeksList).getProductCategory(),
                    catalogProducts.getProducts().get(indeksList).getSalePrice(),
                    catalogProducts.getProducts().get(indeksList).getProductStock()
                };
                tableProducts.addRow(products);
            } else if (catalogProducts.getProducts().get(indeksList).getProductCategory().contains(textToSearch)) {
                Object[] products = new Object[]{
                    catalogProducts.getProducts().get(indeksList).getProductCode(),
                    catalogProducts.getProducts().get(indeksList).getProductName(),
                    catalogProducts.getProducts().get(indeksList).getProductCategory(),
                    catalogProducts.getProducts().get(indeksList).getSalePrice(),
                    catalogProducts.getProducts().get(indeksList).getProductStock()
                };
                tableProducts.addRow(products);
            } else if (String.valueOf(catalogProducts.getProducts().get(indeksList).getProductStock()).contains(textToSearch)) {
                Object[] products = new Object[]{
                    catalogProducts.getProducts().get(indeksList).getProductCode(),
                    catalogProducts.getProducts().get(indeksList).getProductName(),
                    catalogProducts.getProducts().get(indeksList).getProductCategory(),
                    catalogProducts.getProducts().get(indeksList).getSalePrice(),
                    catalogProducts.getProducts().get(indeksList).getProductStock()
                };
                tableProducts.addRow(products);
            } else if (String.valueOf(catalogProducts.getProducts().get(indeksList).getSalePrice()).contains(textToSearch)) {
                Object[] products = new Object[]{
                    catalogProducts.getProducts().get(indeksList).getProductCode(),
                    catalogProducts.getProducts().get(indeksList).getProductName(),
                    catalogProducts.getProducts().get(indeksList).getProductCategory(),
                    catalogProducts.getProducts().get(indeksList).getSalePrice(),
                    catalogProducts.getProducts().get(indeksList).getProductStock()
                };
                tableProducts.addRow(products);
            }
        }
        jTableListItem.setModel(tableProducts);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListItem = new javax.swing.JTable();
        jLabelListItem = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCart = new javax.swing.JTable();
        jLabelCart = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jButtonDone = new javax.swing.JButton();
        jLabelRupiah = new javax.swing.JLabel();
        jLabelTotalRupiah = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(676, 0));

        jTableListItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Category", "Price", "Stock"
            }
        ));
        jScrollPane1.setViewportView(jTableListItem);

        jLabelListItem.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelListItem.setText("Item Lists");

        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/icons/search.png"))); // NOI18N

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jTableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Category", "Quantity", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(jTableCart);

        jLabelCart.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelCart.setText("Cart");

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/icons/cart (2).png"))); // NOI18N
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabelTotal.setText("Total :");

        jButtonDone.setText("Done");
        jButtonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoneActionPerformed(evt);
            }
        });

        jLabelRupiah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabelRupiah.setText("Rp.");

        jLabelTotalRupiah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabelTotalRupiah.setText("0");

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/icons/cart.png"))); // NOI18N
        jButtonAdd.setPreferredSize(new java.awt.Dimension(63, 23));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelListItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRupiah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalRupiah, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelListItem)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCart)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabelRupiah)
                    .addComponent(jLabelTotalRupiah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public int SearchProducts(Products newProduct) {
        int indeks = 0;
        while (indeks < catalogProducts.getProducts().size()) {
            if (catalogProducts.getProducts().get(indeks).getProductCode().equals(newProduct.getProductCode())) {
                return indeks;
            } else if (catalogProducts.getProducts().get(indeks).getProductName().equals(newProduct.getProductName())) {
                return indeks;
            }
            indeks++;
        }
        return -1;
    }

    private boolean notFoundInCart(int qty, int selectedRow /* for update catalog index */) {
        int last = jTableCart.getRowCount();
        int row = 0;
        while (row != last) {
            if ((String) jTableCart.getValueAt(row, 1) == namaBarang) {
                jTableCart.setValueAt((int) jTableCart.getValueAt(row, 3) + qty, row, 3);
                int curStock = catalogProducts.getProducts().get(selectedRow).getProductStock();

                if (curStock - qty > 0) {
                    catalogProducts.getProducts().get(selectedRow).setProductStock(curStock - qty);
                } else if (curStock - qty == 0) {
                    String x = catalogProducts.getProducts().get(selectedRow).getProductName();
                    int xx = catalogProducts.getProducts().get(selectedRow).getBuyItemPrice();
                    this.nametobp.put(x, xx);
                    catalogProducts.getProducts().remove(selectedRow);
                }
                this.showProducts();
                return false;
            }
            row++;
        }
        int curStock = catalogProducts.getProducts().get(selectedRow).getProductStock();
        if (curStock - qty > 0) {
            catalogProducts.getProducts().get(selectedRow).setProductStock(curStock - qty);
        } else if (curStock - qty == 0) {
            String x = catalogProducts.getProducts().get(selectedRow).getProductName();
            int xx = catalogProducts.getProducts().get(selectedRow).getBuyItemPrice();
            this.nametobp.put(x, xx);
            catalogProducts.getProducts().remove(selectedRow);
        }
        this.showProducts();
        return true;
    }

    @SuppressWarnings("empty-statement")
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        String qty;
        do {
            qty = String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Quantity: ")));
        }while (qty == "");
        

        int selectedRow = jTableListItem.getSelectedRow();
        kodeBarang = jTableListItem.getValueAt(selectedRow, 0);
        namaBarang = jTableListItem.getValueAt(selectedRow, 1);
        kategori = jTableListItem.getValueAt(selectedRow, 2);
        harga = jTableListItem.getValueAt(selectedRow, 3);
        stock = jTableListItem.getValueAt(selectedRow, 4);
        
        
        int qq = new Integer(qty);
        int ss = (int)stock;
        if(qq > ss) qty = String.valueOf(stock);
        Object[] data = new Object[6];

        data[0] = kodeBarang;
        data[1] = namaBarang;
        data[2] = kategori;
        data[3] = new Integer(qty);
        data[4] = new Integer(qty) * (int) harga;

        if (notFoundInCart(new Integer(qty), selectedRow)) {
            dtm2.addRow(data);
        }
        totalHarga = totalHarga + (int) data[4];
        jLabelTotalRupiah.setText(String.valueOf(totalHarga));
    }//GEN-LAST:event_jButtonAddActionPerformed

    private Products updcat(String c1, String c2, String c3, int c4, int c5, int delrowi) {
        int f = 0;
        int last = jTableListItem.getRowCount(), row = 0;
        while (row != last) {
            if (c2.equals(jTableListItem.getValueAt(row, 1))) {
                int curStock = (int) jTableListItem.getValueAt(row, 4);
                jTableListItem.setValueAt(curStock + c4, row, 4);
                f = 1;
                dtm2.removeRow(delrowi);
            }
            if (f == 1) {
                break;
            }
            row++;
        }
        Products insp = new Products();
        if (f == 0) {
            insp.setProductCode(c1);
            insp.setProductName(c2);
            insp.setProductCategory(c3);
            insp.setProductStock(c4);
            insp.setSalePrice(c5 / c4);
            insp.setBuyItemPrice(nametobp.get(c2));
            nametobp.remove(c2);
        }
        return insp;
    }

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            int index = jTableCart.getSelectedRow();
            if (totalHarga > 0) {
                totalHarga = totalHarga - (int) jTableCart.getValueAt(index, 4);
                jLabelTotalRupiah.setText(String.valueOf(totalHarga));
            }

            String c1 = (String) jTableCart.getValueAt(index, 0);
            String c2 = (String) jTableCart.getValueAt(index, 1);
            String c3 = (String) jTableCart.getValueAt(index, 2);
            int c4 = (int) jTableCart.getValueAt(index, 3);
            int c5 = (int) jTableCart.getValueAt(index, 4);
            Products newProduct = new Products();
            newProduct = updcat(c1, c2, c3, c4, c5, index);

            if (SearchProducts(newProduct) != -1) {
                int indeks = SearchProducts(newProduct);
                int curStock = catalogProducts.getProducts().get(index).getProductStock();
                catalogProducts.getProducts().get(indeks).setProductStock(curStock + (int) jTableCart.getValueAt(index, 3));
            } else
                catalogProducts.getProducts().add(newProduct);
            dtm2.removeRow(index);
            this.showProducts();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoneActionPerformed
        if(dtm2.getRowCount() == 0) return;
        try {
            FileInputStream fis = new FileInputStream(new File(FILE_LOGTRANSACTION));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int row = sheet.getLastRowNum();
            
            String curDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
            Date cDate = new Date();
            String curTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            
            for(int i = 0 ; i < dtm2.getRowCount(); i++) {
                sheet.createRow(row).createCell(0).setCellValue(cDate.getTime());
                sheet.getRow(row).createCell(1).setCellValue(curTime);
                sheet.getRow(row).createCell(2).setCellValue((String) dtm2.getValueAt(i, 0));                
                sheet.getRow(row).createCell(3).setCellValue((String) dtm2.getValueAt(i, 1));
                sheet.getRow(row).createCell(4).setCellValue((String) dtm2.getValueAt(i, 2));
                sheet.getRow(row).createCell(5).setCellValue((int) dtm2.getValueAt(i, 3));
                sheet.getRow(row).createCell(6).setCellValue((int) dtm2.getValueAt(i, 4));
                row++;
            }
            
            try (FileOutputStream fos = new FileOutputStream(new File(FILE_LOGTRANSACTION))) {
                workbook.write(fos);
                fos.close();
            }
            
            fis.close();
            
            fis = new FileInputStream(new File("src\\proyek\\notes\\lastlog.xlsx"));
            workbook = new XSSFWorkbook();
            workbook.createSheet("0");
            sheet = workbook.getSheetAt(0);
            
            sheet.createRow(0).createCell(0).setCellValue(curDate);
            sheet.getRow(0).createCell(1).setCellValue(curTime);
            for (int i = 0; i < dtm2.getRowCount(); i++) {
                sheet.createRow(i+1).createCell(0).setCellValue((String) dtm2.getValueAt(i, 0));
                sheet.getRow(i+1).createCell(1).setCellValue((String) dtm2.getValueAt(i, 1));
                sheet.getRow(i+1).createCell(2).setCellValue((String) dtm2.getValueAt(i, 2));
                sheet.getRow(i+1).createCell(3).setCellValue((int) dtm2.getValueAt(i, 3));
                sheet.getRow(i+1).createCell(4).setCellValue((int) dtm2.getValueAt(i, 4));
                row++;
            }
            try (FileOutputStream fos = new FileOutputStream(new File("src\\proyek\\notes\\lastlog.xlsx"))) {
                workbook.write(fos);
                fos.close();
            }
            while(dtm2.getRowCount() != 0) {
                dtm2.removeRow(0);
            }
            totalHarga = 0;
            jLabelTotalRupiah.setText(String.valueOf(totalHarga));
        } catch (IOException ex) {
            Logger.getLogger(TransactionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDoneActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        String textToSearch = jTextFieldSearch.getText();
        SearchProducts(textToSearch.toUpperCase());
    }//GEN-LAST:event_jTextFieldSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDone;
    private javax.swing.JLabel jLabelCart;
    private javax.swing.JLabel jLabelListItem;
    private javax.swing.JLabel jLabelRupiah;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalRupiah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCart;
    private javax.swing.JTable jTableListItem;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the catalogProducts
     */
    public Catalog getCatalogProducts() {
        return catalogProducts;
    }

    /**
     * @param catalogProducts the catalogProducts to set
     */
    public void setCatalogProducts(Catalog catalogProducts) {
        this.catalogProducts = catalogProducts;
    }
}
