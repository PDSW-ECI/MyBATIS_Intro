/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.textview;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        System.out.println("Valor total pedido 1:" + valorTotalPedido(sqlss, 1));

        List<String> prodsPedido = nombresProductosPedido(sqlss, 1);

        System.out.println("Productos del pedido 1:");
        System.out.println("-----------------------");
        for (String nomprod : prodsPedido) {
            System.out.println(nomprod);
        }
        System.out.println("-----------------------");

        int suCodigoECI = 20134423;
        registrarNuevoProducto(sqlss, suCodigoECI, "SU NOMBRE", 99999999);
        sqlss.commit();

        cambiarNombreProducto(sqlss, suCodigoECI, "EL NUEVO NOMBRE");
        sqlss.commit();

        sqlss.close();

    }

    /**
     * Agregar un nuevo producto con los parámetros dados
     *
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException
     */
    public static void registrarNuevoProducto(SqlSession session, int codigo, String nombre, int precio) throws SQLException {

        //Obtener el 'mapper' correspondiente
        //Invocar a la función del mapper
    }

    /**
     * Consultar los nombres de los productos asociados a un pedido
     *
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return
     */
    public static List<String> nombresProductosPedido(SqlSession session, int codigoPedido) {
        List<String> np = null;

        //Obtener el 'mapper' correspondiente
        //Invocar a la función del mapper
        return np;
    }

    /**
     * Calcular el costo total de un pedido
     *
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(SqlSession session, int codigoPedido) {

        //Obtener el 'mapper' correspondiente
        //Invocar a la función del mapper
        return 0;
    }

    /**
     * Cambiar el nombre de un producto
     *
     * @param con
     * @param codigoProducto codigo del producto cuyo nombre se cambiará
     * @param nuevoNombre el nuevo nombre a ser asignado
     */
    public static void cambiarNombreProducto(SqlSession session, int codigoProducto,
            String nuevoNombre) {

        //Obtener el 'mapper' correspondiente
        //Invocar a la función del mapper
    }

}
