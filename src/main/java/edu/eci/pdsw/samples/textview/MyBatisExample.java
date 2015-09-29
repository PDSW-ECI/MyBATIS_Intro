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

import edu.eci.pdsw.samples.entities.DetallePedido;
import edu.eci.pdsw.samples.entities.Pedido;
import edu.eci.pdsw.samples.entities.Producto;
import edu.eci.pdsw.samples.mybatis.mappers.PedidoMapper;
import edu.eci.pdsw.samples.mybatis.mappers.ProductoMapper;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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

        PedidoMapper pedmp=sqlss.getMapper(PedidoMapper.class);
        ProductoMapper prodm=sqlss.getMapper(ProductoMapper.class);
        
        
        
        //DESCOMENTAR SÓLO PARA EL PUNTO 8
        /*
        Producto p1=prodm.selectProduct(1);
        Producto p2=prodm.selectProduct(2);
        Producto p3=prodm.selectProduct(3);
        
        
        //cambiar el código 112233 por su código de estudiante
        Pedido ped=new Pedido(112233,new Timestamp(new Date().getTime()));
        
        Set<DetallePedido> detped=new LinkedHashSet<>();
        detped.add(new DetallePedido(1,p1));
        detped.add(new DetallePedido(1,p2));
        detped.add(new DetallePedido(1,p3));
        
        ped.setDetallesPedido(detped);
        
        persistirPedido(ped);
        
        sqlss.commit();
        */
        
        sqlss.close();

        
        
    }

    /**
     * IMPLEMENTE ESTA OPERACIÓN HACIENDO USO DE LAS OPERACIONES
     * DEFINIDAS EN EL 'MAPPER' DE PEDIDO
     * 
     */
    public static void persistirPedido(SqlSession sqlss, Pedido p){
        PedidoMapper pedmp=sqlss.getMapper(PedidoMapper.class);
        
        
    }

}
