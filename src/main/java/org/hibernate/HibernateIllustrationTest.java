package org.hibernate;

/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.db.ConsumerEntity;
import org.hibernate.db.OrdersEntity;
import org.hibernate.db.SellorEntity;

import static java.lang.System.out;
import static java.time.LocalDateTime.now;

public class HibernateIllustrationTest {

    public static void main(String[] args) {
        // Створюємо конфігурацію Hibernate з файлу hibernate.properties
        SessionFactory sessionFactory = null;
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();

        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(SellorEntity.class)
                            .addAnnotatedClass(OrdersEntity.class)
                            .addAnnotatedClass(ConsumerEntity.class)
                            .buildMetadata()
                            .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        if (sessionFactory != null) {
            try {
                SellorEntity sellorEntity = new SellorEntity("Max");
                ConsumerEntity consumerEntity = new ConsumerEntity("Dan");
                sessionFactory.inTransaction(session -> {
                    session.persist(sellorEntity);
                    session.persist(consumerEntity);

                });
                sessionFactory.inTransaction(session ->
                        session.persist(new OrdersEntity("Books" , 3,sellorEntity,consumerEntity)
                                                ));

                // now lets pull events from the database and list them
                sessionFactory.inTransaction(session -> {
                    session.createSelectionQuery("from SellorEntity ", SellorEntity.class).getResultList()
                            .forEach(event -> out.println("Sellor name: " + event.getName() ));
                });
                sessionFactory.inTransaction(session -> {
                    session.createSelectionQuery("from ConsumerEntity ", ConsumerEntity.class).getResultList()
                            .forEach(event -> out.println("ConsumerEntity name: " + event.getName() ));
                });
                sessionFactory.inTransaction(session -> {
                    session.createSelectionQuery("from OrdersEntity ", OrdersEntity.class).getResultList()
                            .forEach(event -> out.println(event.getIdOrder() + " OrderEntity name: " + event.getTitle() + " amount: " + event.getAmount()));
                });
            } finally {
                sessionFactory.close();

            }
        }
    }
}