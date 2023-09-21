package com.rahulshettyacademy.Courses;

import java.util.Map;

import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junitsupport.loader.VersionSelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.rahulshettyacademy.repository.CoursesRepository;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.StateChangeAction;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("CoursesCatalogue")
//@PactFolder("pacts")
@PactBroker(
	url="https://kiranmoypaul.pactflow.io/",
	authentication= @PactBrokerAuth(token="UFU6rm-beAO4-Xc2JPk7QQ")
	/*enablePendingPacts = "true",
	providerTags = "master"*/
)
public class PactProviderTest {
	@LocalServerPort
	public int port;
	@Autowired
	  CoursesRepository repository;
	
	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	public void pactVerificationTest(PactVerificationContext context){
		context.verifyInteraction();
	}
	@BeforeEach
	public void setup(PactVerificationContext context){
		context.setTarget(new HttpTestTarget("localhost",port));
	}
	@State(value= "courses exist",action= StateChangeAction.SETUP)
	public void coursesExist(){	}
	
	@State(value= "courses exist",action= StateChangeAction.TEARDOWN)
	public void coursesExistTearDown(){}


	//one last step- setup method- Appium - insert a record in test
	//teardown - appium
	
	//   -  /getCourseName/Appium () -> {name -appium, id="", price ="}
	//      /getCourseName/Appium - > { msg : course do not exist}
	
	@State(value= "appium course exists",action= StateChangeAction.SETUP)
	public void appiumCourseExist()	{ }
	
	@State(value= "appium course exists",action= StateChangeAction.TEARDOWN)
	public void appiumCourseExistTearDown(){}
	
	@State(value= "course appium not exists",action= StateChangeAction.SETUP)
	public void appiumCourseDoNotExist(Map<String,Object>params){
		
		/*String name =  (String)params.get("name");
		
		//to delete the appium record in database
		
		 
		    Optional<Courses> del =repository.findById(name);//mock
		    	
		    if (del.isPresent()) {
		    	repository.deleteById("Appium");
		    }*/
		
		
		
	}
	
	@State(value= "course appium not exists",action= StateChangeAction.TEARDOWN)
	public void appiumCourseDoNotExistTearDown(Map<String,Object>params){
		////add appium record in database
		/*String name =  (String)params.get("name");
		 Optional<Courses> del =repository.findById(name);//mock

		    if (!del.isPresent()) {

		    	Courses courses = new Courses();
		    	courses.setCourse_name("Appium");
		    	courses.setCategory("mobile");
		    	courses.setPrice(120);
		    	courses.setId("12");
		    	repository.save(courses);

	}
	*/
	
	
	
	
	}
	
	
}
