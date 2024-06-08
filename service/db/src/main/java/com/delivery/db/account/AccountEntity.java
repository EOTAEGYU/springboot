package com.delivery.db.account;

import com.delivery.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder // 부모로 받은 변수도 상속 받겠다
@Data
@EqualsAndHashCode(callSuper = true) // 객체 비교할때 사용, 부모에 있는 값까지 포함해서 비교
@Builder
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

}
