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

@ExtendWith(MockitoExtension.class)













