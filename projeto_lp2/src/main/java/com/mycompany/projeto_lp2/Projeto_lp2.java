package com.mycompany.projeto_lp2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author gulos
 */
public class Projeto_lp2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conteiner cont = new Conteiner();
        Deque<Conteiner> a = new ArrayDeque<>();
        Deque<Conteiner> b = new ArrayDeque<>();
        
        int quant = 1;
        int quant2 = 1;
        int op;

        do {
            System.out.println("Inserir[1] visualizar[2] encerrar[3]");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    System.out.println("posiçao : A | B |   ");
                    String posicao = scan.nextLine().toUpperCase();
                    

                    System.out.println("nome do proprietario: ");
                    String nome=scan.nextLine();

                    System.out.println("tipo de carga: SECA(1), COMMODIT(2), PERIGOSO(3), PERECIVEL(4) ");
                    int Tcarga = scan.nextInt();
                    String carga = null;
                    switch (Tcarga) {
                        case 1:
                            carga = "SECA";
                            break;
                        case 2:
                            carga = "COMMODIT";
                            break;
                        case 3:
                            carga = "PERIGOSO";
                            break;
                        case 4:
                            carga = "PERECIVEL";
                            break;
                    }

                    System.out.println("peso da carga: ");
                    float peso = scan.nextFloat();
                    
                    //inserir    
                    if ("A".equals(posicao)) {
                        if(quant <= 6){//quantidade maxima
                            quant++;
                            Conteiner conteiner = new Conteiner(nome, carga, peso);
                            a.push(conteiner);  Iterator<Conteiner> ita = a.iterator();
                            Object aux = ita.next(); System.out.println("OBJETO INSERIDO: " + aux + " Posicao A{} \n");
                            
                        }else{System.out.println("quantidade excedida");}
                    }
                    
                    if ("B".equals(posicao)) {
                        if(quant <= 6){//quantidade maxima
                            quant2++;
                            Conteiner conteiner = new Conteiner(nome, carga, peso);
                            b.push(conteiner);Iterator<Conteiner> itb = b.iterator();
                            Object aux = itb.next(); System.out.println("OBJETO INSERIDO: " + aux + " Posicao B{} \n");
                            
                         }else{System.out.println("quantidade excedida");}
                    }
               
                    break;
                case 2:
                    
                    //visualizar
                    System.out.println("Digite a doca:  A | B | ");
                    String doca = scan.nextLine().toUpperCase();
                    if(!a.isEmpty()){
                        if ("A".equals(doca)) {
                            Iterator<Conteiner> it1 = a.iterator();
                            while (it1.hasNext()) {
                                Object aux = it1.next();
                                System.out.println("Objeto inserido: " + aux + " Posicao A{} \n"); 
                            } break;
                    }}else{System.out.println("VAZIO");}
                    
                    if(!b.isEmpty()){
                        if ("B".equals(doca)) {
                            Iterator<Conteiner> it2 = b.iterator();
                            while (it2.hasNext()) {
                                Object aux = it2.next();
                                System.out.println("Objeto inserido: " + aux + " Posicao B{} \n");  
                        }break;
                        }}else{System.out.println("VAZIO");}
                    
                      break;        
         }            
        } while (op != 3); 
        }
    }
