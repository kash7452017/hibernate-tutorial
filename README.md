## JDBC (Java Database Connectivity)
>顧名思義，就是透過 Java 來連接資料庫的一種技術，它可以透過每個資料庫所對應的 JDBC Driver 來與資料庫進行連接，並透過 JDBC 的 API 來向所指定的資料庫發送想要執行的 SQL 命令。
>
>原文網址：https://medium.com/learning-from-jhipster/13-%E7%94%9A%E9%BA%BC%E6%98%AF-jdbc-orm-jpa-orm%E6%A1%86%E6%9E%B6-hibernate-c762a8c5e112

## Hibernate
>Hibernate 是一個開源免費的、基於 ORM 技術的 Java 持久化框架。通俗地說，Hibernate 是一個用來連接和操作資料庫的 Java 框架，它最大的優點是使用了 ORM 技術。
>
>Hibernate 支持幾乎所有主流的關係型資料庫，只要在配置文件中設置好當前正在使用的資料庫，程式設計師就不需要操心不同資料庫之間的差異。
>
>原文網址：https://kknews.cc/code/xb3vl2q.html

## Hibernate與JDBC區別
>原文網址：https://developer.aliyun.com/article/84352
>* 1、Hibernate和JDBC主要區別就是，Hibernate先檢索緩存中的映射對象( 即hibernate操作的是對象)，而jdbc則是直接操作數據庫.
>
>* 2、Hibernate是JDBC的輕量級的對象封裝，它是一個獨立的對象持久層框架。Hibernate可以用在任何JDBC可以使用的場合
>
>* 3、Hibernate是一個和JDBC密切關聯的框架，所以Hibernate的兼容性和JDBC驅動，和數據庫都有一定的關係，但是和使用它的Java程序，和App Server沒有任何關係，也不存在兼容性問題。
>
>* 4、如果正確的使用JDBC技術,它的執行效率一定比Hibernate要好,因為Hibernate是基於JDBC的技術.
>
>* 5、JDBC使用的是SQL語句，Hibernate使用的是HQL語句，但是HQL語句最終還會隱式轉換成SQL語句執行。

## ORM (Object-Relational Mapping)
>ORM，若是照著字義上來翻譯，那就是「物件關係的映射」，實際上它其實只是一種概念。
>
>ORM 是一種自動生成 SQL 語句的技術，它可以將對象中的數據自動存儲到資料庫中，也可以反過來將資料庫中的數據自動提取到對象中，整個過程不需要人工干預，避免了手寫 SQL 帶來的麻煩。

原文網址：https://kknews.cc/code/xb3vl2q.html

## JPA (Java Persistence API)
原文網址：https://medium.com/learning-from-jhipster/13-%E7%94%9A%E9%BA%BC%E6%98%AF-jdbc-orm-jpa-orm%E6%A1%86%E6%9E%B6-hibernate-c762a8c5e112
>以字義上來翻譯，JPA 就是「Java 持久化的 API」，但甚麼叫做持久化？
>
>對於 ORM 的概念來說，其最主要的想法就是可以簡易的將要儲存的資料從物件轉換為資料庫可以讀懂的格式，也可以簡易的將要從資料庫取出的資料映射成程式語言可以讀懂的物件型態。
>
>而在將資料「儲存」與「讀取」的過程，就稱之為「持久化」，也就是將資料從瞬時狀態改為持久狀態的一個過程。或者更白話一點的說，持久化就是將資料儲存到資料庫的一種過程。
>
>從上面的說明來理解，簡單的說「透過 Java 將資料儲存到資料庫的 API」就叫做 JPA。不過實際上 JPA 只是一種規範 (或者叫他 Interface) 而已。
>>使用 JPA 還有一個好處，那就是可以使用 JPQL (Java Persistence Query Language) 的命令語句向資料庫下命令語句，但 JPQL 與 SQL 最大的差異在於：
>>
>>* SQL在不同的資料庫中，有不同的 SQL 命令語句
>>* JPQL操作的對象不是著重在資料庫，而是著重在 JPA 的 Entity Object 下類似 SQL 的命令語句
>>
>>也就是說當使用 JPQL 的時候，並不會隨著不同的資料庫而需要做對應 SQL 語句修改。

**將屬性物件與表中欄位配置相互映射關係**
```
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)    
	private Date dateOfBirth;

	@Column(name="email")
	private String email;
	
	public Student()
	{
		
	}

	public Student(String firstName, String lastName, String email, Date theDateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = theDateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", dateOfBirth=" + DateUtils.formatDate(dateOfBirth) + "]";
	}
}
```
