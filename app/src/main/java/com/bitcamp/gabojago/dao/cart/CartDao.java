package com.bitcamp.gabojago.dao.cart;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.bitcamp.gabojago.vo.OrderingInformation;

@Mapper
public interface CartDao {

  List<Map<String, String>> getCartList(String id);
	
  List<Map<String, String>> getCheckedCartList( @Param("id") String id, @Param("array") String [] exno);
  
  List<OrderingInformation> getOrderingInformation(@Param("array") String [] exno);
  
  void insertOrderingInformation(OrderingInformation info);
}
