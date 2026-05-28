package se.lnu.receiptserver.repository;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import se.lnu.receiptserver.model.Order;
import se.lnu.receiptserver.model.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final DataSource dataSource;

    public OrderRepository(
            DataSource dataSource
    ) {

        this.dataSource = dataSource;
    }

    public Order getByOrderNumber(
            String orderNumber
    ) {

        Order order = null;

        String orderSql = """
            SELECT *
            FROM orders
            WHERE order_number = ?
        """;

        String itemsSql = """
            SELECT *
            FROM order_items
            WHERE order_id = ?
        """;

        try (
                Connection conn =
                        dataSource.getConnection()
        ) {

            PreparedStatement orderStmt =
                    conn.prepareStatement(orderSql);

            orderStmt.setString(
                    1,
                    orderNumber
            );

            ResultSet rs =
                    orderStmt.executeQuery();

            if (rs.next()) {

                order = new Order();

                order.setOrderId(
                        rs.getInt("order_id")
                );

                order.setOrderNumber(
                        rs.getString("order_number")
                );

                order.setTotalPrice(
                        rs.getDouble("total_price")
                );

                order.setOrderType(
                        rs.getString("order_type")
                );

                order.setStatus(
                        rs.getString("status")
                );

                order.setCreatedAt(
                        rs.getTimestamp("created_at")
                                .toLocalDateTime()
                );

                // Load items
                PreparedStatement itemStmt =
                        conn.prepareStatement(itemsSql);

                itemStmt.setInt(
                        1,
                        order.getOrderId()
                );

                ResultSet itemRs =
                        itemStmt.executeQuery();

                List<OrderItem> items =
                        new ArrayList<>();

                while (itemRs.next()) {

                    OrderItem item =
                            new OrderItem();

                    item.setItemName(
                            itemRs.getString("item_name")
                    );

                    item.setQuantity(
                            itemRs.getInt("quantity")
                    );

                    item.setTotalPrice(
                            itemRs.getDouble("base_price")
                    );

                    items.add(item);
                }

                order.setItems(items);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return order;
    }
}