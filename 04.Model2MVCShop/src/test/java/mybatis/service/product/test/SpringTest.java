package mybatis.service.product.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

public class SpringTest {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("config/commonservice.xml");
		
		ProductService productService = (ProductService)factory.getBean("productServiceImpl");
		// TODO Auto-generated method stub
//		Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
//		
//		SqlSessionFactory sqlSessionFactory 
//											= new SqlSessionFactoryBuilder().build(reader);
//		
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		System.out.println("\n");
//		
//		ProductDAOImpl productDAO = new ProductDAOImpl();
//		productDAO.setSqlSession(sqlSession);
//		ProductServiceImpl service = new ProductServiceImpl();
//		service.setProductDAO(productDAO);
//		System.out.println("::: insert product ::: ");
//		Product product = new Product();
//		product.setProdName("감기약");
//		product.setProdDetail("으아아아아감기시러");
//		product.setPrice(5000);
//		productService.insertProduct(product);
////		dao.insertProduct(product);
//		service.insertProduct(product);
//		
////		sqlSession.insert("ProductMapper.insertProduct", product);
//		
		System.out.println("::: update product ::: ");
		Product product2 = new Product();
		product2.setProdDetail("게!뽀!린");
		product2.setProdNo(10060);
		productService.updateProduct(product2);
//		service.updateProduct(product2);
////		dao.updateProduct(product2);
////		
//////		sqlSession.update("ProductMapper.updateProduct", product);
////		
		System.out.println("::: get product :::");
		int prodNo = 10012;
//		Product prod = service.findProduct(prodNo);
		Product prod = productService.findProduct(prodNo);
////		Product prod = dao.findProduct(prodNo);
////////		Product prod = (Product)sqlSession.selectOne("ProductMapper.getProduct", prodNo);
		System.out.println(prod);
//////		
		System.out.println("::: getList product :::");
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("1");
		search.setSearchKeyword("%약%");
		System.out.println(search);
		System.out.println("\n");
////		Map<String, Object> map = dao.getProductList(search);
//		Map<String, Object> map = service.getProductList(search);
//		List<Product> list = productService.getProductList(search);
//		System.out.println(map.get("totalCount"));
//		System.out.println(map.get("productList"));
////		
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("::: getCount product :::");
//		int count = sqlSession.selectOne("ProductMapper.getCount", search);
//		map.put("totalCount", count);
//		System.out.println(count);
//		List<Product> list = sqlSession.selectList("ProductMapper.getProductList", search);
//		System.out.println("\n");
//		for(Product pro:list) {
//			System.out.println(pro);
//		}
//		map.put("productList", list);
	}

}
