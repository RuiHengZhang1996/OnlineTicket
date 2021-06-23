<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
     
    
<!DOCTYPE html>
<html>
<body>
<h1> FORM FOR COMPANY</h1>



<form action="CustomerForm.html" method="post">
<p>
What is your name? <input type="text" name="CustomerName" />
</p>
<p>
What is your phone number? <input type="text" name="Contact"/>
</p>
<p>
What is your address? <input type="text" name="Address"/>
</p>
<p>
What is your email address? <input type = "email" name = "email_address"/>				<!-- different type of data handled differently -->
</p>

<p>
What time did you want to depart? <input type = "date" name = "depart_date"/>				<!-- different type of data handled differently -->
</p>


<p>
What time did you want to return? <input type = "date" name = "return_date"/>				<!-- different type of data handled differently -->
</p>																<!-- some people dont want to return probably put an if statement here -->



<input type="submit" value="Submit this form by clicking here" />



</form>
</body>
</html>

<!-- String Name, String  Adress, Contact, Travel Date, Return Date  was the etc example -->

<!-- however our customer has different type of credentials  -->




<!--

//in the form this will be all inputed but it would be placed in different pojos 

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,							//yes
  `contact` varchar(45) DEFAULT NULL,						//yes
  `address` varchar(45) DEFAULT NULL,						//yes
  `ticket_id` int(11) default NULL,					//would be auto generated
  PRIMARY KEY (`id`),
  KEY `FK_TICKET_idx` (`ticket_id`),
  CONSTRAINT `FK_TICKET` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;







DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,					//would be auto generated
  `name` varchar(45) DEFAULT NULL,					//transfers
  `contact` varchar(45) DEFAULT NULL,						//transfers
  `address` varchar(45) DEFAULT NULL,					//transfers
  `email` varchar(45) DEFAULT NULL,					//email
  `travel_date` datetime,						//this would also be for the user to decide     (maybe the location is booked???)
  `return_date` datetime,							

  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CUSTOMER_idx` (`customer_id`),
  CONSTRAINT `FK_CUSTOMER_1` 
  FOREIGN KEY (`customer_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

 

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(45) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CUSTOMER_idx` (`customer_id`),
  CONSTRAINT `FK_CUSTOMER` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;





 -->