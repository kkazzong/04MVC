package mybatis.service.product.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


public class SqlTest {

public static void main(String[] args) throws Exception{
		
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
//		System.out.println("::: insert product ::: ");
//		Product product = new Product();
//		product.setProdName("수지침");
//		product.setProdDetail("동글동글");
//		product.setPrice(3000);
//		product.setFileName("a.jpg");
//		
//		sqlSession.insert("ProductMapper.insertProduct", product);
		
//		System.out.println("::: update product ::: ");
//		Product product = new Product();
//		product.setProdDetail("업뎃확인");
//		product.setProdNo(10057);
//		sqlSession.update("ProductMapper.updateProduct", product);
		
//		System.out.println("::: get product :::");
//		int prodNo = 10012;
//		Product prod = (Product)sqlSession.selectOne("ProductMapper.getProduct", prodNo);
//		System.out.println(prod);
		
		System.out.println("::: getList product :::");
		Search search = new Search();
//		search.setSearchCondition("1");
//		search.setSearchKeyword("%자%");
//		search.setSearchKeywordPrice("");
		search.setSearchSoldProd("");
		search.setCurrentPage(1);
		search.setPageSize(3);
//		search.setSortCondition("");
//		search.setSortCondition2("desc");
		System.out.println(search);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("::: getCount product :::");
		int count = sqlSession.selectOne("ProductMapper.getCount", search);
//		map.put("totalCount", count);
		System.out.println(count);
		List<Product> list = sqlSession.selectList("ProductMapper.getProductList", search);
		for(Product pro:list) {
			System.out.println(pro);
		}
		System.out.println("total:::::::::"+list.size());
//		map.put("productList", list);
}

}
