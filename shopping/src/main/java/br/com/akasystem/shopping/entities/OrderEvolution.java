package br.com.akasystem.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import br.com.akasystem.shopping.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lucas Rodrigues
 * @since 2021/10/02
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "tborderevolution")
public class OrderEvolution extends SingleMainEntity {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "orderstatus", nullable = false, length = 80)
	private OrderStatus orderStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_orderxorderevolution"))
	private Order order;
}
