package mybatis.service.product.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDAOImpl;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class ServiceTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
		ProductDAOImpl productDAO = new ProductDAOImpl();
		productDAO.setSqlSession(sqlSession);
		ProductServiceImpl service = new ProductServiceImpl();
		service.setProductDAO(productDAO);
//		System.out.println("::: insert product ::: ");
//		Product product = new Product();
//		product.setProdName("∞ÌæÁ¿Ã¿Â≥≠∞®");
//		product.setProdDetail("»ÁµÈ»ÁµÈ¡„");
//		product.setPrice(3500);
////		dao.insertProduct(product);
//		service.insertProduct(product);
//		
////		sqlSession.insert("ProductMapper.insertProduct", product);
//		
		System.out.println("::: update product ::: ");
		Product product2 = new Product();
		product2.setProdDetail("¬Ô©ê¿Ã");
		product2.setProdNo(10059);
		service.updateProduct(product2);
//		dao.updateProduct(product2);
//		
////		sqlSession.update("ProductMapper.updateProduct", product);
//		
		System.out.println("::: get product :::");
		int prodNo = 10012;
		Product prod = service.findProduct(prodNo);
//		Product prod = dao.findProduct(prodNo);
//////		Product prod = (Product)sqlSession.selectOne("ProductMapper.getProduct", prodNo);
		System.out.println(prod);
////		
		System.out.println("::: getList product :::");
		Search search = new Search();
		search.setPageSize(3);
		search.setCurrentPage(2);
		search.setSearchCondition("");
//		search.setSearchKeyword("%∞ÌæÁ%");
		System.out.println(search);
//		Map<String, Object> map = dao.getProductList(search);
//		List<Product> list = service.getProductList(search);
//		System.out.println(map.get("totalCount"));
//		System.out.println(map.get("productList"));
//		for(Product pro:list) {
//			System.out.println(pro);
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("::: getCount product :::");
		int count = sqlSession.selectOne("ProductMapper.getCount", search);
//		map.put("totalCount", count);
		System.out.println(count);
//		List<Product> list = sqlSession.selectList("ProductMapper.getProductList", search);
//		map.put("productList", list);
	}

}
