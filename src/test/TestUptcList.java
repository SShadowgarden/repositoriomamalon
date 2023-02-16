package test;

import co.edu.uptc.model.dinamic.UptcList;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class TestUptcList{
    @Test(expected = IndexOutOfBoundsException.class)
    public void TestIndexOutException() {
        List list = new UptcList();
        list.add("Valor: 0");
        list.add("Valor: 1");
        list.add("Valor: 2");
        list.add("Valor: 3");
        list.add("Valor: 4");
        list.add("Valor: 5");

        Assert.assertEquals(list.size(),6);
        Assert.assertEquals(list.get(3),"Valor: 3");
        //comprobar la excepcion IndexOutOfBoundsException
        list.get(40);
//        Assert.assertThrows(IndexOutOfBoundsException.class, list.get(-1));
    }

    @Test
    public void TestSubList() {
        List list = new UptcList();
        for (int i = 0; i < 7; i++) {
            list.add("Valor: " + i);
        }

        System.out.println(list.subList(3,5));
    }

    @Test
    public void toArrayWithParameterObject(){
        List list = new UptcList();
        for (int i = 0; i < 7; i++) {
            list.add("Valor: " + i);
        }
        Object[] array = list.toArray(new Object[9]);
        Assert.assertEquals(array.length,9);
        Assert.assertNull(array[8]);
        Assert.assertNull(array[7]);
    }

//    @Test
//    public void Test1RemoveByIndex() {
//        System.out.println("Removiendo 6");
//        System.out.println("Return del metodo remove: " + list.remove(6));
//        printTheList(list);
//
//        System.out.println("Removiendo 3");
//        System.out.println("Return del metodo remove: " + list.remove(3));
//        printTheList(list);
//
//        System.out.println("Removiendo 0");
//        System.out.println("Return del metodo remove: " + list.remove(0));
//        printTheList(list);
//    }

    private void printTheList(List list) {
        System.out.println("Tamaño: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.print("[" + o + "]--->");
        }
        System.out.println("\n");
    }

}
