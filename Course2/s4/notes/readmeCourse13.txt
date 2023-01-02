
Course13:

Sprint 1:
request: http://localhost:8080/restuarant/101

Restaurants:
[
	{
		id:"101",
		name:"abc",
		location:"PCMC"

	},
	{
		id:"102",
		name:"abc",
		location:"pune"

	},
	{
		id:"103",
		name:"abc",
		location:"pune"

	},

]


Restaurant1:
[
	{
		name:"chole bhature",
		price:"350"
	},
	{
		name:"pav bhaji",
		price:"350"
	},
]





************************************************************


Sprint2:

SpringBoot+Rest

RestFull services:  Backend / you can communicate without frontend

Postman

Method: get and post

crudRespository ---> will having some readymade methods classes 

database -->H2 database---> inmemory db --->system memory 

 Mysql ---> 


**********************************************************


http://localhost:8082/api/v1/user/xyz@gmail.com 

@PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String email) {
        return new ResponseEntity<>(userService.updateUser(user,email), HttpStatus.OK);
    }

@RequestBody User user:

user => 
{
        "email": "xyz@gmail.com",
        "password": "ps@123",
        "firstName": "pranu",
        "lastName": "sharma"
}


@PathVariable
email=xyz@gmail.com 


@ResponseBody: Object returns by controller that object automaticcaly seriallized into Json object


***********************************************************
Sprint 3: Mongo

storing data 
managing data ---> manipulate data 
accessing 
table format
structured 

Two types :

1.Structured Satabase --- mysql DB ---> have fixed shape 

Employee:  id,name,sal,address

emp1 id,name,sal,null
emp2 id,name,sal,null
emp3 id,name,sal,address



2.Unstructured Database --- mongo DB ---> every record can have different shape



*****************************************************************************************


structured database ---- > mysql,mssql,oracle,h2  ---->

operations:  

create db,table
insert
update
delete
retrive/fetch/get


we are going to perform all the operation with unstructured db (mongo db)

Mysql :
Database


*******************************************************


1.show dbs;
2.use database_name; 

ex: use wave30;

	it will switch database if database exist
	if db is not exits it will create new database

3.db.createCollection("book");

4.db.book.insertOne(
	{
		"bid":"101",
		"bookprice":"500",
		"bookname":"head fisrt java"
	})

5.db.book.find()
6.db.book.find().pretty()
7.db.book.insertMany(
	[{
		"bid":"103",
		"bookprice":"400",
		"bookname":"complete reference java"
	},
	{
		"bid":"104",
		"bookprice":"450",
		"bookname":"complete reference angular"
	},
	{
		"bid":"105",
		"bookprice":"550",
		"bookname":"complete reference css"
	}]
)
how to store array in collection

8.db.book.insertOne(	
	{
		"bid":"103",
		"bookprice":"400",
		"bookname":"complete reference java",
		"bookstore":["pcmc","mumbai","pune"]
	})

9. db.movie.insertOne(
	{
		"title":"Fight Club",
		"writer":"Chuck",
		"year":"1999",
		"actors":["Brad pit","Edward Norton"]
		
	})

select * from inventory where status="D";
select * from inventory where status in("A","D");


=   $eq
<   $lt
>   $gt
!=  $neq
<=  $lte
>=  $gte
in  $in
not $not
,   and
or  $or



Movie{

id,name,actors[]

}
price{
gold:"",silver:"",platinum:

}
//netsed/embedded values in collection

10.db.movie.insertOne(
	{
		"title":"DDLG",
		"writer":"Chuck",
		"year":"1985",
		"actors":["srk","kajol"],
		"price":{"Platinum":"500","gold":"400","Silver":"300"}
		
	})
*********************************************
sol:

db.hotels.insertOne({
"address":{
	"building":"001, h",
	"street":"highway drive",
	"zipcode":400697
},
"types_of_restauranr":"japanese",
"cusine":["sushi"],
"state":"tokio",
"grades":[
	{"date":new Date("2022-06-10"),"grade":"A", "score":40},
	{"date":new Date("2021-07-10"),"grade":"A", "score":70},
	{"date":new Date("2022-03-10"),"grade":"B", "score":40},
	{"date":new Date("2022-04-10"),"grade":"B", "score":10},
	{"date":new Date("2020-06-10"),"grade":"B", "score":10},
],
"name":"johnny depp",
"restaurant_id":"000023"
})

db.hotels.find({},{"restaurant_id":1,"name":1,"cuisine":1});

db.book.find({'grades.score':{$gte:90}});

db.hotels.find().pretty();

db.hotels.find({name:/^wil/},{"restaurant_id":1,"name":1,"cuisine":1,"state":1});

db.restraunt.find({$and:[{state:"Oklahoma"},{$or:[{cruisine:"American"},{cruisine:"Chinese"}]}]}).pretty();

*****************************************************************************************

Sprint 4:

1.Create SpringBoot application
 depencies: 	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

2.Create model class:
Customer:

@Document
public class Customer {

    @Id
    private int customerId;
    private String  customerName;
    private Address address;
}

Address:

public class Address {
    private int pin;
    private String street;
    private String city;


3. @Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

}

4.Service:
service interface : saveCustomer() ---- getalldata()
service impl class: Create implementation class with @Service

5.create controller class annotaed with @RestController and @ RequestBody

6.Create exception class
@ResposeStatus


@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Customer already exist")
public class CustomerAlreadyExistingException extends Exception {
}

7.Custome method in repo:
 @Query("{'address.city':{$eq:?0}}")//
    public List<Customer> findAllCustomerByCity(String city);


8.Application properties:

Server.port=65100
spring.data.mongodb.database=wave30
spring.data.mongodb.uri=mongodb://localhost:27017/
server.error.include-message=always




*************************************************************************
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Address {
    private int pin;
    private String street;
    private String city;
}

**SpringBoot dependency 
LOMBOK


