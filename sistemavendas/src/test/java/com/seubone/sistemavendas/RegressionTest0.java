package com.seubone.sistemavendas;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        com.seubone.sistemavendas.dto.ProdutoRequestDTO produtoRequestDTO0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.seubone.sistemavendas.model.Produto produto1 = new com.seubone.sistemavendas.model.Produto(produtoRequestDTO0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.seubone.sistemavendas.dto.ProdutoRequestDTO.SKU()\" because \"data\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        com.seubone.sistemavendas.SistemavendasApplication sistemavendasApplication0 = new com.seubone.sistemavendas.SistemavendasApplication();
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Double double1 = produto0.getPrecoCheio();
        java.lang.Class<?> wildcardClass2 = produto0.getClass();
        org.junit.Assert.assertNull(double1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.Double double3 = produto0.getPrecoCheio();
        java.lang.String str4 = produto0.getDescricao();
        produto0.setSku("");
        org.junit.Assert.assertNull(double3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        produto0.setPrecoCheio((java.lang.Double) 10.0d);
        org.junit.Assert.assertNull(long1);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.Double double3 = produto0.getPrecoCheio();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO4 = produto0.toResponse();
        java.lang.Class<?> wildcardClass5 = produtoResponseDTO4.getClass();
        org.junit.Assert.assertNull(double3);
        org.junit.Assert.assertNotNull(produtoResponseDTO4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.Double double3 = produto0.getPrecoCheio();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO4 = produto0.toResponse();
        java.lang.Class<?> wildcardClass5 = produto0.getClass();
        org.junit.Assert.assertNull(double3);
        org.junit.Assert.assertNotNull(produtoResponseDTO4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setId((java.lang.Long) 0L);
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO3 = produto0.toResponse();
        org.junit.Assert.assertNotNull(produtoResponseDTO3);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.String str3 = produto0.toString();
        java.lang.String str4 = produto0.getDescricao();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        produto5.setPrecoDescontado((java.lang.Double) 0.0d);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        produto0.setPrecoDescontado((java.lang.Double) 0.0d);
        produto0.setPrecoCheio((java.lang.Double) (-1.0d));
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO7 = produto0.toResponse();
        produto0.setId((java.lang.Long) 1L);
        org.junit.Assert.assertNotNull(produtoResponseDTO7);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        java.lang.Class<?> wildcardClass2 = produto0.getClass();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO2 = produto0.toResponse();
        java.lang.Double double3 = produto0.getPrecoCheio();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNotNull(produtoResponseDTO2);
        org.junit.Assert.assertNull(double3);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.String str3 = produto0.toString();
        produto0.setPrecoDescontado((java.lang.Double) 100.0d);
        produto0.setPrecoDescontado((java.lang.Double) (-1.0d));
        java.lang.String str8 = produto0.getSku();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        produto0.setPrecoDescontado((java.lang.Double) 0.0d);
        produto0.setPrecoCheio((java.lang.Double) (-1.0d));
        java.lang.String str7 = produto0.getDescricao();
        produto0.setDescricao("hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        produto0.setPrecoDescontado((java.lang.Double) 0.0d);
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO5 = produto0.toResponse();
        java.lang.String str6 = produto0.toString();
        org.junit.Assert.assertNotNull(produtoResponseDTO5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=0.0)" + "'", str6, "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=0.0)");
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        java.lang.Double double6 = produto5.getPrecoDescontado();
        java.lang.Long long7 = produto5.getId();
        boolean boolean9 = produto5.equals((java.lang.Object) (-1.0d));
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setId((java.lang.Long) 0L);
        java.lang.String str3 = produto0.toString();
        produto0.setSku("Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
        produto0.setPrecoDescontado((java.lang.Double) 1.0d);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=0, sku=null, descricao=null, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=0, sku=null, descricao=null, precoCheio=null, precoDescontado=null)");
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        produto0.setDescricao("");
        boolean boolean5 = produto0.equals((java.lang.Object) "Produto(id=-1, sku=null, descricao=null, precoCheio=null, precoDescontado=null)");
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        java.lang.Double double2 = produto0.getPrecoDescontado();
        java.lang.String str3 = produto0.toString();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNull(double2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=null, sku=null, descricao=null, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=null, sku=null, descricao=null, precoCheio=null, precoDescontado=null)");
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Double double1 = produto0.getPrecoCheio();
        java.lang.Object obj2 = null;
        boolean boolean3 = produto0.equals(obj2);
        java.lang.Double double4 = produto0.getPrecoDescontado();
        produto0.setId((java.lang.Long) 100L);
        produto0.setId((java.lang.Long) 1L);
        org.junit.Assert.assertNull(double1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(double4);
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.Double double3 = produto0.getPrecoCheio();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO4 = produto0.toResponse();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO5 = produto0.toResponse();
        produto0.setPrecoDescontado((java.lang.Double) (-1.0d));
        org.junit.Assert.assertNull(double3);
        org.junit.Assert.assertNotNull(produtoResponseDTO4);
        org.junit.Assert.assertNotNull(produtoResponseDTO5);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        produto0.setPrecoDescontado((java.lang.Double) 0.0d);
        produto0.setPrecoCheio((java.lang.Double) (-1.0d));
        produto0.setSku("Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=0.0)");
        java.lang.Long long9 = produto0.getId();
        org.junit.Assert.assertNull(long9);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        java.lang.Double double2 = produto0.getPrecoDescontado();
        produto0.setPrecoDescontado((java.lang.Double) (-1.0d));
        java.lang.String str5 = produto0.getSku();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNull(double2);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setId((java.lang.Long) (-1L));
        java.lang.String str3 = produto0.toString();
        java.lang.String str4 = produto0.getSku();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=-1, sku=null, descricao=null, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=-1, sku=null, descricao=null, precoCheio=null, precoDescontado=null)");
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "Produto(id=-1, sku=null, descricao=null, precoCheio=null, precoDescontado=null)", "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=0.0)", (java.lang.Double) (-1.0d), (java.lang.Double) (-1.0d));
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test27");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        java.lang.Object obj6 = null;
        boolean boolean7 = produto5.equals(obj6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test28");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        produto0.setSku("Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
        java.lang.String str4 = produto0.getSku();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO5 = produto0.toResponse();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)" + "'", str4, "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
        org.junit.Assert.assertNotNull(produtoResponseDTO5);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test29");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Double double1 = produto0.getPrecoCheio();
        java.lang.Object obj2 = null;
        boolean boolean3 = produto0.equals(obj2);
        java.lang.Double double4 = produto0.getPrecoDescontado();
        produto0.setId((java.lang.Long) 100L);
        java.lang.Double double7 = produto0.getPrecoCheio();
        org.junit.Assert.assertNull(double1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(double4);
        org.junit.Assert.assertNull(double7);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test30");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        produto0.setDescricao("");
        java.lang.Double double4 = produto0.getPrecoCheio();
        produto0.setId((java.lang.Long) 1L);
        produto0.setPrecoCheio((java.lang.Double) 10.0d);
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNull(double4);
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test31");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "", "Produto(id=null, sku=null, descricao=null, precoCheio=null, precoDescontado=null)", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test32");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO2 = produto0.toResponse();
        java.lang.String str3 = produto0.getDescricao();
        java.lang.Double double4 = produto0.getPrecoDescontado();
        java.lang.String str5 = produto0.getSku();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNotNull(produtoResponseDTO2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(double4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test33");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 10L, "Produto(id=-1, sku=null, descricao=null, precoCheio=null, precoDescontado=null)", "hi!", (java.lang.Double) 0.0d, (java.lang.Double) 1.0d);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test34");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 100L, "", "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)", (java.lang.Double) 0.0d, (java.lang.Double) 0.0d);
        produto5.setPrecoDescontado((java.lang.Double) 1.0d);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test35");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.String str3 = produto0.toString();
        produto0.setPrecoCheio((java.lang.Double) 10.0d);
        produto0.setPrecoDescontado((java.lang.Double) 1.0d);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test36");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Double double1 = produto0.getPrecoCheio();
        java.lang.Long long2 = produto0.getId();
        java.lang.String str3 = produto0.getDescricao();
        org.junit.Assert.assertNull(double1);
        org.junit.Assert.assertNull(long2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test37");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        produto0.setPrecoDescontado((java.lang.Double) 0.0d);
        produto0.setId((java.lang.Long) (-1L));
        produto0.setSku("Produto(id=null, sku=null, descricao=null, precoCheio=null, precoDescontado=null)");
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test38");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        java.lang.Double double6 = produto5.getPrecoCheio();
        java.lang.Long long7 = produto5.getId();
        com.seubone.sistemavendas.model.Produto produto13 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 100L, "", "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)", (java.lang.Double) 0.0d, (java.lang.Double) 0.0d);
        java.lang.Long long14 = produto13.getId();
        boolean boolean15 = produto5.equals((java.lang.Object) produto13);
        produto5.setPrecoCheio((java.lang.Double) 0.0d);
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 10.0d + "'", double6 == 10.0d);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
        org.junit.Assert.assertTrue("'" + long14 + "' != '" + 100L + "'", long14 == 100L);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test39");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        java.lang.Double double6 = produto5.getPrecoCheio();
        produto5.setId((java.lang.Long) 10L);
        boolean boolean10 = produto5.equals((java.lang.Object) '#');
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 10.0d + "'", double6 == 10.0d);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test40");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        java.lang.Double double6 = produto5.getPrecoCheio();
        produto5.setDescricao("Produto(id=-1, sku=null, descricao=null, precoCheio=null, precoDescontado=null)");
        produto5.setPrecoDescontado((java.lang.Double) 100.0d);
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 10.0d + "'", double6 == 10.0d);
    }

    @Test
    public void test41() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test41");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        produto0.setPrecoDescontado((java.lang.Double) 0.0d);
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO5 = produto0.toResponse();
        java.lang.Class<?> wildcardClass6 = produto0.getClass();
        org.junit.Assert.assertNotNull(produtoResponseDTO5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test42");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO2 = produto0.toResponse();
        produto0.setPrecoDescontado((java.lang.Double) 100.0d);
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNotNull(produtoResponseDTO2);
    }

    @Test
    public void test43() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test43");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.String str3 = produto0.toString();
        produto0.setPrecoCheio((java.lang.Double) 10.0d);
        produto0.setDescricao("Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)" + "'", str3, "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)");
    }

    @Test
    public void test44() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test44");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        java.lang.Double double2 = produto0.getPrecoDescontado();
        java.lang.Double double3 = produto0.getPrecoCheio();
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNull(double2);
        org.junit.Assert.assertNull(double3);
    }

    @Test
    public void test45() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test45");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 100L, "", "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)", (java.lang.Double) 0.0d, (java.lang.Double) 0.0d);
        java.lang.Long long6 = produto5.getId();
        produto5.setDescricao("");
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 100L + "'", long6 == 100L);
    }

    @Test
    public void test46() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test46");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        produto0.setDescricao("");
        java.lang.Double double3 = produto0.getPrecoCheio();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO4 = produto0.toResponse();
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto();
        produto5.setDescricao("");
        java.lang.Double double8 = produto5.getPrecoCheio();
        java.lang.String str9 = produto5.getDescricao();
        java.lang.String str10 = produto5.getDescricao();
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO11 = produto5.toResponse();
        boolean boolean12 = produto0.equals((java.lang.Object) produtoResponseDTO11);
        org.junit.Assert.assertNull(double3);
        org.junit.Assert.assertNotNull(produtoResponseDTO4);
        org.junit.Assert.assertNull(double8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertNotNull(produtoResponseDTO11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test47() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test47");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "Produto(id=0, sku=null, descricao=null, precoCheio=null, precoDescontado=null)", "Produto(id=0, sku=null, descricao=null, precoCheio=null, precoDescontado=null)", (java.lang.Double) 1.0d, (java.lang.Double) 100.0d);
    }

    @Test
    public void test48() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test48");
        com.seubone.sistemavendas.model.Produto produto5 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 0L, "hi!", "", (java.lang.Double) 10.0d, (java.lang.Double) 0.0d);
        java.lang.Double double6 = produto5.getPrecoCheio();
        java.lang.Long long7 = produto5.getId();
        com.seubone.sistemavendas.model.Produto produto13 = new com.seubone.sistemavendas.model.Produto((java.lang.Long) 100L, "", "Produto(id=null, sku=null, descricao=, precoCheio=null, precoDescontado=null)", (java.lang.Double) 0.0d, (java.lang.Double) 0.0d);
        java.lang.Long long14 = produto13.getId();
        boolean boolean15 = produto5.equals((java.lang.Object) produto13);
        produto5.setPrecoDescontado((java.lang.Double) 0.0d);
        com.seubone.sistemavendas.dto.ProdutoResponseDTO produtoResponseDTO18 = produto5.toResponse();
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 10.0d + "'", double6 == 10.0d);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
        org.junit.Assert.assertTrue("'" + long14 + "' != '" + 100L + "'", long14 == 100L);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(produtoResponseDTO18);
    }

    @Test
    public void test49() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test49");
        com.seubone.sistemavendas.model.Produto produto0 = new com.seubone.sistemavendas.model.Produto();
        java.lang.Long long1 = produto0.getId();
        java.lang.Double double2 = produto0.getPrecoDescontado();
        produto0.setId((java.lang.Long) (-1L));
        org.junit.Assert.assertNull(long1);
        org.junit.Assert.assertNull(double2);
    }
}

