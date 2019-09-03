/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author marlo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Conta donoConta01 = new Conta("Rodler", 1, 1000);
        Conta donoConta02 = new Conta("Mendonça", 2, 1000);
        Conta donoConta03 = new Conta("Candido", 3, 1000);
        Scanner entrada = new Scanner(System.in);
        int op, idLoc, idLoc1;
        double valor;

        ArrayList<Conta> listaConta = new ArrayList<Conta>();
        listaConta.add(donoConta01);
        listaConta.add(donoConta02);
        listaConta.add(donoConta03);

        System.out.println("\n\nQual operação deseja fazer: Sacar(1) - Depositar(2) - Transferir(3)");
        System.out.println("Digite sua opção: ");
        op = entrada.nextInt();
        Conta objConta = new Conta();
        Conta objConta1 = new Conta();
        switch (op) {
            case 1:
                System.out.println("Digite ID da Conta para Sacar: ");
                idLoc = entrada.nextInt();
                for (int k = 0; k < listaConta.size(); k++) {
                    objConta = listaConta.get(k);
                    if (objConta.getNumConta() == idLoc) {
                        System.out.println("\n\nConta: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - Saldo: " + objConta.getSaldo());
                        System.out.println("Infº o valor de saque: ");
                        valor = entrada.nextInt();
                        if (valor <= objConta.getSaldo()) {
                            objConta.sacar(valor);
                            System.out.println("Saldo restante: " + objConta.getSaldo());
                        } else {
                            System.out.println("Saldo indisponivel!");
                        }
                    }
                }
                break;

            case 2:
                System.out.println("Digite ID da Conta para Depositar: ");
                idLoc = entrada.nextInt();
                for (int k = 0; k < listaConta.size(); k++) {
                    objConta = listaConta.get(k);
                    if (objConta.getNumConta() == idLoc) {
                        System.out.println("\n\nConta: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - Saldo: " + objConta.getSaldo());
                        System.out.println("Infº o valor de depositar: ");
                        valor = entrada.nextInt();
                        objConta.depositar(valor);
                        System.out.println("Novo saldo: " + objConta.getSaldo());
                    }
                }
                break;

            case 3:
                System.out.println("Digite ID da Conta para Transferir: ");
                idLoc = entrada.nextInt();
                for (int k = 0; k < listaConta.size(); k++) {
                    objConta = listaConta.get(k);
                    if (objConta.getNumConta() == idLoc) {
                        System.out.println("\nConta: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - Saldo: " + objConta.getSaldo());
                        System.out.println("\nInfº ID para quem deseja transferir: ");
                        idLoc1 = entrada.nextInt();
                        for (int i = 0; i < listaConta.size(); i++) {
                            objConta1 = listaConta.get(i);
                            if (objConta1.getNumConta() == idLoc1) {
                                System.out.println("\nConta: " + objConta1.getNumConta() + " - " + objConta1.getNomeDono() + " - Saldo: " + objConta1.getSaldo());
                                System.out.println("\nInfº o valor de transferencia: ");
                                valor = entrada.nextInt();
                                objConta.transferir(objConta, valor, objConta1);
                                System.out.println("\nConta: "+objConta.getNumConta()+"\nNovo saldo da conta: " + objConta.getSaldo());
                                System.out.println("\nConta: "+objConta1.getNumConta()+"\nNovo saldo da conta: " + objConta1.getSaldo());
                            }  
                        }
                    }
                    
                }
                break;
        }

    }

}
