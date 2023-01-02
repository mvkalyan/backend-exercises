Spring boot app:  three layers

controller --> service --> repository --> DB


All three layers work diff---> diff way to test

junit,mockito

we are going with mock environment

mock environment ---> service and controller

dependent and dependancy

Repository is working with DB
Repository -- dependent
DB -- dependancy


Service is working Repository
Service -- dependent
Repository -- dependancy


Controller is working service
Controller  -- dependent
service -- dependancy


Test case for repository layer:

Repository is working with DB
Repository -- dependent
DB -- dependancy

@ExtendWith
@DataMongoTest



class Calculator{
	public int add(int n1,int n2){
		return n1+n2;
	}	
}

test file:

Calculator c;

@BeforeEach
public void init(){
	this.c=new Calculator();
}

@Test
public void testPositiveValue(){
	int result=c.add(3,5);
	assertEqual(8,result);

}

@AfterEach
public void clear(){
	this.c=null;
}



Test case for service layer:

Service is working Repository

Service -- dependent
Repository -- dependancy

Mockenvironment 


@ExtendWith(MockitoExtension.class)
@Mock---> used for dependency  --- > Repository
@InjectMocks ---> used for dependent object ---> Service


create mock environment:

saveCustomer()--- insert()

1.// when ever repo.findById(..) returns not found then only insertion should be done
	 when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
        
2.//when ever repo.insert(..) ---> return some object
when(customerRepository.insert(customer)).thenReturn(customer);

3.// if customerService saveCustomer(customer) return some object it is working fine
assertEquals(customer,customerService.saveCustomer(customer));


************************************************************************

Testing controller layer:

Controller is working service
Controller  -- dependent
service -- dependancy

@ExtendWith(MockitoExtension.class)

can create mockito environment ---> @Mock @InjectMocks


Http methods:

we didn't call controller method like normal methods.

Controller methods are called by using endpoint.


http://localhost:8082/api/v1/customer --- POST  --- addCustomer() of CustomerController

steps to test controller method:

1.@ExtendWith(MockitoExtension.class)
2.create required object

3.application may have diff controller so we need to specify controller.
That task can be perform in setup()

if you have 3 controller --- 3 mockmvc

4.if controller method called service.saveCustomer(),return customer object

5.
->how to call controller method --->  public ResponseEntity<?> addCustomer(@RequestBody Customer customer);
 
result--> success 

-> create post type of request
http://localhost:xxxx/customerdata/customer --- > POST

a. need to create post type of request
	/customerdata/customer

b.when request is raised with post type and JSON type data(customer object)
	i.e. we are making request by sending customer object

c.response can be JSON type customer object(need to write logic to convert java object to json object)

d.status must be created


result--> failuer

*************************************************************

Sprint 7:

To create logger we need to create aspect componet:

create class Aspect --- which having advisor

Aspect---- > collecton of advisor
Advisor ---->  monitoring methods --- addCustomer()

types of advisor  ---> Before,After,After returning,After throwing

advisor 1 -- runs before
advisor 2 -- after



--> on which method we running all this called pointcut

pointcut => defines on which methods you are going to enable advisor or 
which complete class you are going to apply advisor

joinpoint -> Represents a point in your application where you can plug in AOP aspect

What are the required things to ready to run class:

@Bean
@Component



steps:
1.add required dependancy
->starter-aop
->aspectJ weaver

2.create aspect class with required annotation
@Aspect @Component

3.create object of logger
4.create pointcut
5.create advisor
6.create logback.xml





















