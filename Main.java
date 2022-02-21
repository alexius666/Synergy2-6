package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        Class<Printer> printerClass = Printer.class;        // иначе работать не будет
        Class<Cartridge> cartridgeClass = Cartridge.class;

        System.out.println("Конструкторы класса Printer: "+ Arrays.toString(printerClass.getConstructors()));
        System.out.println("Только публичные поля класса Printer: "+ Arrays.toString(printerClass.getFields()));
        System.out.println("Поля класса Printer: "+ Arrays.toString(printerClass.getDeclaredFields()));
        System.out.println("Только публичные методы класса Printer: "+ Arrays.toString(printerClass.getMethods()));
        System.out.println("Методы класса Printer: "+ Arrays.toString(printerClass.getDeclaredMethods()));
        System.out.println("Методы класса Cartridge: "+ Arrays.toString(cartridgeClass.getDeclaredMethods()));
        System.out.println("Поля класса Cartridge: "+ Arrays.toString(cartridgeClass.getDeclaredFields()));

        Constructor<Printer> printerConstructor = printerClass.getConstructor(String.class, String.class, int.class);
        Printer printer = printerConstructor.newInstance("HP LaserJet 1536dnf MFP","SNO1727H21Z",2010);
        System.out.println(printer);

        // Обращение к полю
        Field serial = printerClass.getDeclaredField("serial");
        serial.setAccessible(true);
        serial.set(printer, "SN187236B8F");
        System.out.println(printer);

        // Обращение к методу
        Method setPrintedLists = printerClass.getMethod("setPrintedLists", int.class);
        int print = (int) setPrintedLists.invoke(printer,1500);
        System.out.println("Отпечатано страниц: "+print);
        System.out.println(printer);

        // Обращение к классу
        Constructor<Cartridge> cartridgeConstructor = cartridgeClass.getConstructor(String.class, int.class, String[].class);
        Cartridge cartridge = cartridgeConstructor.newInstance("CE-278",100,new String[]{"HP LaserJet 1536", "Canon LBP 6200"});
        System.out.println(cartridge);

        Constructor<Printer> printerConstructor1 = printerClass.getConstructor();
        Printer printer1 = printerClass.newInstance();
        System.out.println(printer1);
    }
}
