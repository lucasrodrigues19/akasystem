package br.com.akasystem.akasales.resources;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.akasystem.akasales.entites.AKACategory;
import br.com.akasystem.akasales.entites.AKAOrder;
import br.com.akasystem.akasales.entites.AKAOrderItem;
import br.com.akasystem.akasales.entites.AKAPayament;
import br.com.akasystem.akasales.entites.AKAProduct;
import br.com.akasystem.akasales.entites.AKAProductXCategory;
import br.com.akasystem.akasales.entites.AKAUser;
import br.com.akasystem.akasales.entites.dto.AKACategoryDTO;
import br.com.akasystem.akasales.entites.dto.AKAOrderDTO;
import br.com.akasystem.akasales.entites.dto.AKAUserDTO;
import br.com.akasystem.akasales.entites.pk.AKAOrderItemPK;
import br.com.akasystem.akasales.entites.pk.AKAProductXCategoryPK;
import br.com.akasystem.akasales.enums.AKAOrderStatus;

@RequestMapping(value = "/home")
@Controller
public class HomeController {

	@GetMapping
	public String getHome(Model model) {
		//1 - user
		AKAUser u1 = new AKAUser();
		u1.setId("u1");
		u1.setName("Lucas");
		u1.setDtInsert(LocalDateTime.now());
		u1.setDtUpdate(LocalDateTime.now());
		u1.setIdInsert("0");
		u1.setIdUpdate("0");
		
		//2 - Categoria
		AKACategory c1 = new AKACategory();
		c1.setId("c1");
		c1.setName("eletronics");
		c1.setDtInsert(LocalDateTime.now());
		c1.setDtUpdate(LocalDateTime.now());
		c1.setIdInsert("0");
		c1.setIdUpdate("0");
		
		//3 - Produto
		AKAProduct p1 = new AKAProduct();
		p1.setId("p1");
		p1.setName("phone");
		p1.setDtInsert(LocalDateTime.now());
		p1.setDtUpdate(LocalDateTime.now());
		p1.setIdInsert("0");
		p1.setIdUpdate("0");
		
		AKAProduct p2 = new AKAProduct();
		p2.setId("p2");
		p2.setName("notebook");
		p2.setDtInsert(LocalDateTime.now());
		p2.setDtUpdate(LocalDateTime.now());
		p2.setIdInsert("0");
		p2.setIdUpdate("0");
		
		// 4 - Produto X Categoria
		AKAProductXCategory pc1 = new AKAProductXCategory();
		pc1.setId(new AKAProductXCategoryPK());
		pc1.setName("--");
		pc1.setDtInsert(LocalDateTime.now());
		pc1.setDtUpdate(LocalDateTime.now());
		pc1.setIdInsert("0");
		pc1.setIdUpdate("0");
		pc1.setAkaProduct(p1);
		pc1.setAkaCategory(c1);
		
		AKAProductXCategory pc2 = new AKAProductXCategory();
		pc2.setId(new AKAProductXCategoryPK());
		pc2.setName("--");
		pc2.setDtInsert(LocalDateTime.now());
		pc2.setDtUpdate(LocalDateTime.now());
		pc2.setIdInsert("0");
		pc2.setIdUpdate("0");
		pc1.setAkaProduct(p2);
		pc1.setAkaCategory(c1);
		
		//5 - setando estrutura do produto
		p1.setAkaCategorys(Stream.of(c1).collect(Collectors.toSet()));
		p2.setAkaCategorys(Stream.of(c1).collect(Collectors.toSet()));
		
		//6 - setando estrutura da categoria
		c1.setAkaProducts(Stream.of(p1,p2).collect(Collectors.toList()));
		
		//7 - pedido
		AKAOrder o1 = new AKAOrder();
		o1.setId("o1");
		o1.setName("phone");
		o1.setDtInsert(LocalDateTime.now());
		o1.setDtUpdate(LocalDateTime.now());
		o1.setIdInsert("u1");
		o1.setIdUpdate("u1");
		o1.setAkaOrderStatus(AKAOrderStatus.PAID);
		o1.setIdUser("u1");
		
		//8 - OrderItem
		AKAOrderItem oi1 = new AKAOrderItem();
		oi1.setId(new AKAOrderItemPK());
		oi1.setName("--");
		oi1.setDtInsert(LocalDateTime.now());
		oi1.setDtUpdate(LocalDateTime.now());
		oi1.setIdInsert("0");
		oi1.setIdUpdate("0");
		oi1.setAkaOrder(o1);
		oi1.setAkaProduct(p1);
		
		//OrderItem
		AKAOrderItem oi2 = new AKAOrderItem();
		oi2.setId(new AKAOrderItemPK());
		oi2.setName("--");
		oi2.setDtInsert(LocalDateTime.now());
		oi2.setDtUpdate(LocalDateTime.now());
		oi2.setIdInsert("0");
		oi2.setIdUpdate("0");
		oi2.setAkaOrder(o1);
		oi2.setAkaProduct(p1);
		

		//Pagamento
		AKAPayament pay1 = new AKAPayament();
		pay1.setId("pay1");
		pay1.setName("--");
		pay1.setDtInsert(LocalDateTime.now());
		pay1.setDtUpdate(LocalDateTime.now());
		pay1.setIdInsert("u1");
		pay1.setIdUpdate("u1");
		
		// 9 setando estruturas para o pedido
		o1.setAkaProducts(Stream.of(p1,p2).collect(Collectors.toList()));
		o1.setAkaOrderItems(Stream.of(oi1,oi2).collect(Collectors.toList()));
	    o1.setAkaPayament(pay1);
		
	    
	    //TODO 10 - preciso criar uma evolução para o pedido
		
	    
	    //11 crio os DTOS
	    AKAUserDTO userDTO = new AKAUserDTO(u1);
	    AKAOrderDTO orderDTO = new AKAOrderDTO(o1);
	    
	    model.addAttribute("user",userDTO);
	    model.addAttribute("listOrder",Stream.of(orderDTO).collect(Collectors.toList()));
		return "home";
	}
	
}
