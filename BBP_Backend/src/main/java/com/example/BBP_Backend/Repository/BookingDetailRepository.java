package com.example.BBP_Backend.Repository;

import com.example.BBP_Backend.Model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {
    @Query("SELECT u.phone AS userPhone, s.slotId FROM BookingDetail bd " +
            "JOIN MyTable t ON bd.table.tableId = t.tableId " +
            "JOIN Booking b ON bd.bookingId = b.bookingId " +
            "JOIN User u ON b.customerId = u.userId " +
            "JOIN Slot s ON s.slotId = bd.slotId " +
            "WHERE bd.table.tableId = :tableId AND bd.bookDate = :bookDate")
    List<Object[]> getTableBookingInfo(Integer tableId, Date bookDate);
}
