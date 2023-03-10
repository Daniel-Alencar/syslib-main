/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.syslib;

/**
 *
 * @author engenheiro
 */
public class BookScreen extends javax.swing.JPanel {

    /**
     * Creates new form BookScreen
     */
    public BookScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        contentArea = new javax.swing.JPanel();
        bookImage = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        buttonContainer = new javax.swing.JPanel();
        deadLineLabel = new javax.swing.JLabel();
        bookButton = new javax.swing.JButton();
        messageContainer = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();

        name.setBackground(new java.awt.Color(62, 67, 159));
        name.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Syslib");
        name.setToolTipText("");
        name.setOpaque(true);

        bookImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseBook.png"))); // NOI18N

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Título do livro");

        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel.setText("Autor do livro");

        deadLineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deadLineLabel.setText("Data de devolução: 22/10/2001");

        bookButton.setText("Reservar");

        javax.swing.GroupLayout buttonContainerLayout = new javax.swing.GroupLayout(buttonContainer);
        buttonContainer.setLayout(buttonContainerLayout);
        buttonContainerLayout.setHorizontalGroup(
            buttonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deadLineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
            .addGroup(buttonContainerLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(bookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonContainerLayout.setVerticalGroup(
            buttonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deadLineLabel)
                .addGap(15, 15, 15)
                .addComponent(bookButton)
                .addContainerGap())
        );

        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("Seu livro foi reservado! Compareça a biblioteca para retirar seu exemplar!");

        javax.swing.GroupLayout messageContainerLayout = new javax.swing.GroupLayout(messageContainer);
        messageContainer.setLayout(messageContainerLayout);
        messageContainerLayout.setHorizontalGroup(
            messageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(messageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        messageContainerLayout.setVerticalGroup(
            messageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentAreaLayout = new javax.swing.GroupLayout(contentArea);
        contentArea.setLayout(contentAreaLayout);
        contentAreaLayout.setHorizontalGroup(
            contentAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bookImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentAreaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );
        contentAreaLayout.setVerticalGroup(
            contentAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentAreaLayout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(bookImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(authorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(contentArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(568, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(contentArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton bookButton;
    private javax.swing.JLabel bookImage;
    private javax.swing.JPanel buttonContainer;
    private javax.swing.JPanel contentArea;
    private javax.swing.JLabel deadLineLabel;
    private javax.swing.JPanel messageContainer;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel name;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
