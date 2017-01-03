package com.test.domain.admin;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "adminuser")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String password;
	private Date createtime;

	/*
	 * @null 验证对象是否为空
	 * 
	 * @size (min=3, max=20, message="用户名长度只能在3-20之间")
	 * 
	 * @size (min=6, max=20, message="密码长度只能在6-20之间")
	 * 
	 * @pattern (regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}",
	 * message="邮件格式错误")
	 * 
	 * @Length(min = 5, max = 20, message = "用户名长度必须位于5到20之间")
	 * 
	 * @Email(message = "比如输入正确的邮箱")
	 * 
	 * @NotNull(message = "用户名称不能为空")
	 * 
	 * @Max(value = 100, message = "年龄不能大于100岁")
	 * 
	 * @Min(value= 18 ,message= "必须年满18岁！" )
	 * 
	 * @AssertTrue(message = "bln4 must is true")
	 * 
	 * 
	 * @AssertFalse(message = "blnf must is falase") //验证 boolean 对象是否为 false
	 * 
	 * @DecimalMax(value="100",message="decim最大值是100")
	 * DecimalMin(value="100",message="decim最小值是100")
	 * 
	 * @NotNull(message = "身份证不能为空")
	 * 
	 * @Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$",
	 * message="身份证格式错误")
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@NotEmpty(message = "姓名不能为空")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(message = "密码不能为空")
	@Length(min = 6, message = "密码长度不能小于6位")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", name=" + name + ", password=" + password + ", createtime=" + createtime + "]";
	}

}
