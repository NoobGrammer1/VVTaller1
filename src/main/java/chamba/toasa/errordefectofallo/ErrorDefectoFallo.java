/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package chamba.toasa.errordefectofallo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


/**
 * @author ChambaAnthony-ToasaKevin
 */
public class ErrorDefectoFallo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Lista_Usuario list = new Lista_Usuario();
        list.initUser();
        System.out.print("Bienvenido al inicio de sesión\n");
        System.out.println("Usuario: ");
        String name = sc.nextLine();
        System.out.println("Contrasena: ");
        String password = sc.nextLine();
        try {
            Usuario usuario = new Usuario(name, password);
            if (list.verificarUsuario(usuario)){
                System.out.println("Ha ingresado exitosamente a su cuenta");


                int numberChoosen = 0;

                String[][] items = new String[8][2];
                Scanner scr = new Scanner(System.in);

                try {
                    int iterator = 0;
                    String cadena;
                    FileReader f = new FileReader(System.getProperty("user.dir") + "/src/main/java/chamba/toasa/errordefectofallo/inventario.txt");
                    BufferedReader b = new BufferedReader(f);
                    while ((cadena = b.readLine()) != null) {

                        items[iterator][0] = cadena.split(",")[0];
                        items[iterator][1] = cadena.split(",")[1];
                        iterator++;
                    }
                    b.close();
                } catch (Exception e) {
                    System.out.print("Error :");
                    e.printStackTrace();
                }

                System.out.println("Hola, para consultar un ítem del inventario presione un número del 1 al " + items.length);
                String userInput = scr.nextLine();


                try {
                    numberChoosen = Integer.parseInt(userInput);
                } catch (Exception e) {
                    System.out.println("No se ha ingresado un número");
                }

//        for (String[] item : items) {
//            System.out.println("Item :" + item[0] +
//                    " : " + item[1]);
//        }
                System.out.println("The item asked is: " + items[numberChoosen][0] +","+ items[numberChoosen][1]);
        /*El error es que no se consideró que el indice debe tener un rango de 0 a 7, esto no fue adaptado y, por ende,
        al solicitar el primer elemento se muestra el segundo elemento siendo este el defecto. El fallo se manifiesta
        al solicitar el último elemento, donde nos va a arrojar un error de fuera de límite del arreglo. */






            }else{
                System.out.println("Ha ingresado erroneamente sus credenciales");
            }
        }catch(ExceptionInInitializerError e){
            System.out.println("Error al iniciar sesión" + e);
        }



    }

}